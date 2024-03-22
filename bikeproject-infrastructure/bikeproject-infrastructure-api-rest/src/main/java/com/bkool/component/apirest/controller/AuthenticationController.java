package com.bkool.component.apirest.controller;

import com.bkool.api.AuthApi;
import com.bkool.component.apirest.auth.User;
import com.bkool.component.apirest.auth.service.AuthService;
import com.bkool.component.apirest.auth.service.TokenService;
import com.bkool.model.AuthResponseDTO;
import com.bkool.model.UserCredentialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController implements AuthApi {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private final AuthService authService;

    @Override
    public ResponseEntity<AuthResponseDTO> authenticate(UserCredentialsDTO userCredentialsDTO) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCredentialsDTO.getUsername(),
                userCredentialsDTO.getPassword()));
        User user = authService.findByUserName(userCredentialsDTO.getUsername());
        String token = tokenService.authenticate(user);
        return ResponseEntity.ok().body(new AuthResponseDTO().token(token));
    }
}