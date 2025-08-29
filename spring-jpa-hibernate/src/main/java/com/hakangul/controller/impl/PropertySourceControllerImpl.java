package com.hakangul.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.configuration.DataSource;
import com.hakangul.configuration.GlobalProperties;
import com.hakangul.configuration.Server;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceControllerImpl {

    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dtSource = new DataSource();

        return dtSource;
    }

    @GetMapping("/servers")
    public List<Server> getServers() {
        System.out.println("Key Value : " + globalProperties.getKey());
        return globalProperties.getServers();
    }
}
