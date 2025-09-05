/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.hakangul.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author hakangul
 */
@EntityScan(basePackages = "com.hakangul")
@EnableJpaRepositories(basePackages = "com.hakangul")
@ComponentScan(basePackages = "com.hakangul")
@SpringBootApplication
public class ExceptionManagmentStarter {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionManagmentStarter.class, args);
    }
}
