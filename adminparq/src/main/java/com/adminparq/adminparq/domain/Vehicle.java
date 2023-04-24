package com.adminparq.adminparq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {

    private Long id;

    private String plate;

    private String vehicleType;

    private String tire;


}
