package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.application.service.ParkingVehicleService;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingDto;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingVehicleDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingMapper;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingVehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController

public class ParkingVehicleResources {

    @Autowired
    private final ParkingVehicleService parkingVehicleService;

    @Autowired
    private final ParkingVehicleMapper parkingVehicleMapper;


    @GetMapping("listParkingVehicle")

    public List<ParkingVehicleEntity> getAllParkingVehicle() {

        return parkingVehicleService.getAllParkingVehicle();
    }

    @GetMapping("getParkingVehicleById/{id}")

    public ResponseEntity<ParkingVehicleDto> getParkingVehicleById(@PathVariable Long id) {

        return new ResponseEntity<>(parkingVehicleMapper.toDto(parkingVehicleService.getParkingVehicle(id)), HttpStatus.OK);

    }

    @PostMapping("parkingVehicle")

    public ResponseEntity<ParkingVehicleDto> saveParkingVehicle(@RequestBody ParkingVehicleDto parkingVehicleDto) {

        return new ResponseEntity<>(parkingVehicleMapper.toDto(parkingVehicleService.saveParkingVehicle(parkingVehicleMapper.toDomain( parkingVehicleDto ))),
                HttpStatus.CREATED );

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

}




