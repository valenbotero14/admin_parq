package com.adminparq.adminparq.infrastructure.db.springdata.mapper;

import com.adminparq.adminparq.domain.ParkingVehicle;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingVehicleEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")

public interface ParkingVehicleEntityMapper {

    ParkingVehicle toDomain(ParkingVehicleEntity parkingVehicleEntity);

    ParkingVehicleEntity toDbo(ParkingVehicle parkingVehicle);

}
