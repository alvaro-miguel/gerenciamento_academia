package com.example.demo.controller;

import com.example.demo.model.ItemTreino;
import com.example.demo.service.ItemTreinoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens_treino")
public class ItemTreinoController {
    private final ItemTreinoService itemTreinoService;

    public ItemTreinoController(ItemTreinoService itemTreinoService) {
        this.itemTreinoService = itemTreinoService;
    }

    @PostMapping    
    public ItemTreino salvarItemTreino(@RequestBody ItemTreino itemTreino){
        return itemTreinoService.salvarItemTreino(itemTreino);
    }

    @GetMapping
    public List<ItemTreino> listarItens(){
        return itemTreinoService.listarItemTreino();
    }

    @DeleteMapping("/{idItem}/deletar")
    public void deletarItemTreino(@PathVariable Long idItem){
        itemTreinoService.deletarItemTreino(idItem);
    }

    @PatchMapping("/{idItem}/carga")
    public void atulizarCarga(@PathVariable Long idItem, @RequestBody ItemTreino itemTreino){
        itemTreinoService.atualizarCarga(idItem, itemTreino);
    }

    @PatchMapping("/{idItem}/reps")
    public void atulizarReps(@PathVariable Long idItem, @RequestBody ItemTreino itemTreino){
        itemTreinoService.atualizarReps(idItem, itemTreino);
    }
}
