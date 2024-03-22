package com.bkool.component.postgresql.dao;

import com.bkool.component.postgresql.entity.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
