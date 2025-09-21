package com.hakangul.controller;

import com.hakangul.jwt.AuthResponse;
import com.hakangul.jwt.RefreshTokenRequest;

public interface IRestRefreshTokenController {

    public AuthResponse refreshToken(RefreshTokenRequest request);
}
