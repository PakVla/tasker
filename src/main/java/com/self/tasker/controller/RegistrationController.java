package com.self.tasker.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.self.tasker.exceptins.UserAlreadyExsistsException;
import com.self.tasker.service.JsonReformat;
import com.self.tasker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/reg")
    public String authorization() {
        return "reg";
    }

    @PostMapping("/reg")
    public ResponseEntity registration(@RequestBody String jsonString) throws JsonProcessingException, UserAlreadyExsistsException {
        try{
            return ResponseEntity.ok(userService.registration(JsonReformat.toUserEntity(jsonString)));
        } catch (UserAlreadyExsistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
