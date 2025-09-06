package com.hakangul.controller;

import java.util.List;

import com.hakangul.dto.DtoEmployee;
import com.hakangul.model.RootEntity;

public interface IRestEmployeeController {

    public RootEntity<DtoEmployee> findEmployeeById(Long id);

    public RootEntity<DtoEmployee> findEmployeeById2(Long id);

    public List<DtoEmployee> findAllEmployees();

    public List<DtoEmployee> findAllEmployees2();
}
