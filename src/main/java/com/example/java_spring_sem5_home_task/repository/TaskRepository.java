package com.example.java_spring_sem5_home_task.repository;


import com.example.java_spring_sem5_home_task.domain.Task;
import com.example.java_spring_sem5_home_task.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    @Query("SELECT u FROM task u WHERE u.status = :status")
//    List<Task> findByStatus(@Param("status") String status);
//
    @Modifying
    @Query("UPDATE task t SET t.status = :status WHERE t.id = :id")
    void updateStatus(@Param("id") long id, @Param("status") TaskStatus status);

    List<Task> findByStatus(TaskStatus status);

}
