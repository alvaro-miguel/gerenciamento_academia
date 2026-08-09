package com.example.demo.repository;

import com.example.demo.model.ItemTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTreinoRepository extends JpaRepository<ItemTreino, Long> {
}
