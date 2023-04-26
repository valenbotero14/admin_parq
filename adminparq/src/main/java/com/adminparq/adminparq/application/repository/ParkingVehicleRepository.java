package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface ParkingVehicleRepository {

    List<ParkingVehicleEntity> getAllParkingVehicle();

    ParkingVehicle findById (Long id);

    ParkingVehicle save (ParkingVehicle parkingVehicle);

    void updateParkingVehicle (ParkingVehicle parkingVehicle);

    void deleteById (Long id);


}
