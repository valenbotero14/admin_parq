package com.adminparq.adminparq.infrastructure.rest.spring.dto;

import com.adminparq.adminparq.infrastructure.db.springdata.dbo.ParkingEntity;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParkingVehicleDto {

    private Long id;

    private VehicleEntity vehicle;

    private ParkingEntity parking;

    private LocalDateTime timeEntrance;

    private LocalDateTime timeOutput;

    private Long totalTime;

    private Long totalPrice;


    public ParkingVehicleDto(String message) {
    }
}
