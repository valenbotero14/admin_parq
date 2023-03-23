/**
 * Que se va a hacer con los datos
 */

package com.adminparq.adminparq.infrastructure.db.springdata.repository;


import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;
import org.springframework.stereotype.Service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.mapper.EmployeeEntityMapper;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
/**
 * anotación especifica la intención de que la clase anotada sea una clase empresarial.
 * Le dice a Spring que lo recoja y lo introduzca en el contexto de la aplicación.
 */
@Service
public class EmployeeDboRepository implements EmployeeRepository {
  private final SpringDataEmployeeRepository EmployeeRepository;

  private final EmployeeEntityMapper EmployeeMapper;

  @Override
  public List<EmployeeEntity> getAllEmployee(){

    return EmployeeRepository.findAll();
  }


  @Override
  public Employee findById(Long id) {
    return EmployeeMapper.toDomain(EmployeeRepository.findById(id).orElseThrow());
  }

  /*@Override
  public EmployeeEntity updateEmployee(Employee employee, Long id){

    EmployeeEntity emplo
            = EmployeeRepository.findById(id).get();
    if (Objects.nonNull(employee.getName())
            && !"".equalsIgnoreCase(
            employee.getName())) {
      emplo.setName(
              employee.getName());
    }
    if (Objects.nonNull(employee.getUser())
            && !"".equalsIgnoreCase(
            employee.getUser())) {
      emplo.setUser(employee.getUser());
    }
    if (Objects.nonNull(employee.getPassword())
            && !"".equalsIgnoreCase(
            employee.getPassword())) {
      emplo.setPassword(
              employee.getPassword());
    }

    return EmployeeRepository.save(emplo);
  }*/



  @Override
  public Employee save(Employee Employee) {
    return EmployeeMapper.toDomain(EmployeeRepository.save(EmployeeMapper.toDbo(Employee)));

  }
  @Override
  public void deleteById(Long id){

    EmployeeRepository.deleteById(id);

  }

}
