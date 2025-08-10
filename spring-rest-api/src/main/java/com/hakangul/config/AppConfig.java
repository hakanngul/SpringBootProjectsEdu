
package com.hakangul.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hakangul.model.Employee;

/**
 *
 * @author hakangul
 */

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employees() {
        return List.of(
                new Employee("1", "Hakan", "Gul"),
                new Employee("2", "Melih", "Furkan"),
                new Employee("3", "Yusuf", "Bölüm"),
                new Employee("4", "Furkan", "Bölüm"),
                new Employee("5", "Hakan", "Atıcı"));
    }
}
