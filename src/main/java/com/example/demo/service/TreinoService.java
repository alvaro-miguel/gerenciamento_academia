package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;
import com.example.demo.model.Treino;
import com.example.demo.repository.AlunoRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TreinoService {
    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;

    public TreinoService(TreinoRepository treinoRepository, AlunoRepository alunoRepository, ProfessorRepository professorRepository) {
        this.treinoRepository = treinoRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
    }

    public Treino salvarTreino(Treino treino){
        if(treino.getIdTreino() != null && treinoRepository.existsById(treino.getIdTreino())){
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

    public void montarTreino(Treino treino, Long idAluno, Long idProfessor){
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(()
                -> new IllegalArgumentException("Aluno inexistente"));

        Professor professor = professorRepository.findById(idProfessor).orElseThrow(()
        -> new IllegalArgumentException("Professor inexistente"));

        treino.setAluno(aluno);
        treino.setProfessor(professor);
        treinoRepository.save(treino);
    }

    public void renovarVencimento(Long idTreino, LocalDate novaDataFim){
        Treino treino = treinoRepository.findById(idTreino).orElseThrow(()
                -> new IllegalArgumentException("Treino inexistente"));

        treino.setDataFim(novaDataFim);
        treinoRepository.save(treino);
    }
}
