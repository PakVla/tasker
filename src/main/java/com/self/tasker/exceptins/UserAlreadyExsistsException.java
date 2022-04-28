package com.self.tasker.exceptins;

public class UserAlreadyExsistsException extends Exception {
    public UserAlreadyExsistsException(String message) {
        super(message);
    }
}
