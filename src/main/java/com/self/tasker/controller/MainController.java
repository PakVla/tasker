package com.self.tasker.controller;

import com.self.tasker.entity.TaskEntity;
import com.self.tasker.repository.TaskRepo;
import com.self.tasker.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

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

    @GetMapping("/userTasks")
    public String userTasks(@RequestParam (name = "id") Long id,@RequestParam (name = "completed", required = false, defaultValue = "null") String completed, Model model){
        List<TaskEntity> userTasks;
        if (Objects.equals(completed, "null")){
            userTasks = taskRepo.findByIdUserExecutor(id);
        } else {
            userTasks = taskRepo.findByIdUserExecutorAndCompleted(id, Boolean.parseBoolean(completed));
        }
        model.addAttribute("tasks", userTasks);
        return  "tasks";
    }

    @GetMapping("/allTasks")
    public String allTasks(@RequestParam (name = "completed",required = false, defaultValue = "null") String completed, Model model) {
        List<TaskEntity> allTasks;
        if (Objects.equals(completed, "null")){
            allTasks = (List<TaskEntity>) taskRepo.findAll();
        } else {
            allTasks = taskRepo.findByCompleted(Boolean.parseBoolean(completed));
        }
        model.addAttribute("tasks", allTasks);
        return "tasks";
    }

    @GetMapping("/userCreateTasks")
    public String userCreateTasks(@RequestParam (name = "id") Long id, @RequestParam (name = "completed", required = false, defaultValue = "null") String completed, Model model){
        List<TaskEntity> userCreateTasks;
        if (Objects.equals(completed, "null")){
            userCreateTasks = taskRepo.findByUserCreator(userRepo.findById(id));
        } else {
            userCreateTasks = taskRepo.findByUserCreatorAndCompleted(userRepo.findById(id), Boolean.parseBoolean(completed));
        }
        model.addAttribute("tasks", userCreateTasks);
        return  "tasks";
    }
}
