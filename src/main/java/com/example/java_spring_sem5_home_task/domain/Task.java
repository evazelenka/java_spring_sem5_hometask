package com.example.java_spring_sem5_home_task.domain;


import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

@Entity(name = "task")
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "date_of_create")
    private String date_of_create;

    public Task(String description) {
        this.description = description;
        status = TaskStatus.NOT_STARTED.status;
        date_of_create = LocalDate.now().toString();
    }

    public Task() {
        date_of_create = LocalDate.now().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_of_create() {
        return date_of_create;
    }

    public void setDate_of_create(String date) {
        this.date_of_create = date;
    }
}
