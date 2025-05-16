package com.example.springtraining.service;

import com.example.springtraining.dto.mapper.StudentMapper;
import com.example.springtraining.dto.request.StudentCreationRequestDTO;
import com.example.springtraining.dto.response.StudentResponseDTO;
import com.example.springtraining.entity.Student;
import com.example.springtraining.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {

    private  final StudentRepository studentRepository;

    Logger logger = Logger.getLogger(StudentService.class.getName());

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentResponseDTO> getAllStudents(){
        logger.info("Getting all students");
        return StudentMapper.toAllStudentResponseDTO(studentRepository.findAll());
    }

    public StudentResponseDTO getStudentById(String id){
        Student student = studentRepository.findById(id).get();
        logger.info("Getting student with id:" + id);
        return StudentMapper.toStudentResponseDTO(student);
    }

    public StudentResponseDTO saveStudent(StudentCreationRequestDTO studentCreationRequestDTO){
        Student student = StudentMapper.toStudent(studentCreationRequestDTO);
        logger.info("Saving student:" + student);
        studentRepository.save(student);
        StudentResponseDTO studentResponseDTO =StudentMapper.toStudentResponseDTO(student);
        return studentResponseDTO;
    }

    public void deleteStudent(String id){
        logger.info("Deleting student with id:" + id);
        studentRepository.deleteById(id);
    }

    public boolean isStudentExist(String id){
        logger.info("Checking if student with id:" + id + " exist");
        return studentRepository.existsById(id);
    }

    public boolean isStudentsAreEmpty() {
        logger.info("Checking if there are any students");
        return studentRepository.count() == 0 ;
    }
}
