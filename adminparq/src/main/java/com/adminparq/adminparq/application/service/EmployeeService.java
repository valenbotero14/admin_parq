/**
 * the service layer (service) is used to encapsulate complex business logic that cannot be expressed in domain objects directly
 * intermediary between the presentation (UI) layer and the domain layer
 * transactions and coordinate events within the domain
 */

package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


/*
 * is used to generate a constructor that takes all fields marked with @NonNull as arguments.
 */
@RequiredArgsConstructor

/*
  is used to automatically generate the code for logging events in a Java class.
  Adds a logger to the class, allowing events to be logged to the application event log.
 */
@Slf4j

/*
 * is used to mark a class as a service component in an application.
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployee() {

        return employeeRepository.getAllEmployee();
    }


    public Employee getEmployee(Long id) {

        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);

    }

    public void updateEmployee(Employee existentEmployee) {

        employeeRepository.updateEmployee(existentEmployee);
    }

    public void deleteEmployee(long id) {

        employeeRepository.deleteById(id);
    }


}
