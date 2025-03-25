package com.studantapp.backend.dto;

import lombok.Data;

@Data
public class DisciplineDTO {
    private Long id;
    private String code;
    private String name;
    private String department;
    private int credits;
}
