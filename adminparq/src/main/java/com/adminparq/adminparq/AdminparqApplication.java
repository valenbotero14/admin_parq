package com.adminparq.adminparq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = "com.adminparq.adminparq.controller") /*paquetes que se encuentran a nivel
del paquete y todos su hijos*/
@SpringBootApplication
public class AdminparqApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminparqApplication.class, args);
	}

}
