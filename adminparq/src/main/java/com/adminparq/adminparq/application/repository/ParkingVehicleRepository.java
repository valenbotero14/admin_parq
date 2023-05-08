package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;

import java.util.List;

public interface ParkingVehicleRepository {

    List<ParkingVehicleEntity> getAllParkingVehicle();

    ParkingVehicle findById (Long id);

    List<ParkingVehicleEntity> findAllByParkingId (Long id);


    ParkingVehicle save (ParkingVehicle parkingVehicle);

    void updateParkingVehicle (ParkingVehicle parkingVehicle);

    void deleteById (Long id);



}
