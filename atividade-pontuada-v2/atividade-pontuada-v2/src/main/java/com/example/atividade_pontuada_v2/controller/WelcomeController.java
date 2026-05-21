package com.example.atividade_pontuada_v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public Map<String, String> boasVindas() {
        return Map.of("mensagem", "Bem-vindo à API REST de Gestão!");
    }
}