package com.adminparq.adminparq.infrastructure.db.springdata.mapper;

import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")

public interface ParkingVehicleEntityMapper {

    ParkingVehicle toDomain (ParkingVehicleEntity parkingVehicleEntity);

    ParkingVehicleEntity toDbo (ParkingVehicle parkingVehicle);

}
