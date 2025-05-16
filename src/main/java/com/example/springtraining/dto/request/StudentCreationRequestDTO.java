package com.example.springtraining.dto.request;


public record StudentCreationRequestDTO(

        String id,
        String name,
        String dob,
        double average

) {}
