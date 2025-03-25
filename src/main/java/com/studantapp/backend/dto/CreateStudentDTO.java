package com.studantapp.backend.dto;

import com.studantapp.backend.enums.StudentStatus;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateStudentDTO {
    private String name;
    private int age;
    private String registration;
    private double gpa;
    private StudentStatus status;
    private String course;
    private int progress;
    private MultipartFile photo;
}
