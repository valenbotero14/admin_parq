package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.repository.ParkingVehicleRepository;
import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.application.service.ParkingVehicleService;

import com.adminparq.adminparq.application.service.VehicleService;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.domain.ParkingVehicle;

import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.repository.ParkingVehicleDboRepository;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingVehicleDto;

import com.adminparq.adminparq.infrastructure.rest.spring.dto.ResponseDto;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.VehicleDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingVehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@RestController

public class ParkingVehicleResources {

    @Autowired
    private final ParkingVehicleService parkingVehicleService;

    @Autowired
    private final ParkingVehicleMapper parkingVehicleMapper;

    @Autowired
    private final VehicleService vehicleService;

    @Autowired
    private final ParkingService parkingService;

    private final Map<VehicleEntity, ParkingVehicleDto> parkingCar = new HashMap<>(); //HashMap to store the cars in the parking lot




    @GetMapping("listParkingVehicle")

    public List<ParkingVehicleEntity> getAllParkingVehicle() {

        return parkingVehicleService.getAllParkingVehicle();
    }

    @GetMapping("getParkingVehicleById/{id}")

    public ResponseEntity<ParkingVehicleDto> getParkingVehicleById(@PathVariable Long id) {

        return new ResponseEntity<>(parkingVehicleMapper.toDto(parkingVehicleService.getParkingVehicle(id)), HttpStatus.OK);

    }


    @PutMapping("updateParkingVehicleById/{id}")

    public ParkingVehicle updateParkingVehicle(@PathVariable Long id, @RequestBody ParkingVehicle parkingVehicle) {

        ParkingVehicle existentParkingVehicle = parkingVehicleService.getParkingVehicle(id);

        existentParkingVehicle.setId(id);
        existentParkingVehicle.setVehicle(parkingVehicle.getVehicle());
        existentParkingVehicle.setParking(parkingVehicle.getParking());
        existentParkingVehicle.setTimeEntrance(parkingVehicle.getTimeEntrance());
        existentParkingVehicle.setTimeOutput(parkingVehicle.getTimeOutput());

        parkingVehicleService.updateParkingVehicle(existentParkingVehicle);


        return existentParkingVehicle;
    }

    @DeleteMapping("deleteParkingVehicleById/{id}")

    public String deleteParkingVehicle(@PathVariable Long id){

        parkingVehicleService.deleteParkingVehicle(id);
        return "ParkingVehicle number :"+id+" deleted successful";
    }


    @PostMapping("parkingVehicle")
    public ResponseEntity<ParkingVehicleDto> entranceParkingVehicle(@RequestBody ParkingVehicleDto parkingVehicleDto) {

        Vehicle vehicleType = vehicleService.getVehicle(parkingVehicleDto.getVehicle().getId());

        List<ParkingEntity> parking = parkingService.getAllParkingByParkingType(vehicleType.getVehicleType() + vehicleType.getWheels());

        int capacity = parking.size();
        int occupied = 0;

        for (int x = 0; x < capacity; x++) {

            List<ParkingVehicleEntity> parkingVehicle = parkingVehicleService.findAllByParkingId(parking.get(x).getId());

            List<ParkingVehicleEntity> parkingVehicleFilter = parkingVehicle.stream().filter(data -> data.getTimeOutput() == null).collect(Collectors.toList());

            occupied += parkingVehicleFilter.size();
        }

        if (parkingCar.containsKey(parkingVehicleDto.getVehicle())) {
            return ResponseEntity.badRequest().build();
        }

        if (capacity <= occupied) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

        parkingCar.put(parkingVehicleDto.getVehicle(), parkingVehicleDto);

        ParkingVehicle savedParkingVehicle = parkingVehicleService.saveParkingVehicle(parkingVehicleMapper.toDomain(parkingVehicleDto));
        ParkingVehicleDto savedParkingVehicleDto = parkingVehicleMapper.toDto(savedParkingVehicle);

        return new ResponseEntity<>(savedParkingVehicleDto, HttpStatus.CREATED);
    }



    @GetMapping("availableParking")
    public ResponseEntity<ResponseDto> availableParking(@RequestParam(defaultValue = "") String typeVehicle) {

        List<ParkingEntity> parkingData = parkingService.getAllParking();

        int countParking = parkingData.size();

        int occupiedSpaces = 0;

        int spaceInUse = 0;


        for (ParkingEntity parkingDatum : parkingData) {

            List<ParkingVehicleEntity> parkingVehicleEntity = parkingVehicleService.findAllByParkingId(parkingDatum.getId());

            for (int z = 0; z < parkingVehicleEntity.size(); z++) {

                if (parkingVehicleEntity.get(z).getTimeOutput() == null)  {

                    occupiedSpaces++;

                }
                if (parkingVehicleEntity.get(z).getTimeOutput() != null) {

                    spaceInUse++;

                }

            }


        }

        int availableSpaces = countParking - occupiedSpaces;

        return new ResponseEntity<>(new ResponseDto("Spaces available: " + availableSpaces + " Occupied spaces: " + occupiedSpaces + " Spaces in use: " + spaceInUse, 200), HttpStatus.OK);
    }




}




