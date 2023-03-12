package com.adminparq.adminparq.infrastructure.config.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.adminparq.adminparq.infrastructure")
@EntityScan(basePackages = "com.adminparq.adminparq.domain")
public class AdminparqApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminparqApplication.class, args);
	}

}
