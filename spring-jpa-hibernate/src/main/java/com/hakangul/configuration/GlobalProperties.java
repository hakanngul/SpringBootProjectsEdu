package com.hakangul.configuration;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class GlobalProperties {


    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String url;
}
