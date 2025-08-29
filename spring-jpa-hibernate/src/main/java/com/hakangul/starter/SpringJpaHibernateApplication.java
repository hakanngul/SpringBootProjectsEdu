package com.hakangul.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.hakangul.configuration.GlobalProperties;


@SpringBootApplication
@EntityScan(basePackages = {"com.hakangul"})
@ComponentScan(basePackages = {"com.hakangul"})
@EnableJpaRepositories(basePackages = {"com.hakangul"})
@EnableConfigurationProperties(value = GlobalProperties.class)
public class SpringJpaHibernateApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaHibernateApplication.class, args);
    }
}