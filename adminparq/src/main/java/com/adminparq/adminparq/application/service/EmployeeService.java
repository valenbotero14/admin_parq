package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor /*Genera un constructor con un parametro para cada campo que requiere
un manejo especial */
@Slf4j /*simple logging facade*/
@Service /*construir una clase de servicio que habitualmente se conecta a varios repositorios
y agrupa su funcionalidad */
public class EmployeeService {

  private final EmployeeRepository EmployeeRepository;

  public Employee getEmployee(Long id) {

    return EmployeeRepository.findById(id);
  }

  public Employee saveEmployee(Employee Employee) {

    return EmployeeRepository.save(Employee);

  }
}
