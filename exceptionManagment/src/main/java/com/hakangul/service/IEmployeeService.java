package com.hakangul.service;

import java.util.List;

import com.hakangul.dto.DtoEmployee;

public interface IEmployeeService {

    public DtoEmployee finEmployeeById(Long id);

    public DtoEmployee findEmployeeById2(Long id);

    public List<DtoEmployee> findAllEmployees();

    public List<DtoEmployee> findAllEmployees2();

}
