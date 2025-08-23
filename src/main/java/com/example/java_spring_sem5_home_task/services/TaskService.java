package com.example.java_spring_sem5_home_task.services;

import com.example.java_spring_sem5_home_task.domain.Task;
import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import com.example.java_spring_sem5_home_task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод добавления новой задачию
     * @param task задача.
     * @return - добавленная задача.
     */
    public Task addTask(Task task){
        task.setDate_of_create(LocalDateTime.now());
        if (task.getStatus() == null){
            task.setStatus(TaskStatus.NOT_STARTED);
        }
        return repository.save(task);
    }

    /**
     * Метод возвращает список всех задач.
     * @return - список задач.
     */
    public List<Task> findAll(){
        return repository.findAll();
    }

    /**
     * Метод возвращает список задач по статусу.
     * @param status статус задачи.
     * @return - список задач.
     */
    public List<Task> getTasksByStatus(TaskStatus status){
        return repository.findByStatus(status);
    }

    /**
     * Изменение статуса задачи по id. Если передается некорректный статус, то задача не изменяется.
     * @param status новый статус задачи.
     * @param id  идентификатор задачи.
     */
    @Transactional
    public void setStatus(long id, TaskStatus status){
        repository.updateStatus(id, status);
    }

    public Task findById(Long id){
        return repository.findById(id).orElse(null);
    }

    /**
     * Метод удаления задачи по id.
     * @param id идентификатор задачи.
     */
    public void deleteTask(long id){
        repository.deleteById(id);
    }
}
