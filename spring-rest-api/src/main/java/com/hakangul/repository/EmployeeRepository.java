/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.hakangul.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hakangul.model.Employee;
import com.hakangul.model.UpdateEmployeeRequest;

/**
 *
 * @author hakangul
 */
@Repository
public class EmployeeRepository {

    private final List<Employee> employeeList;

    public EmployeeRepository(List<Employee> employeeList) {
        this.employeeList = new ArrayList<>(employeeList);
    }

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee saveEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployeeById(String id) {
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee updatEmployee(String id, UpdateEmployeeRequest updateEmployee) {
        Employee findEmp = findEmployeeById(id);
        if (findEmp != null) {
            deleteEmployeeById(id);
            Employee newEmployee = new Employee();
            newEmployee.setId(id);
            newEmployee.setFirstName(updateEmployee.getFirstName());
            newEmployee.setLastName(updateEmployee.getLastName());

            saveEmployee(newEmployee);
            return newEmployee;
        } else {
            return null;
        }
    }

    private Employee findEmployeeById(String id) {
        Employee findEmp = null;
        for (Employee employee : employeeList) {
            if (employee.getId().equals(id)) {
                findEmp = employee;
                break;
            }
        }

        return findEmp;
    }

    public Employee getEmployeeById(String id) {
        Employee findEmp = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmp = employee;
                break;
            }
        }

        return findEmp;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> filterEmployeeList = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }

        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)
                        && employee.getLastName().equalsIgnoreCase(lastName)) {
                    filterEmployeeList.add(employee);
                }
            }

            if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    filterEmployeeList.add(employee);
                }
            }

            if (firstName == null && lastName != null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    filterEmployeeList.add(employee);
                }
            }
        }

        return filterEmployeeList;
    }

}
