package com.example.java_spring_sem5_home_task.services;

import com.example.java_spring_sem5_home_task.domain.Task;
import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import com.example.java_spring_sem5_home_task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        checkStatus(task.getStatus());
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
    public List<Task> getTasksByStatus(String status){
        return repository.findByStatus(makeStatusCorrect(status));
    }


    /**
     * Метод для проверки статуса на корректностью
     * @param status статус задачи добавленный пользователем.
     * @return - отформатированный статус, либо измененный, если был передан неизвестный статус.
     */
    private String makeStatusCorrect(String status){
        String s = status.toUpperCase();
        if (status.equals(TaskStatus.IN_PROCESS.status)){
            return TaskStatus.IN_PROCESS.status;
        } else if (status.equals(TaskStatus.DONE.status)) {
            return TaskStatus.DONE.status;
        }
        return TaskStatus.NOT_STARTED.status;
    }

    /**
     * Изменение статуса задачи по id. Если передается некорректный статус, то задача не изменяется.
     * @param status новый статус задачи.
     * @param id  идентификатор задачи.
     */
    @Transactional
    public void setStatus(int id, String status){
        if(checkStatus(status)){
            repository.updateStatus(id, makeStatusCorrect(status));
        }
    }

    /**
     * Метод проверки статуса, полученного от пользователя.
     * @param status статус.
     * @return возвращает true, если пользователь ввел корректный статус.
     */
    private boolean checkStatus(String status) {
        String str = status.toUpperCase();
        TaskStatus st = Arrays.stream(TaskStatus.values()).toList().stream().filter(s -> s.status.equals(str)).findFirst().orElse(null);
        return st != null;
    }

    /**
     * Метод удаления задачи по id.
     * @param id идентификатор задачи.
     */
    public void deleteTask(long id){
        repository.deleteById(id);
    }
}
