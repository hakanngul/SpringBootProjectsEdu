package com.hakangul.controller;

import java.util.List;

import com.hakangul.dto.DtoEmployee;

public interface IEmployeeController {

    public List<DtoEmployee> findAllEmployees();
}
