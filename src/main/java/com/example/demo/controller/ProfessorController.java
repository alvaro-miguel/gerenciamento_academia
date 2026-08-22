package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;
import com.example.demo.model.Treino;
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
    public List<Professor> exibirProfessores(){
        return professorService.consultarProfessores();
    }

    @DeleteMapping("/{idProfessor}")
    public void deletarProfessor(@PathVariable Long idProfessor){
        professorService.deletarProfessor(idProfessor);
    }

    @GetMapping("/{idProfessor/alunos")
    public List<Aluno> consultarTreinos(@PathVariable Long idProfessor){
        return professorService.exibirAlunos(idProfessor);
    }

    @PutMapping("/{idProfessor}")
    public void editarProfessor(@PathVariable Long idProfessor, @RequestBody Professor novosDados){
        professorService.editarProfessor(idProfessor, novosDados);
    }
}
