package com.hakangul.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = {"com.hakangul"})
@ComponentScan(basePackages = {"com.hakangul"})
@EnableJpaRepositories(basePackages = {"com.hakangul"})
// @PropertySource(value= "classpath:app.properties")
public class SpringJpaHibernateApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringJpaHibernateApplication.class, args);
    }
}