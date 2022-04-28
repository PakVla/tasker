package com.self.tasker.exceptins;

public class UserWrongPasswordException extends Exception{
    public UserWrongPasswordException(String message) {
        super(message);
    }
}
