package com.school.service.impl;

import com.school.dto.request.EnrollmentRequest;
import com.school.dto.response.EnrollmentResponse;
import com.school.exception.ResourceNotFoundException;
import com.school.mapper.EnrollmentMapper;
import com.school.model.Enrollment;
import com.school.repository.EnrollmentRepository;
import com.school.repository.StudentRepository;
import com.school.repository.TeacherRepository;
import com.school.service.EnrollmentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImpl(EnrollmentRepository enrollmentRepository,
                                 StudentRepository studentRepository,
                                 TeacherRepository teacherRepository,
                                 EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    @Override
    public List<EnrollmentResponse> findAll() {
        return enrollmentRepository.findAll().stream()
                .map(enrollmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EnrollmentResponse findById(Long id) {
        return enrollmentRepository.findById(id)
                .map(enrollmentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada: " + id));
    }

    @Override
    public EnrollmentResponse create(EnrollmentRequest request) {
        var student = studentRepository.findById(request.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + request.getStudentId()));
        var teacher = teacherRepository.findById(request.getTeacherId())
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado: " + request.getTeacherId()));
        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setTeacher(teacher);
        enrollment.setStatus(request.getStatus() != null ? request.getStatus() : "active");
        enrollment.setGradeScore(request.getGradeScore());
        return enrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    public EnrollmentResponse update(Long id, EnrollmentRequest request) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matricula no encontrada: " + id));
        if (request.getStatus() != null) enrollment.setStatus(request.getStatus());
        if (request.getGradeScore() != null) enrollment.setGradeScore(request.getGradeScore());
        return enrollmentMapper.toResponse(enrollmentRepository.save(enrollment));
    }

    @Override
    public void delete(Long id) {
        if (!enrollmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Matricula no encontrada: " + id);
        }
        enrollmentRepository.deleteById(id);
    }
}