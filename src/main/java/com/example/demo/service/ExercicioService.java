package com.example.demo.service;

import com.example.demo.model.Exercicio;
import com.example.demo.repository.ExercicioRepository;

import java.util.List;

public class ExercicioService {

    private final ExercicioRepository exercicioRepository;

    public ExercicioService(ExercicioRepository exercicioRepository) {
        this.exercicioRepository = exercicioRepository;
    }

    public Exercicio salvarExercicio(Exercicio exercicio){
        if(exercicioRepository.existsById(exercicio.getIdExercicio()) && exercicio.getIdExercicio() != null){
            throw  new IllegalArgumentException("Exercicio já cadastrado");
        }

        return this.exercicioRepository.save(exercicio);
    }


    public List<Exercicio> retornarExercicios(){
        return exercicioRepository.findAll();
    }


    public void deletarExercico(Long id){
        if(!this.exercicioRepository.existsById(id)){
            throw new IllegalArgumentException("Exercicio inexistente");
        }

        this.exercicioRepository.deleteById(id);
    }
}
