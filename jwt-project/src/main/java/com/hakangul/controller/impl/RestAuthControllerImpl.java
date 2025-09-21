package com.hakangul.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IRestAuthController;
import com.hakangul.jwt.AuthRequest;
import com.hakangul.jwt.AuthResponse;
import com.hakangul.model.dto.DtoUser;
import com.hakangul.service.IAuthService;

import jakarta.validation.Valid;

@RestController
public class RestAuthControllerImpl implements IRestAuthController {

    @Autowired
    private IAuthService authService;


    @PostMapping("/register")
    @Override
    public DtoUser register(@Valid @RequestBody AuthRequest request) {
        return authService.register(request);
    }


    @PostMapping("/authenticate")
    @Override
    public AuthResponse authenticate(@RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }


}
