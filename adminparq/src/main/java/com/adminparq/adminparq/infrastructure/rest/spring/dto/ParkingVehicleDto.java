package com.adminparq.adminparq.infrastructure.rest.spring.dto;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParkingVehicleDto {

    private Long id;

    private VehicleEntity vehicle;

    private ParkingEntity parking;

    private Time timeEntrance;

    private Time timeOutput;

}
