package com.adminparq.adminparq.infrastructure.db.springdata.mapper;

import com.adminparq.adminparq.domain.Vehicle;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleEntityMapper {

    Vehicle toDomain (VehicleEntity vehicleEntity);

    VehicleEntity toDbo (Vehicle vehicle);

}
