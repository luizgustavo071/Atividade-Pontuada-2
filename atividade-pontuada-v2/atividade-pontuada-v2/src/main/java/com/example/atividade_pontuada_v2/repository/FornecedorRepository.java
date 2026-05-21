package com.example.atividade_pontuada_v2.repository;

import com.example.atividade_pontuada_v2.model.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
    boolean existsByEmail(String email);
}