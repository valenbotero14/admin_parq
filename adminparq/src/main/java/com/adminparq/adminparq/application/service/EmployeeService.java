package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmployeeService {

  private final EmployeeRepository EmployeeRepository;

  public Employee getEmployee(Long id) {

    return EmployeeRepository.findById(id);
  }

  public Employee saveEmployee(Employee Employee) {

    return EmployeeRepository.save(Employee);

  }
}
