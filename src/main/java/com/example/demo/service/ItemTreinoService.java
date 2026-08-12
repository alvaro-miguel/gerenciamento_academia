package com.example.demo.service;

import com.example.demo.model.ItemTreino;
import com.example.demo.repository.ItemTreinoRepository;

import java.util.List;

public class ItemTreinoService {
    private final ItemTreinoRepository itemTreinoRepository;

    public ItemTreinoService(ItemTreinoRepository itemTreinoRepository) {
        this.itemTreinoRepository = itemTreinoRepository;
    }

    public ItemTreino salvarItemTreino(ItemTreino itemTreino){
        if(itemTreinoRepository.existsById(itemTreino.getIdItemTreino()) && itemTreino.getIdItemTreino() != null){
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
}
