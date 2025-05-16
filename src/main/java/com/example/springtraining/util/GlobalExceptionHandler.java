package com.example.springtraining.util;

import com.example.springtraining.exception.InvalidInputException;
import com.example.springtraining.exception.StudentNotFound;
import com.example.springtraining.exception.StudentNotFoundById;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

    @ExceptionHandler(StudentNotFoundById.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFoundById exception){
        logger.warning("Student not found with given id");
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<String> handleInvalidInput(InvalidInputException invalidInputException){
        logger.warning("Invalid input");
        return ResponseEntity.status(400).body(invalidInputException.getMessage());
    }

    @ExceptionHandler(StudentNotFound.class)
    public ResponseEntity<String> handleStudentNotFound(StudentNotFound exception){
        logger.warning("Student not found");
        return ResponseEntity.status(404).body("No student found");
    }
}
