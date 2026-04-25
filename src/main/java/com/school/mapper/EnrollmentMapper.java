package com.school.mapper;

import com.school.dto.response.EnrollmentResponse;
import com.school.model.Enrollment;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentMapper {

    public EnrollmentResponse toResponse(Enrollment enrollment) {
        EnrollmentResponse response = new EnrollmentResponse();
        response.setId(enrollment.getId());
        response.setStudentId(enrollment.getStudent().getId());
        response.setStudentName(enrollment.getStudent().getName());
        response.setTeacherId(enrollment.getTeacher().getId());
        response.setTeacherName(enrollment.getTeacher().getName());
        response.setEnrolledAt(enrollment.getEnrolledAt());
        response.setStatus(enrollment.getStatus());
        response.setGradeScore(enrollment.getGradeScore());
        response.setCreatedAt(enrollment.getCreatedAt());
        return response;
    }
}