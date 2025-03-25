package com.studantapp.backend.controller;

import com.studantapp.backend.dto.CreateStudentDTO;
import com.studantapp.backend.dto.StudentDTO;
import com.studantapp.backend.mapper.StudentMapper;
import com.studantapp.backend.model.Student;
import com.studantapp.backend.service.StudentService;
import static com.studantapp.backend.mapper.StudentMapper.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentDTO> getAllStudents() {
        return service.findAll().stream()
                .map(StudentMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        return service.findById(id)
                .map(StudentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody CreateStudentDTO data) {
        Student created = service.save(fromCreateDTO(data));
        return ResponseEntity.ok(toDTO(created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id, @RequestBody CreateStudentDTO data) {
        return service.updateStudent(id, fromCreateDTO(data))
                .map(StudentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
