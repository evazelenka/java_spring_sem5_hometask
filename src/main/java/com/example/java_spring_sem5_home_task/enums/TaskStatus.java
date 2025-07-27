package com.example.java_spring_sem5_home_task.enums;

public enum TaskStatus {
    NOT_STARTED("not_started"), IN_PROCESS("in_process"), DONE("done");

    TaskStatus(String status) {
        this.status = status;
    }

    public String status;
}
