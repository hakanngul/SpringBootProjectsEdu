package com.hakangul.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hakangul.controller.IRestRefreshTokenController;
import com.hakangul.jwt.AuthResponse;
import com.hakangul.jwt.RefreshTokenRequest;
import com.hakangul.service.IRefreshTokenService;

@RestController
public class RestRefreshTokenControllerImpl implements IRestRefreshTokenController{

    @Autowired
    private IRefreshTokenService refreshTokenService;

    @Override
    public AuthResponse refreshToken(@RequestBody RefreshTokenRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'refreshToken'");
    }

}
