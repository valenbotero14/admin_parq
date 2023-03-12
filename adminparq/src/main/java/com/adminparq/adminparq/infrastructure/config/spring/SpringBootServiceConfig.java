package com.adminparq.adminparq.infrastructure.config.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.application.service.EmployeeService;

@Configuration
public class SpringBootServiceConfig {


  @Bean
  public EmployeeService EmployeeService(EmployeeRepository EmployeeRepository) {
    return new EmployeeService(EmployeeRepository);
  }
}