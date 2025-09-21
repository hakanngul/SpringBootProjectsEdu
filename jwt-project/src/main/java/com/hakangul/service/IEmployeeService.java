package com.hakangul.service;

import com.hakangul.model.dto.DtoEmployee;

public interface IEmployeeService {

    DtoEmployee findEmployeeById(Long id);
}
