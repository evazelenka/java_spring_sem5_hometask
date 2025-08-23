package com.example.java_spring_sem5_home_task.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Метод для обработки исключения HttpMessageNotReadableException.
     * @param ex перехваченое исключение.
     * @return сообщение об ошибке.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        return new ResponseEntity<>("Wrong Data! Nothing will be changed.", HttpStatus.BAD_REQUEST);
    }
}
