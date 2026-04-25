package com.school.dto.request;

import jakarta.validation.constraints.*;

public class TeacherRequest {
    @NotBlank private String name;
    @NotBlank @Email private String email;
    @NotBlank private String subject;
    private String phone;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}