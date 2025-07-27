package com.example.java_spring_sem5_home_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class JavaSpringSem5HomeTaskApplication {

	public static void main(String[] args) {
		System.out.println(LocalDate.now());
		SpringApplication.run(JavaSpringSem5HomeTaskApplication.class, args);
	}

}
