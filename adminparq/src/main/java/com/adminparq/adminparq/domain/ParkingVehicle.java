package com.adminparq.adminparq.domain;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParkingVehicle {

    private Long id;

    private VehicleEntity vehicle;

    private ParkingEntity parking;

    private Time timeEntrance;

    private Time timeOutput;


}
