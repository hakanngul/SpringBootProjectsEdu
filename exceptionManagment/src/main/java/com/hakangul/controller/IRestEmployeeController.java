package com.hakangul.controller;

import java.util.List;

import com.hakangul.dto.DtoEmployee;

public interface IRestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);

    public List<DtoEmployee> findAllEmployees();

    public List<DtoEmployee> findAllEmployees2();
}
