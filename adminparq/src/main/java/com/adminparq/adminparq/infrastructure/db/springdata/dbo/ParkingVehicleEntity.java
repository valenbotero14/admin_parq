package com.adminparq.adminparq.infrastructure.db.springdata.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@Table(name = "parking_vehicle")
@Getter
@Setter
@NoArgsConstructor

public class ParkingVehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic (optional = false)

    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "vehicle_id")
    private int vehicle;

    @Column(name = "parking_id")
    private int parking;

    @Column (name = "time_entrance")
    private LocalDateTime timeEntrance;

    @Column (name = "time_output")
    private LocalDateTime timeOutput;


}
