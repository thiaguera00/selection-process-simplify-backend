package com.studantapp.backend.service;

import com.studantapp.backend.model.Discipline;
import com.studantapp.backend.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    private final DisciplineRepository repository;

    public DisciplineService(DisciplineRepository repository) {
        this.repository = repository;
    }

    public List<Discipline> findAll() {
        return repository.findAll();
    }

    public Optional<Discipline> findById(Long id) {
        return repository.findById(id);
    }

    public Discipline save(Discipline discipline) {
        return repository.save(discipline);
    }

    public Optional<Discipline> update(Long id, Discipline updated) {
        return repository.findById(id).map(existing -> {
            existing.setCode(updated.getCode());
            existing.setName(updated.getName());
            existing.setDepartment(updated.getDepartment());
            existing.setCredits(updated.getCredits());
            return repository.save(existing);
        });
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
