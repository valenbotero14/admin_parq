package com.adminparq.adminparq.infrastructure.rest.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminparq.adminparq.application.service.EmployeeService;
import com.adminparq.adminparq.infrastructure.rest.spring.dto.EmployeeDto;
import com.adminparq.adminparq.infrastructure.rest.spring.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class Resources {

  @Autowired
  private final EmployeeService EmployeeService;

  @Autowired
  private final EmployeeMapper EmployeeMapper;

  @GetMapping("getEmployeeById/{id}")
  public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {

    return new ResponseEntity<>(EmployeeMapper.toDto(EmployeeService.getEmployee(id)), HttpStatus.OK);

  }

  @PostMapping("employees")
  public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto EmployeeDto) {

    return new ResponseEntity<>(EmployeeMapper.toDto(EmployeeService.saveEmployee(EmployeeMapper.toDomain(EmployeeDto))),
        HttpStatus.CREATED);

  }

}
