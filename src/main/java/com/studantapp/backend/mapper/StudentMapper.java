package com.studantapp.backend.mapper;

import com.studantapp.backend.dto.CreateStudentDTO;
import com.studantapp.backend.dto.StudentDTO;
import com.studantapp.backend.model.Student;

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
        student.setPhotoUrl(dto.getPhotoUrl());
        return student;
    }
}
