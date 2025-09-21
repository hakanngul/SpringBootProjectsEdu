package com.hakangul.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.model.Department;
import com.hakangul.model.Employee;
import com.hakangul.model.dto.DtoDepartment;
import com.hakangul.model.dto.DtoEmployee;
import com.hakangul.repository.EmployeeRepository;
import com.hakangul.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public DtoEmployee findEmployeeById(Long id) {
        Optional<Employee> optional = employeeRepository.findById(id);
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        if(optional.isEmpty()){
            return null;
        }

        Employee employee = optional.get();
        Department department = employee.getDepartmant();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }

    private DtoEmployee findEmployeeByIdModelMapper(Long id) {
             return modelMapper.map(
            employeeRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"))
                , DtoEmployee.class);
    }


}
