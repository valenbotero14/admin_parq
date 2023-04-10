package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;

import java.util.List;

public interface VehicleRepository {

    List<VehicleEntity> getAllVehicle();

    Vehicle findById (Long id);


    Vehicle save (Vehicle  vehicle);


    void updateVehicle (Vehicle vehicle);


    void deleteById (Long id);

}
