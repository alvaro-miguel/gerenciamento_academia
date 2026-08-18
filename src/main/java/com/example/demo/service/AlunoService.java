package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.model.Plano;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        planoRepository = null;
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


    public void mudarPlano(Long idAluno, Long idPlano){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(()
                -> new IllegalArgumentException("Aluno inexistente"));

        Plano plano = planoRepository.findById(idPlano).orElseThrow(()
                -> new IllegalArgumentException("Plano inexistente"));

        aluno.setPlano(plano);
        alunoRepository.save(aluno);
    }


    public void atualizarCadastro(Long idAluno, Aluno dadosNovos){
        Aluno alunoExistente = alunoRepository.findById(idAluno).orElseThrow(()
        -> new IllegalArgumentException("Aluno inexistente"));

        alunoExistente.setNome(dadosNovos.getNome());
        alunoExistente.setDataNascimento(dadosNovos.getDataNascimento());
        alunoExistente.setNumeroCelular(dadosNovos.getNumeroCelular());

        alunoRepository.save(alunoExistente);
    }


}
