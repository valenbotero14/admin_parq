package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.service.VehicleService;
import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;

import com.adminparq.adminparq.infrastructure.rest.spring.dto.VehicleDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
public class VehicleResources {


    @Autowired
    private final VehicleService vehicleService;

    @Autowired
    private final VehicleMapper vehicleMapper;


    @GetMapping("listVehicle")
    public List<VehicleEntity> getAllVehicle() {

        return vehicleService.getAllVehicle();
    }

    @GetMapping("getVehicleById/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable Long id) {

        return new ResponseEntity<>(vehicleMapper.toDto(vehicleService.getVehicle(id)), HttpStatus.OK);

    }

    /*Validate that the car exists in the db*/
    @GetMapping("getVehicleByPlate/{plate}")
    public ResponseEntity<VehicleDto> getVehicleByPlate(@PathVariable String plate) {

        return new ResponseEntity<>(vehicleMapper.toDto(vehicleService.findByPlate(plate)), HttpStatus.OK);

    }


    @PostMapping("vehicle")
    public ResponseEntity<VehicleDto> saveVehicle(@RequestBody VehicleDto vehicleDto) {

        return new ResponseEntity<>(vehicleMapper.toDto(vehicleService.saveVehicle(vehicleMapper.toDomain(vehicleDto))),
                HttpStatus.CREATED);

    }

    @PutMapping("updateVehicleById/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {

        Vehicle existentVehicle = vehicleService.getVehicle(id);

        existentVehicle.setId(id);
        existentVehicle.setPlate(vehicle.getPlate());
        existentVehicle.setVehicleType(vehicle.getVehicleType());
        existentVehicle.setWheels(vehicle.getWheels());

        vehicleService.updateVehicle(existentVehicle);


        return existentVehicle;
    }

    @DeleteMapping("deleteVehicleById/{id}")
    public String deleteVehicle(@PathVariable Long id) {

        vehicleService.deleteVehicle(id);
        return "Vehicle number :" + id + " deleted successful";
    }


}



