package com.studantapp.backend.controller;

import com.studantapp.backend.dto.CreateStudentDTO;
import com.studantapp.backend.dto.StudentDTO;
import com.studantapp.backend.mapper.StudentMapper;
import com.studantapp.backend.model.Student;
import com.studantapp.backend.service.CloudinaryService;
import com.studantapp.backend.service.StudentService;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;
    private final CloudinaryService cloudinaryService;

    public StudentController(StudentService service, CloudinaryService cloudinaryService) {
        this.service = service;
        this.cloudinaryService = cloudinaryService;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StudentDTO> createStudent(@ModelAttribute CreateStudentDTO dto) throws IOException {
        String imageUrl = cloudinaryService.uploadImage(dto.getPhoto());
        Student student = StudentMapper.fromCreateDTO(dto);
        student.setPhotoUrl(imageUrl);

        Student saved = service.save(student);
        return ResponseEntity.ok(StudentMapper.toDTO(saved));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StudentDTO> updateStudent(
            @PathVariable Long id,
            @ModelAttribute CreateStudentDTO dto
    ) throws IOException {
        return service.findById(id)
                .map(existingStudent -> {
                    Student updatedStudent = StudentMapper.fromCreateDTO(dto);

                    if (dto.getPhoto() != null && !dto.getPhoto().isEmpty()) {
                        try {
                            String imageUrl = cloudinaryService.uploadImage(dto.getPhoto());
                            updatedStudent.setPhotoUrl(imageUrl);
                        } catch (IOException e) {
                            throw new RuntimeException("Erro ao fazer upload da imagem", e);
                        }
                    } else {
                        updatedStudent.setPhotoUrl(existingStudent.getPhotoUrl());
                    }

                    return service.updateStudent(id, updatedStudent)
                            .map(StudentMapper::toDTO)
                            .map(ResponseEntity::ok)
                            .orElse(ResponseEntity.notFound().build());
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/disciplines")
    public ResponseEntity<StudentDTO> assignDisciplines(
            @PathVariable Long id,
            @RequestBody List<Long> disciplineIds
    ) {
        return service.assignDisciplines(id, disciplineIds)
                .map(StudentMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
