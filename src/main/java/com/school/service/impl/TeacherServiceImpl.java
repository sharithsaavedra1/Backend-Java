package com.school.service.impl;

import com.school.dto.request.TeacherRequest;
import com.school.dto.response.TeacherResponse;
import com.school.exception.DuplicateResourceException;
import com.school.exception.ResourceNotFoundException;
import com.school.mapper.TeacherMapper;
import com.school.model.Teacher;
import com.school.repository.TeacherRepository;
import com.school.service.TeacherService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<TeacherResponse> findAll() {
        return teacherRepository.findAll().stream()
                .map(teacherMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TeacherResponse findById(Long id) {
        return teacherRepository.findById(id)
                .map(teacherMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado: " + id));
    }

    @Override
    public TeacherResponse create(TeacherRequest request) {
        if (teacherRepository.existsByEmail(request.getEmail())) {
            throw new DuplicateResourceException("Email ya existe: " + request.getEmail());
        }
        return teacherMapper.toResponse(teacherRepository.save(teacherMapper.toEntity(request)));
    }

    @Override
    public TeacherResponse update(Long id, TeacherRequest request) {
        Teacher existing = teacherRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado: " + id));
        teacherMapper.updateEntity(existing, request);
        return teacherMapper.toResponse(teacherRepository.save(existing));
    }

    @Override
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new ResourceNotFoundException("Profesor no encontrado: " + id);
        }
        teacherRepository.deleteById(id);
    }
}