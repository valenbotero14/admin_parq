package com.adminparq.adminparq.infrastructure.rest.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  private Long id;

  private String name;

  private String user;

  private String password;

}
