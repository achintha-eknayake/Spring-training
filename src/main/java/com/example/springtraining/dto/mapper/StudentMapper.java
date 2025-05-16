package com.example.springtraining.dto.mapper;

import com.example.springtraining.dto.request.StudentCreationRequestDTO;
import com.example.springtraining.dto.response.StudentResponseDTO;
import com.example.springtraining.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    // Convert Request DTO -> Entity
    public static Student toStudent(StudentCreationRequestDTO studentCreationRequestDTO){
        Student student = new Student();
        student.setName(studentCreationRequestDTO.name());
        student.setDOB(studentCreationRequestDTO.dob());
        student.setAverage(studentCreationRequestDTO.average());
        return student;
    }

    // Convert Entity -> Response DTO
    public static StudentResponseDTO toStudentResponseDTO(Student student){
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(student.getId(), student.getName(),student.getDOB(),student.getAverage());
        return studentResponseDTO;
    }

    public static List<StudentResponseDTO> toAllStudentResponseDTO(List<Student> students){

        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>() ;
        for(Student student : students){
            StudentResponseDTO  studentResponseDTO = StudentMapper.toStudentResponseDTO(student);
            studentResponseDTOS.add(studentResponseDTO);

        }
        return studentResponseDTOS;
    }
}
