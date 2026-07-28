package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "aluno")

public class Aluno extends PessoaFisica{
    @Column(nullable = false)
    private Boolean statusMatricula;

    @Column(nullable = false)
    private LocalDate vencimentoMatricula;

    @ManyToOne
    @JoinColumn(name="plano_id")
    private Plano plano;

    public Aluno(){
    }

    public Boolean getStatusMatricula() {
        return statusMatricula;
    }

    public LocalDate getVencimentoMatricula() {
        return vencimentoMatricula;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setStatusMatricula(Boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public void setVencimentoMatricula(LocalDate vencimentoMatricula) {
        this.vencimentoMatricula = vencimentoMatricula;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
