package com.example.springtraining.exception;

public class StudentNotFoundById extends RuntimeException {
    public StudentNotFoundById(String message) {
        super(message);
    }
}
