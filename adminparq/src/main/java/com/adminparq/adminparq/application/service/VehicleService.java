package com.adminparq.adminparq.application.service;


import com.adminparq.adminparq.application.repository.VehicleRepository;
import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service

public class VehicleService {


    private final VehicleRepository vehicleRepository;

    public List<VehicleEntity> getAllVehicle() {

        return vehicleRepository.getAllVehicle();

    }

    public Vehicle getVehicle(Long id) {

        return vehicleRepository.findById(id);

    }

    public Vehicle findByPlate (String plate) {

        return vehicleRepository.findByPlate(plate);
    }

    public Vehicle saveVehicle(Vehicle vehicle) {

        return vehicleRepository.save(vehicle);

    }

    public void updateVehicle(Vehicle existentVehicle) {

        vehicleRepository.updateVehicle(existentVehicle);

    }

    public void deleteVehicle(Long id) {

        vehicleRepository.deleteById(id);

    }

}

