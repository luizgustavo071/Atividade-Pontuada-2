package com.example.atividade_pontuada_v2.dto;

import com.example.atividade_pontuada_v2.model.FornecedorModel;

public class FornecedorDTO {
    private String nome;
    private String email;
    private String telefone;

    public FornecedorDTO() {}

    public FornecedorDTO(FornecedorModel f) {
        this.nome = f.getNome();
        this.email = f.getEmail();
        this.telefone = f.getTelefone();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}