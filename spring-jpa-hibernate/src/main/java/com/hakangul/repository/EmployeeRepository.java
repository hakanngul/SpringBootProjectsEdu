package com.hakangul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hakangul.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
