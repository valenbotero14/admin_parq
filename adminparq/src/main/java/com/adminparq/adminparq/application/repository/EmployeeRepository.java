/**
 * manages access and persistence of domain objects in a database
 * Interface between the domain layer and the infrastructure layer
 * Apply additional business rules during the persistence of domain objects
 */

package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {

    /**
     * List Employee
     */
    List<EmployeeEntity> getAllEmployee();

    /**
     * Search employee
     */
    Employee findById(Long id);

    /**
     * Save employee
     */
    Employee save(Employee employee);

    /**
     * Update employee
     */
    void updateEmployee(Employee employee);


    /**
     * Delete employee
     */
    void deleteById(Long id);


}
