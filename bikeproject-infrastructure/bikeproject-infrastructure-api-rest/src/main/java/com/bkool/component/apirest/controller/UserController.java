package com.bkool.component.apirest.controller;

import com.bkool.api.UsersApi;
import com.bkool.component.postgresql.entity.users.UserEntity;
import com.bkool.component.postgresql.repository.UserPostgresqlRepository;
import com.bkool.model.UserCredentialsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController implements UsersApi {

    private final UserPostgresqlRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<Void> register(UserCredentialsDTO userCredentialsDTO) {
        userRepository.save(UserEntity.builder()
                .password(passwordEncoder.encode(userCredentialsDTO.getPassword()))
                .username(userCredentialsDTO.getUsername())
                .build());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
