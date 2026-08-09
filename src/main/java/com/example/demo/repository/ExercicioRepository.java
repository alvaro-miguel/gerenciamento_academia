package com.example.demo.repository;

import com.example.demo.model.Exercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository  extends JpaRepository<Exercicio, Long> {
}
