package com.hakangul.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.configuration.DataSource;
import com.hakangul.configuration.GlobalProperties;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceControllerImpl {

    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {
        DataSource dtSource = new DataSource();
        
        dtSource.setUrl(globalProperties.getUrl());
        dtSource.setUsername(globalProperties.getUsername());
        dtSource.setPassword(globalProperties.getPassword());       

        return dtSource;
    }
}
