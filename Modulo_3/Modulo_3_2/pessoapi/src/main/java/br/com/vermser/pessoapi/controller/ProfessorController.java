package br.com.vermser.pessoapi.controller;

import br.com.vermser.pessoapi.entity.ProfessorEntity;
import br.com.vermser.pessoapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> getAll(){
        return ResponseEntity.ok(professorRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> create(@RequestBody ProfessorEntity professorEntity){
        return ResponseEntity.ok(professorRepository.save(professorEntity));
    }

}
