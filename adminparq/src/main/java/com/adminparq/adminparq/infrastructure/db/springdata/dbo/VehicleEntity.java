package com.adminparq.adminparq.infrastructure.db.springdata.dbo;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @Column (name = "plate")
    private String plate;

    @Column (name = "vehicle_type")
    private String vehicleType;

    @Column (name = "wheels")
    private String wheels;

    public VehicleEntity(Long id) {
        this.id = id;
    }




}
