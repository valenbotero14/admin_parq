package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.repository.ParkingRepository;
import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.application.service.ParkingVehicleService;

import com.adminparq.adminparq.domain.ParkingVehicle;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;

import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingVehicleDto;

import com.adminparq.adminparq.infrastructure.rest.spring.dto.ResponseDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingVehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor

@RestController

public class ParkingVehicleResources {

    @Autowired
    private final ParkingVehicleService parkingVehicleService;

    @Autowired
    private final ParkingVehicleMapper parkingVehicleMapper;


    private final Map<Integer, ParkingVehicleDto> parkingCar = new HashMap<>(); //HashMap to store the cars in the parking lot

    @Autowired
    private final ParkingService parkingService;


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


    @PostMapping("parkingCar")
    public ResponseEntity<ParkingVehicleDto> saveParkingVehicle(@RequestBody ParkingVehicleDto parkingVehicleDto) {

        // Check if the car is already in the parking lot
        if (parkingCar.containsKey(parkingVehicleDto.getVehicle())) {
            return ResponseEntity.badRequest().build();
        }

        // Check if the parking lot has reached its maximum capacity
        int currentCapacity = parkingCar.size();
        if (currentCapacity >= parkingVehicleDto.getParking().getCapacity()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ParkingVehicleDto("Parking lot is full"));
        }

        //Add the car to the HashMap
        parkingCar.put(parkingVehicleDto.getVehicle(), parkingVehicleDto);

        return new ResponseEntity<>(parkingVehicleMapper.toDto(parkingVehicleService.saveParkingVehicle(parkingVehicleMapper.toDomain(parkingVehicleDto))),
                HttpStatus.CREATED);
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




