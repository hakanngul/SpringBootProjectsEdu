package com.hakangul.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.jwt.AuthResponse;
import com.hakangul.jwt.JwtService;
import com.hakangul.jwt.RefreshTokenRequest;
import com.hakangul.model.RefreshToken;
import com.hakangul.model.User;
import com.hakangul.repository.RefreshTokenRepository;
import com.hakangul.service.IRefreshTokenService;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {


    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtService jwtService;

    public boolean isRefreshTokenExpired(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        Optional<RefreshToken> refOptional = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());

        if (refOptional.isEmpty()) { 
            System.out.println("REFRESH TOKEN GEÇERSİZDİR : "+ request.getRefreshToken());
        }
        RefreshToken refreshToken = refOptional.get();
        if(!isRefreshTokenExpired(refreshToken.getExpireDate()))
            System.out.println("Refresh Token Geçerlilik Süresi Dolmuştur.");

        String accessToken = jwtService.generateToken(refreshToken.getUser());
        RefreshToken savedRefreshToken =  refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }

}