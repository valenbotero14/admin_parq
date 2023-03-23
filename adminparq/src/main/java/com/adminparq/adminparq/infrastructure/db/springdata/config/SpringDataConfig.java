package com.adminparq.adminparq.infrastructure.db.springdata.config;

/*Definir pautas para base de datos*/

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*lombok - anotaciones de spring boot - librerias*/
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.adminparq.adminparq.infrastructure.db.springdata.repository")
@ConfigurationProperties("spring.datasource")
@Slf4j
@NoArgsConstructor
@Getter
@Setter
@EnableJpaAuditing
@EntityScan(basePackages = "com.adminparq.adminparq.infrastructure.db.springdata.dbo")
public class SpringDataConfig {


}
