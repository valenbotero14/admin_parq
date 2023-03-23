package com.adminparq.adminparq.application.service;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * /*Genera un constructor con un parametro para cada campo que requiere
 * un manejo especial
 */
@RequiredArgsConstructor

/**
 * simple logging facade
 */
@Slf4j

/**
 * construir una clase de servicio que habitualmente se conecta a varios repositorios
 * y agrupa su funcionalidad
 */
@Service

public class EmployeeService {

    private final EmployeeRepository EmployeeRepository;

    public List<EmployeeEntity> getAllEmployee(){

        return EmployeeRepository.getAllEmployee();
    }


    public Employee getEmployee(Long id) {

        return EmployeeRepository.findById(id);
    }

    /*public Employee updateEmployee(Employee employee, Long id){

        return EmployeeRepository.save(employee);
    }*/

    public Employee saveEmployee(Employee Employee) {

        return EmployeeRepository.save(Employee);

    }

    public void deleteEmployee(long id) {

        EmployeeRepository.deleteById(id);
    }

}
