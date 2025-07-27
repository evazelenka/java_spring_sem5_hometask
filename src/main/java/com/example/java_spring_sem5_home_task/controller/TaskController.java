package com.example.java_spring_sem5_home_task.controller;

import com.example.java_spring_sem5_home_task.domain.Task;
import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import com.example.java_spring_sem5_home_task.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {


    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status){
        return taskService.getTasksByStatus(status);
    }

    @GetMapping("/get-status")
    public List<TaskStatus> getStatus(){
        return Arrays.stream(TaskStatus.values()).toList();
    }

    @PostMapping("/status/{id}/{status}")
    public void changeStatus(@PathVariable String status, @PathVariable int id){
        taskService.setStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }
}
