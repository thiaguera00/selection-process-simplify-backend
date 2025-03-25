package com.studantapp.backend.controller;

import com.studantapp.backend.dto.CreateDisciplineDTO;
import com.studantapp.backend.dto.DisciplineDTO;
import com.studantapp.backend.mapper.DisciplineMapper;
import com.studantapp.backend.model.Discipline;
import com.studantapp.backend.service.DisciplineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.studantapp.backend.mapper.DisciplineMapper.*;

@RestController
@RequestMapping("/disciplines")
@CrossOrigin(origins = "http://localhost:5173")
public class DisciplineController {

    private final DisciplineService service;

    public DisciplineController(DisciplineService service) {
        this.service = service;
    }

    @GetMapping
    public List<DisciplineDTO> getAll() {
        return service.findAll().stream().map(DisciplineMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplineDTO> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(DisciplineMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DisciplineDTO> create(@RequestBody CreateDisciplineDTO dto) {
        Discipline saved = service.save(fromCreateDTO(dto));
        return ResponseEntity.ok(toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplineDTO> update(@PathVariable Long id, @RequestBody CreateDisciplineDTO dto) {
        return service.update(id, fromCreateDTO(dto))
                .map(DisciplineMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
