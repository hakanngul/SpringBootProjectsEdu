package com.hakangul.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoDepartment;
import com.hakangul.dto.DtoEmployee;
import com.hakangul.entities.Employee;
import com.hakangul.repository.EmployeeRepository;
import com.hakangul.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<DtoEmployee> findAllEmployees() {
        List<Employee> empList = employeeRepository.findAll();
        List<DtoEmployee> dtoList = new ArrayList<>();

        if(empList != null && !empList.isEmpty()) {
            empList.forEach(employee -> {
                DtoEmployee dtoEmployee = new DtoEmployee();
                BeanUtils.copyProperties(employee, dtoEmployee);
                dtoEmployee.setDepartment(new DtoDepartment(employee.getDepartment().getId(), employee.getDepartment().getDepartmentName()));
                dtoList.add(dtoEmployee);
            });
        }

        return dtoList;
    }
    
}
