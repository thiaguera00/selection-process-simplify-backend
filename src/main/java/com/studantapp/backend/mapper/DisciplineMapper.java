package com.studantapp.backend.mapper;

import com.studantapp.backend.dto.CreateDisciplineDTO;
import com.studantapp.backend.dto.DisciplineDTO;
import com.studantapp.backend.model.Discipline;

public class DisciplineMapper {

    public static DisciplineDTO toDTO(Discipline discipline) {
        DisciplineDTO dto = new DisciplineDTO();
        dto.setId(discipline.getId());
        dto.setCode(discipline.getCode());
        dto.setName(discipline.getName());
        dto.setDepartment(discipline.getDepartment());
        dto.setCredits(discipline.getCredits());
        return dto;
    }

    public static Discipline fromCreateDTO(CreateDisciplineDTO dto) {
        Discipline discipline = new Discipline();
        discipline.setCode(dto.getCode());
        discipline.setName(dto.getName());
        discipline.setDepartment(dto.getDepartment());
        discipline.setCredits(dto.getCredits());
        return discipline;
    }
}
