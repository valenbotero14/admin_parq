package com.adminparq.adminparq.infrastructure.db.springdata.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.EmployeeEntityMapper;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class EmployeeDboRepository implements EmployeeRepository {
  private final SpringDataEmployeeRepository EmployeeRepository;

  private final EmployeeEntityMapper EmployeeMapper;

  @Override
  public Employee findById(Long id) {
    return EmployeeMapper.toDomain(EmployeeRepository.findById(id).orElseThrow());
  }

  @Override
  public Employee save(Employee Employee) {
    return EmployeeMapper.toDomain(EmployeeRepository.save(EmployeeMapper.toDbo(Employee)));

  }
}
