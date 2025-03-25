package com.studantapp.backend.dto;

import lombok.Data;

@Data
public class CreateStudentDTO {
    private String name;
    private int age;
    private String registration;
    private double gpa;
    private String status;
    private String course;
    private int progress;
    private String photoUrl;
}
