package com.adminparq.adminparq.infrastructure.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ParkingVehicleDto {

    private Long id;

    private int vehicle;

    private int parking;

    private LocalDateTime timeEntrance;

    private LocalDateTime timeOutput;

}
