package com.self.tasker.controller;

import com.self.tasker.entity.TaskEntity;
import com.self.tasker.repository.TaskRepo;
import com.self.tasker.repository.UserRepo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/openTasks")
    public String openTasks(@RequestParam (name = "id") Long id, Model model){
        List<TaskEntity> tasks = taskRepo.findByUserCreator(userRepo.findById(id));
        model.addAttribute("tasks", tasks);
        return  "tasks";
    }

    @GetMapping("/closeTasks")
    public String closeTasks() {
        return  ""; }
}
