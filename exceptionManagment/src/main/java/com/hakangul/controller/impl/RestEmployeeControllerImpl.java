package com.hakangul.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IRestEmployeeController;
import com.hakangul.dto.DtoEmployee;
import com.hakangul.model.RootEntity;
import com.hakangul.service.IEmployeeService;


@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements IRestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;



    @GetMapping("/list/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployeeById(@PathVariable Long id) {
        return ok(employeeService.finEmployeeById(id));
    }

    @GetMapping("/list2/{id}")
    @Override
    public RootEntity<DtoEmployee> findEmployeeById2(@PathVariable Long id) {
        return ok(employeeService.findEmployeeById2(id));
    }

    @GetMapping("/list")
    @Override
    public List<DtoEmployee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }


    @GetMapping("/list2")
    @Override
    public List<DtoEmployee> findAllEmployees2() {
        return employeeService.findAllEmployees2();
    }
     

}
