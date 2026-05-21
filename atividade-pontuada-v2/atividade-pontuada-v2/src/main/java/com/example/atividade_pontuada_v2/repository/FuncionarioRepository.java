package com.example.atividade_pontuada_v2.repository;

import com.example.atividade_pontuada_v2.model.FuncionarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
    boolean existsByEmail(String email);
}