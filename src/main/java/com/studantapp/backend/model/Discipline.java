package com.studantapp.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;
    private String name;
    private String department;
    private int credits;

    @ManyToMany(mappedBy = "disciplines")
    private Set<Student> students;


}
