package com.self.tasker.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.self.tasker.entity.UserEntity;

import java.util.HashMap;

public class JsonReformat {
    public static HashMap toHashMap(String jsonString) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonString, HashMap.class);
    }

    public static UserEntity toUserEntity(String jsonString)throws JsonProcessingException{
        HashMap<String,String> userHashMap = new ObjectMapper().readValue(jsonString, HashMap.class);
        return new UserEntity(userHashMap.get("login"),
                userHashMap.get("password"),
                userHashMap.get("lastName"),
                userHashMap.get("firstName"),
                userHashMap.get("patronymic"),
                userHashMap.get("email"));
    }
}
