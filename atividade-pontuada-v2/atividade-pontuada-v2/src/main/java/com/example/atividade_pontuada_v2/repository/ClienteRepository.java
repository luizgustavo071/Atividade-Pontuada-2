package com.example.atividade_pontuada_v2.repository;

import com.example.atividade_pontuada_v2.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    boolean existsByEmail(String email);
}
