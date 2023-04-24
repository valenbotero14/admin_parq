package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingDto;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.VehicleDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.ParkingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequiredArgsConstructor

@RestController
public class ParkingResources {

    @Autowired
    private final ParkingService parkingService;

    @Autowired
    private final ParkingMapper parkingMapper;



    @GetMapping("listParking")
    public List<ParkingEntity> getAllParking() {

        return parkingService.getAllParking();
    }

    @GetMapping("getParkingById/{id}")
    public ResponseEntity<ParkingDto> getParkingById(@PathVariable Long id) {

        return new ResponseEntity<>(parkingMapper.toDto(parkingService.getParking(id)), HttpStatus.OK);

    }

    @PostMapping("parking")
    public ResponseEntity<ParkingDto> saveParking(@RequestBody ParkingDto parkingDto) {

        return new ResponseEntity<>(parkingMapper.toDto(parkingService.saveParking(parkingMapper.toDomain( parkingDto ))),
                HttpStatus.CREATED );

    }


    @PutMapping("updateParkingById/{id}")
    public Parking updateParking(@PathVariable Long id, @RequestBody Parking parking) {

        Parking existentParking = parkingService.getParking(id);

        existentParking.setId(id);
        existentParking.setParkingType(parking.getParkingType());

        parkingService.updateParking(existentParking);


        return existentParking;
    }

    @DeleteMapping("deleteParkingById/{id}")
    public String deleteParking(@PathVariable Long id){

        parkingService.deleteParking(id);
        return "Parking number :"+id+" deleted successful";
    }






}


