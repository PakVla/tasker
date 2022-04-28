package com.self.tasker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.self.tasker.exceptins.UserNotFoundException;
import com.self.tasker.exceptins.UserWrongPasswordException;
import com.self.tasker.models.User;
import com.self.tasker.service.JsonReformat;
import com.self.tasker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;

@Controller
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @GetMapping("/auth")
    public String authorization() {
        return "auth";
    }

    @PostMapping("/auth")
    public ResponseEntity authorization(@RequestBody String jsonString){
        try{
            HashMap jsonData = JsonReformat.toHashMap(jsonString);
            return ResponseEntity.ok(User.toModel(userService.authorization((String) jsonData.get("login"), (String) jsonData.get("password"))));
        } catch (UserNotFoundException | UserWrongPasswordException | JsonProcessingException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
