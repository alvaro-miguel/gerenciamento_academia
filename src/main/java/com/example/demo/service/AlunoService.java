package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvarAluno(Aluno aluno){
        if(aluno.getIdPessoa() != null && this.alunoRepository.existsById(aluno.getIdPessoa())){
            throw new IllegalArgumentException("Aluno já cadastrado");
        }

        return alunoRepository.save(aluno);
    }

    public List<Aluno> retornarAlunos(){
        return alunoRepository.findAll();
    }


    public void deletarAluno(Long id){
        if(!this.alunoRepository.existsById(id)){
            throw new IllegalArgumentException("Aluno inexistente");
        }

        alunoRepository.deleteById(id);
    }

    public void suspenderMatricula(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()
                -> new IllegalArgumentException("Aluno inexistente"));
        aluno.setStatusMatricula(false);
        alunoRepository.save(aluno);
    }


    public void ativarMatricula(Long id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()
        -> new IllegalArgumentException("Aluno inexistente"));
        aluno.setStatusMatricula(true);
        alunoRepository.save(aluno);
    }


}
