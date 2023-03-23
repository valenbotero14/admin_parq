package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
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
/**
 * se utiliza para crear API RESTful. Es una combinación de anotaciones @Controller y @ResponseBody.
 */
@RestController
public class EmployeeResources {

    @Autowired
    private final EmployeeService EmployeeService;

    @Autowired
    private final EmployeeMapper EmployeeMapper;


    /**
     * Listar empleados
     */
    @GetMapping("listEmployee")
    public List<EmployeeEntity> getAllEmployee() {
        return EmployeeService.getAllEmployee();
    }


    /**
     * Obtener por el id
     */
    @GetMapping("getEmployeeById/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

        return new ResponseEntity<>(EmployeeMapper.toDto(EmployeeService.getEmployee(id)), HttpStatus.OK);

    }

    @PostMapping("employee")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto EmployeeDto) {

        return new ResponseEntity<>(EmployeeMapper.toDto(EmployeeService.saveEmployee(EmployeeMapper.toDomain(EmployeeDto))),
                HttpStatus.CREATED );

    }

    /*@PutMapping("updateEmployeeById/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long id){

        return EmployeeService.updateEmployee(employee, id);
    }*/

    @DeleteMapping("deleteEmployeeById/{id}")
    public String deleteEmployee(@PathVariable Long id){

        EmployeeService.deleteEmployee(id);
        return "Employee with ID :"+id+" is deleted";
    }

}
