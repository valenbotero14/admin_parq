package com.adminparq.adminparq.domain;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParkingVehicle {

    private Long id;

    private int vehicle;

    private int parking;

    private LocalDateTime timeEntrance;

    private LocalDateTime timeOutput;


}
