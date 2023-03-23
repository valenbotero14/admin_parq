package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository {

    List<EmployeeEntity> getAllEmployee();


    Employee findById(Long id);

    Employee save(Employee Employee);

   /* EmployeeEntity updateEmployee(Employee Employee, Long id);*/


    void deleteById(Long id);


}
