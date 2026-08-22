package com.example.demo.controller;

import com.example.demo.model.Exercicio;
import com.example.demo.service.ExercicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {
    private final ExercicioService exercicioService;

    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @PostMapping
    public Exercicio salvarExercicio(@RequestBody Exercicio exercicio){
        return exercicioService.salvarExercicio(exercicio);
    }

    @GetMapping
    public List<Exercicio> listarExercicios(){
        return exercicioService.retornarExercicios();
    }

    @DeleteMapping("/{idExercicio}")
    public void deletarExercicio(@PathVariable Long idExercicio){
        exercicioService.deletarExercicio(idExercicio);
    }

    @PutMapping("/{idExercicio}")
    public void atualizarExercicio(@PathVariable Long idExercicio, @RequestBody Exercicio exercicio){
        exercicioService.atualizarExercicio(idExercicio, exercicio);
    }
}
