package com.example.atividade_pontuada_v2.dto;

import com.example.atividade_pontuada_v2.model.ClienteModel;

public class ClienteDTO {
    private String nome;
    private String dataNascimento;
    private String email;

    public ClienteDTO() {}

    public ClienteDTO(ClienteModel c) {
        this.nome = c.getNome();
        this.dataNascimento = c.getDataNascimento();
        this.email = c.getEmail();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(String dataNascimento) { this.dataNascimento = dataNascimento; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
