package com.studantapp.backend.repository;

import com.studantapp.backend.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {}
