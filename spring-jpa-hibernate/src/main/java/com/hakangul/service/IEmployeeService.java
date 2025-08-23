package com.hakangul.service;

import java.util.List;

import com.hakangul.dto.DtoEmployee;

public interface IEmployeeService {

    public List<DtoEmployee> findAllEmployees();
}
