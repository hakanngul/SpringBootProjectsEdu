package com.hakangul.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IEmployeeController;
import com.hakangul.dto.DtoEmployee;
import com.hakangul.service.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeController implements IEmployeeController{

    @Autowired
    private IEmployeeService employeeService;



    @GetMapping(path="/list")
    @Override
    public List<DtoEmployee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }


}
