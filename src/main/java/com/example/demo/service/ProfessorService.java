package com.example.demo.service;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public Professor salvarProfessor(Professor professor){

        if(professor.getIdPessoa() != null && professorRepository.existsById(professor.getIdPessoa())){
            throw new IllegalArgumentException("Proefssor já cadastrado");
        }
        return professorRepository.save(professor);
    }


    public List<Professor> consultarProfessores(){
        return professorRepository.findAll();
    }


    public void deletarProfessor(Long id){
        if(!professorRepository.existsById(id)){
            throw new IllegalArgumentException("Professor inexistente");
        }

        professorRepository.deleteById(id);
    }
}
