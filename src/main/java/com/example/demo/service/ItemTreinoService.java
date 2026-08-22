package com.example.demo.service;

import com.example.demo.model.ItemTreino;
import com.example.demo.repository.ItemTreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTreinoService {
    private final ItemTreinoRepository itemTreinoRepository;

    public ItemTreinoService(ItemTreinoRepository itemTreinoRepository) {
        this.itemTreinoRepository = itemTreinoRepository;
    }

    public ItemTreino salvarItemTreino(ItemTreino itemTreino){
        if(itemTreino.getIdItemTreino() != null && itemTreinoRepository.existsById(itemTreino.getIdItemTreino())){
            throw new IllegalArgumentException("ItemTreino já existe");
        }
        return itemTreinoRepository.save(itemTreino);
    }

    public List<ItemTreino> listarItemTreino(){
        return itemTreinoRepository.findAll();
    }

    public void deletarItemTreino(Long id){
        if(!itemTreinoRepository.existsById(id)){
            throw new IllegalArgumentException("ItemTreino inexistente");
        }

        itemTreinoRepository.deleteById(id);
    }

    public void atualizarCarga(Long idItem, ItemTreino novosDados){
        ItemTreino itemExistente = itemTreinoRepository.findById(idItem).orElseThrow(() ->
                new IllegalArgumentException("Item de treino inexistente"));

        itemExistente.setCarga(novosDados.getCarga());
        itemTreinoRepository.save(itemExistente);
    }

    public void atualizarReps(Long idItem, ItemTreino novosDados){
        ItemTreino itemExistente = itemTreinoRepository.findById(idItem).orElseThrow(() ->
                new IllegalArgumentException("Item de treino inexistente"));

        itemExistente.setReps(novosDados.getReps());
        itemTreinoRepository.save(itemExistente);
    }
}
