package com.adminparq.adminparq.infrastructure.config.spring;

/*Une el repositorio con el servicio*/

import com.adminparq.adminparq.application.repository.ParkingRepository;
import com.adminparq.adminparq.application.repository.VehicleRepository;
import com.adminparq.adminparq.application.service.ParkingService;
import com.adminparq.adminparq.application.service.VehicleService;
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

   /* @Bean
    public ParkingService ParkingService(ParkingRepository ParkingRepository) {
        return new ParkingService(ParkingRepository);
    }

    @Bean
    public VehicleService VehicleService(VehicleRepository VehicleRepository) {
        return new VehicleService(VehicleRepository);
    }*/
}