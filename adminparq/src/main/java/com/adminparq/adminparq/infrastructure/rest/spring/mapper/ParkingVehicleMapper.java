package com.adminparq.adminparq.infrastructure.rest.spring.mapper;

import com.adminparq.adminparq.domain.ParkingVehicle;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingVehicleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ParkingVehicleMapper {


    ParkingVehicleDto toDto(ParkingVehicle parkingVehicle);

    ParkingVehicle toDomain(ParkingVehicleDto parkingVehicleDto);

}
