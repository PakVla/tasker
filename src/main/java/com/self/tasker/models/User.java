package com.self.tasker.models;

import com.self.tasker.entity.UserEntity;

public class User {

    private Long id;
    private String login;
    private String lastName;
    private String firstName;
    private String patronymic;

    public User() {
    }

    public static User toModel (UserEntity entity){
        User model = new User();
        model.setId(entity.getId());
        model.setLogin(entity.getLogin());
        model.setFirstName(entity.getFirstName());
        model.setPatronymic(entity.getPatronymic());
        model.setLastName(entity.getLastName());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

}
