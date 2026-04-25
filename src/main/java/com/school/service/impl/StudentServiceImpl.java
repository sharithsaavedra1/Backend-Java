package com.school.service.impl;

import com.school.dto.request.StudentRequest;
import com.school.dto.response.StudentResponse;
import com.school.exception.DuplicateResourceException;
import com.school.exception.ResourceNotFoundException;
import com.school.mapper.StudentMapper;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import com.school.service.StudentService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse findById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + id));
    }

    @Override
    public StudentResponse create(StudentRequest request) {
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email ya existe: " + request.getEmail());
        }
        return studentMapper.toResponse(studentRepository.save(studentMapper.toEntity(request)));
    }

    @Override
    public StudentResponse update(Long id, StudentRequest request) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estudiante no encontrado: " + id));
        studentMapper.updateEntity(existing, request);
        return studentMapper.toResponse(studentRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Estudiante no encontrado: " + id);
        }
        studentRepository.deleteById(id);
    }
}