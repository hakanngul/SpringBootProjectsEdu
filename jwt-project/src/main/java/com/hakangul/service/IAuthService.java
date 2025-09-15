package com.hakangul.service;

import com.hakangul.jwt.AuthRequest;
import com.hakangul.model.dto.DtoUser;

public interface IAuthService {

    public DtoUser register(AuthRequest request);
}
