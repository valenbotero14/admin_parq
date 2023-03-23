/**
 * Define guidelines for database
 */

package com.adminparq.adminparq.infrastructure.db.springdata.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
* lombok - spring boot annotations - libraries
 */
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration

/*
* enable JPA repository support
 */
@EnableJpaRepositories(
        basePackages = "com.adminparq.adminparq.infrastructure.db.springdata.repository")

/*
* bind external configuration properties to the fields of a class.
 */
@ConfigurationProperties("spring.datasource")

@Slf4j
@NoArgsConstructor
@Getter
@Setter


/*
* enable automatic auditing of JPA entities
 */
@EnableJpaAuditing
@EntityScan(basePackages = "com.adminparq.adminparq.infrastructure.db.springdata.dbo")

public class SpringDataConfig {


}
