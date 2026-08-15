package com.example.demo.controller;

import com.example.demo.model.Treino;
import com.example.demo.service.TreinoService;
import org.springframework.web.bind.annotation.*;

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


}
