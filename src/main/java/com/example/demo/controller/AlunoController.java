package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.model.Plano;
import com.example.demo.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno salvarAluno(@RequestBody Aluno aluno){
        return alunoService.salvarAluno(aluno);
    }

    @GetMapping
    public List<Aluno> exibirAlunos(){
        return alunoService.retornarAlunos();
    }

    @DeleteMapping("/{idAluno}")
    public void deletarAluno(@PathVariable Long idAluno){
        alunoService.deletarAluno(idAluno);
    }

    @PatchMapping("/{idAluno}/mudar-plano/{idPlano}")
    public void alterarPlano(@PathVariable Long idAluno, @PathVariable   Long idPlano){
        alunoService.mudarPlano(idAluno, idPlano);
    }

    @PatchMapping("/{idAluno}/suspender")
    public void suspenderMatricula(@PathVariable Long idAluno){
        alunoService.suspenderMatricula(idAluno);
    }

    @PatchMapping("/{idAluno}/ativar")
    public void ativarMatricula(@PathVariable Long idAluno){
        alunoService.ativarMatricula(idAluno);
    }

    @PatchMapping("/{idAluno}")
    public void atualizarAluno(@PathVariable Long idAluno, @RequestBody Aluno novosDados){
        alunoService.atualizarCadastro(idAluno, novosDados);
    }
}
