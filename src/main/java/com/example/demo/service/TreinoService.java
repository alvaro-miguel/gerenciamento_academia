package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TreinoService {
    private final TreinoRepository treinoRepository;
    private final AlunoRepository alunoRepository;
    private final ProfessorRepository professorRepository;
    private final DivisaoTreinoRepository divisaoTreinoRepository;
    private final ItemTreinoRepository itemTreinoRepository;

    public TreinoService(TreinoRepository treinoRepository, AlunoRepository alunoRepository, ProfessorRepository professorRepository, DivisaoTreinoRepository divisaoTreinoRepository, ItemTreinoRepository itemTreinoRepository) {
        this.treinoRepository = treinoRepository;
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.divisaoTreinoRepository = divisaoTreinoRepository;
        this.itemTreinoRepository = itemTreinoRepository;
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

    public void duplicarTreino(Long idTreinoOrigem){
        Treino treinoExistente = treinoRepository.findById(idTreinoOrigem).orElseThrow(()
        -> new IllegalArgumentException("Treino inexistente"));

        Treino novoTreino = new Treino();

        novoTreino.setDataFim(treinoExistente.getDataFim());
        novoTreino.setProfessor(treinoExistente.getProfessor());
        novoTreino.setDataInicio(treinoExistente.getDataInicio());
        novoTreino.setAluno(treinoExistente.getAluno());
        novoTreino.setNomeTreino(treinoExistente.getNomeTreino() + " - cópia");

        novoTreino = treinoRepository.save(novoTreino);

        List<DivisaoTreino> divisoesAntigas = divisaoTreinoRepository.findByTreinoIdTreino(idTreinoOrigem);

        for(DivisaoTreino divisaoAntiga : divisoesAntigas){
            DivisaoTreino novaDivisao = new DivisaoTreino();
            novaDivisao.setNome(divisaoAntiga.getNome());
            novaDivisao.setGrupoAlvo(divisaoAntiga.getGrupoAlvo());
            novaDivisao.setTreino(novoTreino);

            novaDivisao = divisaoTreinoRepository.save(novaDivisao);

            List<ItemTreino> itensAntigos = itemTreinoRepository.findByDivisaoTreinoIdDivisao(divisaoAntiga.getIdDivisao());

            for(ItemTreino itemAntigo : itensAntigos){
                ItemTreino novoItem = new ItemTreino();

                novoItem.setCarga(itemAntigo.getCarga());
                novoItem.setReps(itemAntigo.getReps());
                novoItem.setSeries(itemAntigo.getSeries());
                novoItem.setExercicio(itemAntigo.getExercicio());
                novoItem.setDivisaoTreino(novaDivisao);

                itemTreinoRepository.save(novoItem);
            }
        }
    }
}
