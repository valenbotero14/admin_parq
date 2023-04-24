package com.adminparq.adminparq.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Parking {

   private Long id;
   /*Fuel4, Fuel2, Elec4, Elec2 */
   private String parkingType;


}
