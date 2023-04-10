package com.adminparq.adminparq.infrastructure.rest.spring.mapper;

import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.VehicleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface VehicleMapper {

    VehicleDto toDto(Vehicle vehicle);

    Vehicle toDomain(VehicleDto vehicleDto);

}
