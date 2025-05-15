package com.example.springtraining.controller;

import com.example.springtraining.entity.Student;
import com.example.springtraining.exception.StudentNotFound;
import com.example.springtraining.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){
        if(!studentService.isStudentExist(id)){
            throw new StudentNotFound("Student not found with given id:" + id);
        }
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
