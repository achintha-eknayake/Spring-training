package com.example.springtraining.controller;

import com.example.springtraining.dto.request.StudentCreationRequestDTO;
import com.example.springtraining.dto.response.StudentResponseDTO;
import com.example.springtraining.exception.InvalidInputException;
import com.example.springtraining.exception.StudentNotFound;
import com.example.springtraining.exception.StudentNotFoundById;
import com.example.springtraining.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    Logger logger = Logger.getLogger(StudentController.class.getName());

    @GetMapping
    public List<StudentResponseDTO> getAllStudents(){
        if(studentService.isStudentsAreEmpty()){
            logger.info("There are no students");
            throw new StudentNotFound("There are no students");
        }
        logger.info("Getting all students");
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public  StudentResponseDTO getStudentById(@PathVariable String id){
        logger.info("Getting student with id:" + id);
        return studentService.getStudentById(id)
                    .orElseThrow(() -> new StudentNotFoundById("Student not found with given id:" + id));
    }

    @PostMapping
    public ResponseEntity<StudentResponseDTO> saveStudent(@RequestBody StudentCreationRequestDTO studentCreationRequestDTO){

        if(studentCreationRequestDTO.dob() == null || studentCreationRequestDTO.name() == null){
            logger.warning("DOB , Name is missing");
            throw new InvalidInputException("Invalid input , name / dob is missing");
        }
        logger.info("Saving student:" + studentCreationRequestDTO.name());
        StudentResponseDTO studentResponseDTO = studentService.saveStudent(studentCreationRequestDTO);
        return ResponseEntity.status(201).body(studentResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id){

        if(!studentService.isStudentExist(id)){
            logger.warning("Student was not found with given id: " + id);
            throw new StudentNotFoundById("Student not found with given id:" + id);
        }

        logger.info("Deleting student with id: " + id);
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
