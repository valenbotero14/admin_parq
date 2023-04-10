package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;

import java.util.List;

public interface ParkingRepository {

List<ParkingEntity> getAllParking();

Parking findById (Long id);


Parking save (Parking parking);


void updateParking (Parking parking);


void deleteById (Long id);

}
