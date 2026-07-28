package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "professor")

public class Professor extends PessoaFisica{
    @Column (unique = true, nullable = false)
    private String cref;

    public Professor(){
    }

    public String getCref() {
        return cref;
    }

    public void setCref(String cref) {
        this.cref = cref;
    }
}
