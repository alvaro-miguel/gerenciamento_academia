package com.example.demo.controller;

import com.example.demo.model.Plano;
import com.example.demo.service.PlanoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/planos")
public class PlanoController {
    private final PlanoService planoService;

    public PlanoController(PlanoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public Plano cadastrarPlano(@RequestBody Plano plano){
        return planoService.salvarPlano(plano);
    }

    @GetMapping
    public List<Plano> exibirPlanos(){
        return planoService.buscarPlanos();
    }

    @DeleteMapping("/{idPlano}")
    public void deletarPlano(@PathVariable Long idPlano){
        planoService.deletarPlano(idPlano);
    }

    @PutMapping("/{idPlano}")
    public void editarPlano(@PathVariable Long idPlano, @RequestBody Plano novosDados){
        planoService.editarPlano(idPlano, novosDados);
    }
}
