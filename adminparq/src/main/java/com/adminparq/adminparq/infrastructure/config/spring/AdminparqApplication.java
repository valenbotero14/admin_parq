package com.adminparq.adminparq.infrastructure.config.spring;

/*
 * Run the application - basic spring settings
 * Cores - check if they can communicate - exchange resources
 * Configuration - indicates that the decorated class is a configuration class used to declare one or more
 * EnableAutoConfiguration: tells Spring to automatically configure
 * your application based on the dependencies present in the classpath.
 * ComponentScan - Tells Spring to scan the specified package and log
 * all components annotated as beans in the context.
 * The SpringApplication class automatically starts our Spring Boot application from the main() method.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


/*
* mark the main class of the Spring Boot application
 */
@SpringBootApplication(scanBasePackages = "com.adminparq.adminparq.infrastructure")

/*
* scans the package and its subpackages to find Spring components like controllers, services, repositories, etc.
 */
@EntityScan(basePackages = "com.adminparq.adminparq.domain")
public class AdminparqApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminparqApplication.class, args);
    }

}
