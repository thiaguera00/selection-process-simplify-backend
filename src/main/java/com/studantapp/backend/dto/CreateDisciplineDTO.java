package com.studantapp.backend.dto;

import lombok.Data;

@Data
public class CreateDisciplineDTO {
    private String code;
    private String name;
    private String department;
    private int credits;
}
