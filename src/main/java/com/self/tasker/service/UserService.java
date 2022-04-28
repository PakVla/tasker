package com.self.tasker.service;

import com.self.tasker.entity.UserEntity;
import com.self.tasker.exceptins.UserAlreadyExsistsException;
import com.self.tasker.exceptins.UserNotFoundException;
import com.self.tasker.exceptins.UserWrongPasswordException;
import com.self.tasker.models.User;
import com.self.tasker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity authorization(String login, String password) throws UserNotFoundException, UserWrongPasswordException{
        UserEntity user = userRepo.findByLogin(login);
        if (user == null){
            throw new UserNotFoundException("Пользователь с таким логином не найден");
        } else if (!Objects.equals(user.getPassword(), password)){
            throw new UserWrongPasswordException("Неверный пароль");
        }
        return user;
    }

    public User registration(UserEntity user) throws UserAlreadyExsistsException {
        if (userRepo.findByLogin(user.getLogin()) == null){
            return User.toModel(userRepo.save(user));
        } else {
            throw new UserAlreadyExsistsException("Пользователь с таким логином уже существует");
        }
    }
}
