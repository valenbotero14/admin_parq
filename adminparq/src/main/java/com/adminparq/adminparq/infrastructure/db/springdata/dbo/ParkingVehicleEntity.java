package com.adminparq.adminparq.infrastructure.db.springdata.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

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

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "vehicle_id")
    VehicleEntity vehicle;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "parking_id")
    ParkingEntity parking;

    @Column (name = "time_entrance")
    private Time timeEntrance;

    @Column (name = "time_output")
    private Time timeOutput;



}
