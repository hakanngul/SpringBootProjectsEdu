package com.hakangul.controller;

import com.hakangul.jwt.AuthRequest;
import com.hakangul.jwt.AuthResponse;
import com.hakangul.model.dto.DtoUser;

public interface IRestAuthController {

    public DtoUser register(AuthRequest request);

    public AuthResponse authenticate(AuthRequest request);
}
