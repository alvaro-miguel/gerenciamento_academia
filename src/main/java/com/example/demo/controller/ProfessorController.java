package com.example.demo.controller;

import com.example.demo.model.Professor;
import com.example.demo.service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    public Professor salvarProfessor(@RequestBody Professor professor){
        return professorService.salvarProfessor(professor);
    }

    @GetMapping
    public List<Professor> exibirProfessors(){
        return professorService.consultarProfessores();
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        professorService.deletarProfessor(id);
    }
}
