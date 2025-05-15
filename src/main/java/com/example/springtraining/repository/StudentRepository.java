package com.example.springtraining.repository;

import com.example.springtraining.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {

}
