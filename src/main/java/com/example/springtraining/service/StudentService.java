package com.example.springtraining.service;

import com.example.springtraining.entity.Student;
import com.example.springtraining.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(String id){
        return studentRepository.findById(id).get();
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(String id){
        studentRepository.deleteById(id);
    }

    public boolean isStudentExist(String id){
        return studentRepository.existsById(id);
    }
}
