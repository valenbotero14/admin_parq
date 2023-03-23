package com.adminparq.adminparq.infrastructure.config.spring;

/*Corre la aplicación - configuraciones basicas de spring*/
/*Cors - compara haber si se pueden comunicar - intercambiar recursos*/
/*@Configuration - indica que la clase decorada es una clase de configuracion utilizada para declarar uno o varios */
/*@EnableAutoConfiguration: le dice a Spring que configure automáticamente
su aplicación en función de las dependencias presentes en el classpath.*/
/*@ComponentScan: le dice a Spring que escanee el paquete especificado y registre
todos los componentes anotados como beans en el contexto.*/
/*SpringApplicationLa clase inicia automáticamente nuestra aplicación Spring Boot desde el método main().*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.adminparq.adminparq.infrastructure")
//@EnableJpaRepositories
@EntityScan(basePackages = "com.adminparq.adminparq.domain")
public class AdminparqApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminparqApplication.class, args);
    }

}
