package com.bkool.component.postgresql.repository;

import com.bkool.component.postgresql.dao.UserDao;
import com.bkool.component.postgresql.entity.users.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPostgresqlRepository {

    private final UserDao userDao;

    public Optional<UserEntity> findByUserName(String username) {
        return userDao.findByUsername(username);
    }

    public void save(UserEntity userEntity) {
        userDao.save(userEntity);
    }
}
