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
   /*Fuel4, Fuel2, Elect4, Elect2 */
   private String parkingType;

   /*Fuel4 (50), Fuel2 (60), Elect4 (10), Elect2 (10)*/
   private Integer capacity;


}
