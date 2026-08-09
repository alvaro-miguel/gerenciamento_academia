package com.example.demo.repository;

import com.example.demo.model.DivisaoTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisaoTreinoRepository extends JpaRepository<DivisaoTreino,Long> {
}
