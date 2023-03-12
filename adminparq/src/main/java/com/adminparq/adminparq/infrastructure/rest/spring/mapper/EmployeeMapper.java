package com.adminparq.adminparq.infrastructure.rest.spring.mapper;

import org.mapstruct.*;

import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.EmployeeDto;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
  EmployeeDto toDto (Employee Employee);

  Employee toDomain(EmployeeDto EmployeeDto);
}

