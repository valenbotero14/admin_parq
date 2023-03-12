package com.adminparq.adminparq.application.repository;

import com.adminparq.adminparq.domain.Employee;

public interface EmployeeRepository {

   Employee findById(Long id);

   Employee save(Employee Employee);

}
