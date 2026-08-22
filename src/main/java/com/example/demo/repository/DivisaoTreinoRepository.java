package com.example.demo.repository;

import com.example.demo.model.DivisaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DivisaoTreinoRepository extends JpaRepository<DivisaoTreino,Long> {
    List<DivisaoTreino> findByTreinoIdTreino(Long idTreino);
}
