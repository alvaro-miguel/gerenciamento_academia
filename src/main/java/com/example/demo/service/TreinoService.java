package com.example.demo.service;

import com.example.demo.model.Treino;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.TreinoRepository;

import java.util.List;

public class TreinoService {
    private final TreinoRepository treinoRepository;

    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public Treino salvarTreino(Treino treino){
        if(treinoRepository.existsById(treino.getIdTreino()) && treino.getIdTreino() != null){
            throw new IllegalArgumentException("Treino já existente");
        }
        return treinoRepository.save(treino);
    }

    public List<Treino> consultarTreinos(){
        return treinoRepository.findAll();
    }

    public void deletarTreino(Long id){
        if(!treinoRepository.existsById(id)){
            throw new IllegalArgumentException("Treino inexistente");
        }

        treinoRepository.deleteById(id);
    }
}
