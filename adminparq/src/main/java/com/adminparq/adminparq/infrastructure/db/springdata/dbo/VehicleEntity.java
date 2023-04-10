package com.adminparq.adminparq.infrastructure.db.springdata.dbo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor

public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic (optional = false)

    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column (name = "licence")
    private String licence;

    @Column (name = "vehicle_type")
    private String vehicleType;

    @Column (name = "tire")
    private String tire;

    @OneToMany(mappedBy = "vehicle")
    ParkingVehicleEntity parkingVehicle;
}
