package com.example.atividade_pontuada_v2.dto;

import com.example.atividade_pontuada_v2.model.FuncionarioModel;

public class FuncionarioDTO {
    private String nome;
    private String email;
    private String telefone;
    private String setor;
    private double salario;


    public FuncionarioDTO(FuncionarioModel funcionario) {
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
        this.telefone = funcionario.getTelefone();
        this.setor = funcionario.getSetor();
        this.salario = funcionario.getSalario();
    }


    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getSetor() { return setor; }
    public double getSalario() { return salario; }


    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setSetor(String setor) { this.setor = setor; }
    public void setSalario(double salario) { this.salario = salario; }
}