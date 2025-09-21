package com.hakangul.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IRestEmployeeController;
import com.hakangul.model.dto.DtoEmployee;
import com.hakangul.service.IEmployeeService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


@RestController
@RequestMapping("/employee")
public class RestEmployeeControllerImpl implements IRestEmployeeController{

    @Autowired
    private IEmployeeService employeeService;

    
    @GetMapping("/{id}")
    @Override
    public DtoEmployee finDtoEmployeeById(@Valid @NotNull @Positive @PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

}