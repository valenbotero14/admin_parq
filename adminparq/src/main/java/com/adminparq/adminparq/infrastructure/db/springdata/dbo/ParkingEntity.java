package com.adminparq.adminparq.infrastructure.db.springdata.dbo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "parking")
@Getter
@Setter
@NoArgsConstructor

public class ParkingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic (optional = false)

    @Column (name = "id", unique = true, nullable = false)
    private Long id;

    @Column (name = "parking_type")
    private String parkingType;

    @Column (name = "capacity")
    private Integer capacity;

    /*deserialize the JSON object*/
    public ParkingEntity(Long id) {
        this.id = id;
    }


}
