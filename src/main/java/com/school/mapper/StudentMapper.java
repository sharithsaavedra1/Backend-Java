package com.school.mapper;

import com.school.dto.request.StudentRequest;
import com.school.dto.response.StudentResponse;
import com.school.model.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student toEntity(StudentRequest request) {
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setGrade(request.getGrade());
        student.setBirthDate(request.getBirthDate());
        return student;
    }

    public StudentResponse toResponse(Student student) {
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setEmail(student.getEmail());
        response.setGrade(student.getGrade());
        response.setBirthDate(student.getBirthDate());
        response.setCreatedAt(student.getCreatedAt());
        return response;
    }

    public void updateEntity(Student student, StudentRequest request) {
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setGrade(request.getGrade());
        student.setBirthDate(request.getBirthDate());
    }
}