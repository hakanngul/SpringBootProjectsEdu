/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hakangul.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.model.Employee;
import com.hakangul.model.UpdateEmployeeRequest;
import com.hakangul.repository.EmployeeRepository;

/**
 *
 * @author hakangul
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployeeList() {
        return employeeRepository.getAllEmployeeList();
    }

    public Employee getEmployeeById(String id) {
        return employeeRepository.getEmployeeById(id);
    }
    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        return employeeRepository.getEmployeeWithParams(firstName, lastName);
    }

    public Employee saveEmployee(Employee newEmployee) {
        return employeeRepository.saveEmployee(newEmployee);
    }

    public boolean deleteEmployeeById(String id) {
        return employeeRepository.deleteEmployeeById(id);
    }

    public Employee updatEmployee(String id, UpdateEmployeeRequest updateEmployee) {
        return employeeRepository.updatEmployee(id, updateEmployee);
    }

}
