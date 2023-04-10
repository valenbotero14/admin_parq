/**
 * What will be done with the data?
 */

package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;
import org.springframework.stereotype.Service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.EmployeeEntityMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

/*
 * annotation specifies the intent for the annotated class to be a business class.
 * Tells Spring to pick it up and put it in the application context.
 */
@Service
public class EmployeeDboRepository implements EmployeeRepository {

  private final SpringDataEmployeeRepository employeeRepository;

  private final EmployeeEntityMapper employeeMapper;


  @Override
  public List<EmployeeEntity> getAllEmployee() {

    return employeeRepository.findAll();
  }

  @Override
  public Employee findById(Long id) {

    return employeeMapper.toDomain(employeeRepository.findById(id).orElseThrow());
  }

  @Override
  public Employee save(Employee employee) {
    return employeeMapper.toDomain(employeeRepository.save(employeeMapper.toDbo(employee)));

  }

  @Override
  public void updateEmployee(Employee employee) {

      employeeMapper.toDomain(employeeRepository.save(employeeMapper.toDbo(employee)));
  }

  @Override
  public void deleteById(Long id) {

    employeeRepository.deleteById(id);

  }

}

