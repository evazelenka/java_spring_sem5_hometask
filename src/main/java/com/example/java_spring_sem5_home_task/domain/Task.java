package com.example.java_spring_sem5_home_task.domain;


import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "task")
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private LocalDateTime date_of_create;

    public Task(String description) {
        this.description = description;
        status = TaskStatus.NOT_STARTED;
    }

    public Task() {
    }
}
