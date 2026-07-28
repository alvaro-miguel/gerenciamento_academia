package com.example.demo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "divisao_treino")
public class DivisaoTreino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDivisao;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String grupoAlvo;

    @ManyToOne
    @JoinColumn(name = "treino_id")
    private Treino treino;

    public DivisaoTreino(){
    }

    public Long getIdDivisao() {
        return idDivisao;
    }

    public String getNome() {
        return nome;
    }

    public String getGrupoAlvo() {
        return grupoAlvo;
    }

    public Treino getTreino() {
        return treino;
    }

    public void setIdDivisao(Long idDivisao) {
        this.idDivisao = idDivisao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setGrupoAlvo(String grupoAlvo) {
        this.grupoAlvo = grupoAlvo;
    }

    public void setTreino(Treino treino) {
        this.treino = treino;
    }
}
