package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "exercicio")
public class Exercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idExercicio;

    @Column(unique = true, nullable = false)
    private String nomeExercicio;

    @Column(nullable = false)
    private String grupoMuscular;

    public Exercicio(){
    }

    public Long getIdExercicio() {
        return idExercicio;
    }

    public String getNomeExercicio() {
        return nomeExercicio;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setIdExercicio(Long idExercicio) {
        this.idExercicio = idExercicio;
    }

    public void setNomeExercicio(String nomeExercicio) {
        this.nomeExercicio = nomeExercicio;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }
}
