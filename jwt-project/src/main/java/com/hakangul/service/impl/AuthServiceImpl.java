package com.hakangul.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hakangul.jwt.AuthRequest;
import com.hakangul.jwt.AuthResponse;
import com.hakangul.jwt.JwtService;
import com.hakangul.model.User;
import com.hakangul.model.dto.DtoUser;
import com.hakangul.repository.UserRepository;
import com.hakangul.service.IAuthService;

@Service
public class AuthServiceImpl implements IAuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;



    @Override
    public AuthResponse authenticate(AuthRequest request) {
        try {
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());
            authenticationProvider.authenticate(auth);
            String token = jwtService.generateToken(userRepository.findByUsername(request.getUsername()).get());

            return new AuthResponse(token);
        } catch (AuthenticationException e) {
            System.out.println("Kullanıcı Adı veya Şifre Hatalı");
        }
        return null;
    }

    @Override
    public DtoUser register(AuthRequest request) {
        DtoUser dtoUser = new DtoUser();
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;
    }



}
