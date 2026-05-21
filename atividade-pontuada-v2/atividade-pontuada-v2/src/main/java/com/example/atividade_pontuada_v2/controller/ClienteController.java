package com.example.atividade_pontuada_v2.controller;

import com.example.atividade_pontuada_v2.dto.ClienteDTO;
import com.example.atividade_pontuada_v2.model.ClienteModel;
import com.example.atividade_pontuada_v2.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    /*Salvando
    * */
    @PostMapping
    public ResponseEntity<Map<String, String>> criar(@Valid @RequestBody ClienteModel cliente) {
        service.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensagem", "Cadastrado com sucesso."));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> atualizar(@PathVariable Long id, @Valid @RequestBody ClienteModel cliente) {
        service.atualizar(id, cliente);
        return ResponseEntity.ok(Map.of("mensagem", "Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok(Map.of("mensagem", "Excluído com sucesso."));
    }
}