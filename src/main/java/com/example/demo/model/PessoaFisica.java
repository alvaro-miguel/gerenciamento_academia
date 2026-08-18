package com.example.demo.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name =  "pessoa_fisica")
@Inheritance(strategy = InheritanceType.JOINED)

public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Column(nullable = true)
    private String numeroCelular;

    public PessoaFisica(){
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getNumeroCelular() { return numeroCelular;}

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNumeroCelular(String numeroCelular) { this.numeroCelular = numeroCelular; }
}
