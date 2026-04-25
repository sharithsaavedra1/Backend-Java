package com.school.dto.request;

import jakarta.validation.constraints.*;

public class EnrollmentRequest {
    @NotNull private Long studentId;
    @NotNull private Long teacherId;
    private String status;
    private Double gradeScore;

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getGradeScore() { return gradeScore; }
    public void setGradeScore(Double gradeScore) { this.gradeScore = gradeScore; }
}