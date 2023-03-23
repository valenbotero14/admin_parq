package com.adminparq.adminparq.infrastructure.db.springdata.mapper;

/*Conexion de dbo infraestructura y los modelos del domain*/

import org.mapstruct.Mapper;

import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

@Mapper(componentModel = "spring")
public interface EmployeeEntityMapper {

  Employee toDomain(EmployeeEntity EmployeeEntity);

  EmployeeEntity toDbo(Employee Employee);


}
