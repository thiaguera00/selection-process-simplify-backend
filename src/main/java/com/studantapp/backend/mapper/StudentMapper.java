package com.studantapp.backend.mapper;

import com.studantapp.backend.dto.CreateStudentDTO;
import com.studantapp.backend.dto.DisciplineDTO;
import com.studantapp.backend.dto.StudentDTO;
import com.studantapp.backend.model.Discipline;
import com.studantapp.backend.model.Student;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper {

    public static StudentDTO toDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setAge(student.getAge());
        dto.setRegistration(student.getRegistration());
        dto.setGpa(student.getGpa());
        dto.setStatus(student.getStatus());
        dto.setCourse(student.getCourse());
        dto.setProgress(student.getProgress());
        dto.setPhotoUrl(student.getPhotoUrl());

        Set<DisciplineDTO> disciplineDTOs =
                Optional.ofNullable(student.getDisciplines())
                        .orElse(new HashSet<>())
                        .stream()
                        .map(DisciplineMapper::toDTO)
                        .collect(Collectors.toSet());

        dto.setDisciplines(disciplineDTOs);

        return dto;
    }

    public static Student fromCreateDTO(CreateStudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setRegistration(dto.getRegistration());
        student.setGpa(dto.getGpa());
        student.setStatus(dto.getStatus());
        student.setCourse(dto.getCourse());
        student.setProgress(dto.getProgress());

        return student;
    }
}
