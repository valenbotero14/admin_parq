package com.adminparq.adminparq.infrastructure.rest.spring.mapper;

import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.ParkingDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface ParkingMapper {

    ParkingDto toDto(Parking parking);

    Parking toDomain(ParkingDto parkingDto);


}
