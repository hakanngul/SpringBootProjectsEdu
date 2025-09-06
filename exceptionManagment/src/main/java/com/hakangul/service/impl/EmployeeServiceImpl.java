package com.hakangul.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoDepartment;
import com.hakangul.dto.DtoEmployee;
import com.hakangul.exception.BaseException;
import com.hakangul.exception.ErrorMessage;
import com.hakangul.exception.MessageType;
import com.hakangul.model.Department;
import com.hakangul.model.Employee;
import com.hakangul.repository.EmployeeRepository;
import com.hakangul.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DtoEmployee finEmployeeById(Long id) {
        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtoDepartment = new DtoDepartment();
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXITS, id.toString()));
        }
        Employee employee = optionalEmployee.get();
        Department department = employee.getDepartment();
        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department, dtoDepartment);

        dtoEmployee.setDepartment(dtoDepartment);

        return dtoEmployee;
    }


    @Override
    public DtoEmployee findEmployeeById2(Long id) {
        return modelMapper.map(
            employeeRepository
            .findById(id)
            .orElseThrow(
                () -> new BaseException(new ErrorMessage(MessageType.NOT_FOUND, id.toString() + " ModelMapper ile Yapıldı")))
                , DtoEmployee.class);
    }

    @Override
    public List<DtoEmployee> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        if (employees.isEmpty()) {
            return Collections.emptyList();
        }

        List<DtoEmployee> dtoEmployees = new ArrayList<>(employees.size());
        for (Employee employee : employees) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee, dtoEmployee);
            Department department = employee.getDepartment();
            if (department != null) {
                DtoDepartment dtoDepartment = new DtoDepartment();
                BeanUtils.copyProperties(department, dtoDepartment);
                dtoEmployee.setDepartment(dtoDepartment);
            }
            dtoEmployees.add(dtoEmployee);
        }
        return dtoEmployees;
    }

    @Override
    public List<DtoEmployee> findAllEmployees2() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(employee -> modelMapper.map(employee, DtoEmployee.class))
                .collect(Collectors.toList());

    }

}
