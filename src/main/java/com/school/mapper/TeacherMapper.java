package com.school.mapper;

import com.school.dto.request.TeacherRequest;
import com.school.dto.response.TeacherResponse;
import com.school.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setSubject(request.getSubject());
        teacher.setPhone(request.getPhone());
        return teacher;
    }

    public TeacherResponse toResponse(Teacher teacher) {
        TeacherResponse response = new TeacherResponse();
        response.setId(teacher.getId());
        response.setName(teacher.getName());
        response.setEmail(teacher.getEmail());
        response.setSubject(teacher.getSubject());
        response.setPhone(teacher.getPhone());
        response.setCreatedAt(teacher.getCreatedAt());
        return response;
    }

    public void updateEntity(Teacher teacher, TeacherRequest request) {
        teacher.setName(request.getName());
        teacher.setEmail(request.getEmail());
        teacher.setSubject(request.getSubject());
        teacher.setPhone(request.getPhone());
    }
}