package com.adminparq.adminparq.infrastructure.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleDto {

    private Long id;

    private String plate;

    private String vehicleType;

    private String tire;


}
