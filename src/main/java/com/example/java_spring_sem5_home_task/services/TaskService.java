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
        if (task.getStatus() != null){
            task.setStatus(makeStatusCorrect(task.getStatus()));
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
        return repository.findByStatus(makeStatusCorrect(status));
    }


    /**
     * Метод для проверки статуса на корректностью
     * @param s статус задачи добавленный пользователем.
     * @return - отформатированный статус, либо измененный, если был передан неизвестный статус.
     */
    private TaskStatus makeStatusCorrect(TaskStatus s){
        if (s != null) {
            if (s.equals(TaskStatus.IN_PROCESS)) {
                return TaskStatus.IN_PROCESS;
            } else if (s.equals(TaskStatus.DONE)) {
                return TaskStatus.DONE;
            }
        }
        return TaskStatus.NOT_STARTED;
    }

    /**
     * Изменение статуса задачи по id. Если передается некорректный статус, то задача не изменяется.
     * @param status новый статус задачи.
     * @param id  идентификатор задачи.
     */
    @Transactional
    public void setStatus(long id, TaskStatus status){
        repository.updateStatus(id, makeStatusCorrect(status));
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
