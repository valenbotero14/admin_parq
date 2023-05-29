/**
 * resources used by an application
 */

package com.adminparq.adminparq.infrastructure.rest.spring.resources;


import com.adminparq.adminparq.domain.Employee;
import com.adminparq.adminparq.infrastructure.db.springdata.dbo.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.adminparq.adminparq.application.service.EmployeeService;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.EmployeeDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;


import java.util.List;

@RequiredArgsConstructor

/*
 * used to create REST APIs. It is a combination of @Controller and @ResponseBody annotations
 */
@RestController
public class EmployeeResources {

    @Autowired
    private final EmployeeService employeeService;

    @Autowired
    private final EmployeeMapper employeeMapper;


    @GetMapping("listEmployee")
    public List<EmployeeEntity> getAllEmployee() {

        return employeeService.getAllEmployee();
    }

    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

        return new ResponseEntity<>(employeeMapper.toDto(employeeService.getEmployee(id)), HttpStatus.OK);

    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {

        return new ResponseEntity<>(employeeMapper.toDto(employeeService.saveEmployee(employeeMapper.toDomain(employeeDto))),
                HttpStatus.CREATED);

    }

    @PutMapping("updateEmployeeById/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {

        Employee existentEmployee = employeeService.getEmployee(id);

        existentEmployee.setId(id);
        existentEmployee.setName(employee.getName());
        existentEmployee.setUser(employee.getUser());
        existentEmployee.setPassword(employee.getPassword());

        employeeService.updateEmployee(existentEmployee);


        return existentEmployee;
    }

    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);
        return "Employee number :" + id + " deleted successful";
    }

}

