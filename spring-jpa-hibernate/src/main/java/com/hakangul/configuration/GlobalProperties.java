package com.hakangul.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {

    private List<Server> servers; //değişken izmi application.properties deki ile aynı olmalı

    @Value("${key}")
    private String key;
}
