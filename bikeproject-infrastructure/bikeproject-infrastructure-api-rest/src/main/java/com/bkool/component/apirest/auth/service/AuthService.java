package com.bkool.component.apirest.auth.service;

import com.bkool.component.apirest.auth.User;
import com.bkool.component.postgresql.entity.users.UserEntity;
import com.bkool.component.postgresql.repository.UserPostgresqlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserPostgresqlRepository userRepository;

    public User findByUserName(String username) {
        UserEntity byUserName = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        User user = new User();
        user.setUsername(byUserName.getUsername());
        user.setPassword(byUserName.getPassword());
        return user;
    }

}
