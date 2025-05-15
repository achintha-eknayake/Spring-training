package com.example.springtraining.util;

import com.example.springtraining.exception.StudentNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFound exception){
        logger.warning("Student not found with given id");
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
