package com.studantapp.backend.service;

import com.studantapp.backend.model.Discipline;
import com.studantapp.backend.model.Student;
import com.studantapp.backend.repository.DisciplineRepository;
import com.studantapp.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private DisciplineRepository disciplineRepository;
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return repository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Optional<Student> updateStudent(Long id, Student updatedData) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedData.getName());
            existing.setAge(updatedData.getAge());
            existing.setRegistration(updatedData.getRegistration());
            existing.setCourse(updatedData.getCourse());
            existing.setStatus(updatedData.getStatus());
            existing.setGpa(updatedData.getGpa());
            existing.setProgress(updatedData.getProgress());
            existing.setPhotoUrl(updatedData.getPhotoUrl());

            return repository.save(existing);
        });
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Student> assignDisciplines(Long studentId, List<Long> disciplineIds) {
        return repository.findById(studentId).map(student -> {
            List<Discipline> disciplines = disciplineRepository.findAllById(disciplineIds);
            student.setDisciplines(new HashSet<>(disciplines));
            return repository.save(student);
        });
    }
}
