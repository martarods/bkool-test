package com.bkool.component.apirest.auth.service;

import com.bkool.component.apirest.auth.User;
import com.bkool.component.postgresql.repository.UserPostgresqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final UserPostgresqlRepository userRepository;


    private final JwtService jwtService;

    public String authenticate(User user) {
        return jwtService.generateToken(user);
    }

}
