package com.school.service;

import com.school.dto.request.EnrollmentRequest;
import com.school.dto.response.EnrollmentResponse;
import java.util.List;

public interface EnrollmentService {
    List<EnrollmentResponse> findAll();
    EnrollmentResponse findById(Long id);
    EnrollmentResponse create(EnrollmentRequest request);
    EnrollmentResponse update(Long id, EnrollmentRequest request);
    void delete(Long id);
}