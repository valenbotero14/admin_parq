/**
 * is a pattern used to convert objects from one entity to another,
 * separating the mapping logic of the entity objects from the business logic.
 */

package com.adminparq.adminparq.infrastructure.db.springdata.mapper;

import org.mapstruct.Mapper;

import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

/*
 * automatically generate mapping implementations between objects
 */
@Mapper(componentModel = "spring")
public interface EmployeeEntityMapper {

    /*
     * two mapping methods
     */
    Employee toDomain(EmployeeEntity employeeEntity);

    EmployeeEntity toDbo(Employee employee);
}

