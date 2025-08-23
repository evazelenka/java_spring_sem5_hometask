package com.example.java_spring_sem5_home_task.controller;

import com.example.java_spring_sem5_home_task.domain.Task;
import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import com.example.java_spring_sem5_home_task.services.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
@Log
public class TaskController {

    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.findAll();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        log.info("add new task");
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }

    @GetMapping("/get-status")
    public List<TaskStatus> getStatus(){
        return Arrays.stream(TaskStatus.values()).toList();
    }

    @PostMapping("/status/{id}")
    public void changeStatus(@RequestBody Task task, @PathVariable long id){
        Task findTask = taskService.findById(id);
        if (findTask != null){
            taskService.setStatus(id, task.getStatus());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable long id){
        taskService.deleteTask(id);
    }
}
