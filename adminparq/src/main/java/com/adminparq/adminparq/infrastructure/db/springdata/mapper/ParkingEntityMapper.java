package com.adminparq.adminparq.infrastructure.db.springdata.mapper;


import com.adminparq.adminparq.domain.Parking;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ParkingEntityMapper {

    Parking toDomain (ParkingEntity parkingEntity);

    ParkingEntity toDbo (Parking parking);


}
