package com.example.springtraining.exception;

public class StudentNotFound extends RuntimeException {
    public StudentNotFound(String message) {
        super(message);
    }
}
