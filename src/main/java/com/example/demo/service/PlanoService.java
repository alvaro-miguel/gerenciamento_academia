package com.example.demo.service;

import com.example.demo.model.Plano;
import com.example.demo.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoService {
    private final PlanoRepository planoRepository;

    public PlanoService(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public Plano salvar(Plano plano){

        if(plano.getIdPlano() != null && this.planoRepository.existsById(plano.getIdPlano())){
            throw new IllegalArgumentException("Plano já existe");
        }

        return planoRepository.save(plano);
    }


    public List<Plano> buscarPlanos(){
        return planoRepository.findAll();
    }
}
