package com.hakangul.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.hakangul")
@EntityScan(basePackages = "com.hakangul")
@EnableJpaRepositories(basePackages = "com.hakangul")
@SpringBootApplication
public class JwtProjectStarter {

	public static void main(String[] args) {
		SpringApplication.run(JwtProjectStarter.class, args);
	}

}
