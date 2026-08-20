package com.example.demo.controller;

import com.example.demo.model.Treino;
import com.example.demo.service.TreinoService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {
    private final TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping
    public Treino salvarTreino(@RequestBody Treino treino){
        return treinoService.salvarTreino(treino);
    }

    @GetMapping
    public List<Treino> exibirTreinos(){
        return treinoService.consultarTreinos();
    }

    @DeleteMapping("/{id}")
    public void deletarTreino(@PathVariable Long id){
        treinoService.deletarTreino(id);
    }

    @PostMapping("/montar_treino/{idAluno}/{idProfessor}")
    public void criarTreino(@RequestBody Treino treino, @PathVariable Long idAluno, @PathVariable Long idProfessor){
        treinoService.montarTreino(treino, idAluno, idProfessor);
    }

    @PatchMapping("/{idTreino}/renovar")
    public void renovarVencimento(@PathVariable Long idTreino, @RequestBody LocalDate novaData){
        treinoService.renovarVencimento(idTreino, novaData);
    }


}
