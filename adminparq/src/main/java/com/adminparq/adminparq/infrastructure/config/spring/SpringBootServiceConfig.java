/**
 * Join the repository with the service
 */

package com.adminparq.adminparq.infrastructure.config.spring;

import com.adminparq.adminparq.application.repository.ParkingRepository;
import com.adminparq.adminparq.application.repository.VehicleRepository;
import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.application.service.VehicleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.adminparq.adminparq.application.repository.EmployeeRepository;
import com.adminparq.adminparq.application.service.EmployeeService;

/*
* used to indicate that a class is a source of Spring bean definitions
 */
@Configuration
public class SpringBootServiceConfig {


    /*
    *it is used to declare methods that return objects that must be managed by the Spring container as beans.
     */
    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository) {
        return new EmployeeService(employeeRepository);
    }

   @Bean
    public ParkingService parkingService(ParkingRepository parkingRepository) {

        return new ParkingService(parkingRepository);

    }

   @Bean
    public VehicleService vehicleService(VehicleRepository vehicleRepository) {
        return new VehicleService(vehicleRepository);
    }
}