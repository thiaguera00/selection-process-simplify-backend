package com.studantapp.backend;

import com.studantapp.backend.controller.StudentController;
import com.studantapp.backend.dto.CreateStudentDTO;
import com.studantapp.backend.dto.StudentDTO;
import com.studantapp.backend.model.Student;
import com.studantapp.backend.service.CloudinaryService;
import com.studantapp.backend.service.StudentService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StudentControllerTests {

    private StudentService studentService;
    private CloudinaryService cloudinaryService;
    private StudentController controller;

    @BeforeEach
    void setUp() {
        studentService = mock(StudentService.class);
        cloudinaryService = mock(CloudinaryService.class);
        controller = new StudentController(studentService, cloudinaryService);
    }

    @Test
    void testGetAllStudents() {
        when(studentService.findAll()).thenReturn(Collections.singletonList(new Student()));
        List<StudentDTO> result = controller.getAllStudents();
        assertEquals(1, result.size());
    }

    @Test
    void testGetStudentByIdFound() {
        Student student = new Student();
        student.setId(1L);
        when(studentService.findById(1L)).thenReturn(Optional.of(student));

        ResponseEntity<StudentDTO> response = controller.getStudentById(1L);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void testGetStudentByIdNotFound() {
        when(studentService.findById(2L)).thenReturn(Optional.empty());

        ResponseEntity<StudentDTO> response = controller.getStudentById(2L);
        assertTrue(response.getStatusCode().is4xxClientError());
    }

    @Test
    void testDeleteStudent() {
        doNothing().when(studentService).deleteById(1L);
        ResponseEntity<Void> response = controller.deleteStudent(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
