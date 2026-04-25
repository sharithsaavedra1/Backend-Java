package com.school.dto.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class StudentRequest {
    @NotBlank private String name;
    @NotBlank @Email private String email;
    @NotBlank private String grade;
    private LocalDate birthDate;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }
}