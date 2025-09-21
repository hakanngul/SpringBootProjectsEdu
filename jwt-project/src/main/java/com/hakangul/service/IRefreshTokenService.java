package com.hakangul.service;

import com.hakangul.jwt.AuthResponse;
import com.hakangul.jwt.RefreshTokenRequest;

public interface IRefreshTokenService {

    public AuthResponse refreshToken(RefreshTokenRequest request);
}
