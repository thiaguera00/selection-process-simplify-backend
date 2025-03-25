package com.studantapp.backend.dto;

import com.studantapp.backend.enums.StudentStatus;
import lombok.Data;

import java.util.Set;

@Data
public class StudentDTO {
    private Long id;
    private String name;
    private int age;
    private String registration;
    private double gpa;
    private StudentStatus status;
    private String course;
    private int progress;
    private String photoUrl;
    private Set<DisciplineDTO> disciplines;
}
