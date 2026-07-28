package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "plano")

public class Plano {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlano;

    @Column(unique = true, nullable = false)
    private String nomePlano;

    @Column(nullable = false)
    private Double valorMensalidade;

    @Column(nullable = false)
    private Integer diasPermitidos;

    public Plano(){
    }

    public Long getIdPlano() {
        return idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public Double getValorMensalidade() {
        return valorMensalidade;
    }

    public Integer getDiasPermitidos() {
        return diasPermitidos;
    }

    public void setIdPlano(Long idPlano) {
        this.idPlano = idPlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public void setValorMensalidade(Double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }

    public void setDiasPermitidos(Integer diasPermitidos) {
        this.diasPermitidos = diasPermitidos;
    }
}
