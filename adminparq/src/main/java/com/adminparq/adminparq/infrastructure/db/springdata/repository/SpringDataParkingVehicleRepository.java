package com.adminparq.adminparq.infrastructure.db.springdata.repository;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataParkingVehicleRepository  extends JpaRepository<ParkingVehicleEntity, Long> {



}
