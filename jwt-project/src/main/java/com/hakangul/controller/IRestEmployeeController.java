package com.hakangul.controller;

import org.springframework.web.bind.annotation.PathVariable;

import com.hakangul.model.dto.DtoEmployee;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public interface IRestEmployeeController {

    public DtoEmployee finDtoEmployeeById(@Valid @NotNull @Positive @PathVariable Long id);

}
