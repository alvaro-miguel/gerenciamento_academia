package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.model.Professor;
import com.example.demo.model.Treino;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final TreinoRepository treinoRepository;

    public ProfessorService(ProfessorRepository professorRepository, TreinoRepository treinoRepository) {
        this.professorRepository = professorRepository;
        this.treinoRepository = treinoRepository;
    }


    public Professor salvarProfessor(Professor professor){

        if(professor.getIdPessoa() != null && professorRepository.existsById(professor.getIdPessoa())){
            throw new IllegalArgumentException("Professor já cadastrado");
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


    public List<Aluno> exibirAlunos(Long idProfessor){
        List<Treino> listaCompleta = treinoRepository.findByProfessorIdPessoa(idProfessor);

        Set<Aluno> alunosUnicos = new HashSet<>();

        for(Treino treino : listaCompleta){
            alunosUnicos.add(treino.getAluno());
        }

        return new ArrayList<>(alunosUnicos);
    }


    public void editarProfessor(Long idProfessor, Professor NovosDados){
        Professor professorExistente =professorRepository.findById(idProfessor).orElseThrow(()
        ->  new IllegalArgumentException("Professor inexistente"));

        professorExistente.setNome(NovosDados.getNome());
        professorExistente.setNumeroCelular(NovosDados.getNumeroCelular());
        professorExistente.setDataNascimento(NovosDados.getDataNascimento());

        professorRepository.save(professorExistente);
    }
}
