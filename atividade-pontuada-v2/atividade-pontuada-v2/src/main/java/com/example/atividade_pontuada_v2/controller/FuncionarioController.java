package com.example.atividade_pontuada_v2.controller;

import com.example.atividade_pontuada_v2.dto.FuncionarioDTO;
import com.example.atividade_pontuada_v2.model.FuncionarioModel;
import com.example.atividade_pontuada_v2.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@Valid @RequestBody FuncionarioModel funcionario) {
        service.salvar(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado com sucesso."));
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @Valid @RequestBody FuncionarioModel funcionario) {
        service.atualizar(id, funcionario);
        return ResponseEntity.ok(Map.of("mensagem", "Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Excluído com sucesso."));
    }
}