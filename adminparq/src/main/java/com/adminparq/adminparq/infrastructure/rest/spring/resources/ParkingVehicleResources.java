package com.adminparq.adminparq.infrastructure.rest.spring.resources;


import com.adminparq.adminparq.application.repository.VehicleRepository;
import com.adminparq.adminparq.application.service.ParkingVehicleService;

import com.adminparq.adminparq.domain.ParkingVehicle;

import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.repository.SpringDataVehicleRepository;
import com.adminparq.adminparq.infrastructure.db.springdata.repository.VehicleDboRepository;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingDto;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingVehicleDto;

import com.adminparq.adminparq.infrastructure.rest.spring.dto.VehicleDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingVehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        //Add the cart to the HashMap
        parkingCar.put(parkingVehicleDto.getVehicle(), parkingVehicleDto);

        return new ResponseEntity<>(parkingVehicleMapper.toDto(parkingVehicleService.saveParkingVehicle(parkingVehicleMapper.toDomain(parkingVehicleDto))),
                HttpStatus.CREATED);

    }
}




