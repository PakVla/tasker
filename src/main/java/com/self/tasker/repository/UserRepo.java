package com.self.tasker.repository;

import com.self.tasker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByLogin(Object login);
}
