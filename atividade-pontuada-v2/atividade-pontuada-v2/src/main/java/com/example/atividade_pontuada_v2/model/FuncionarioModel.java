package com.example.atividade_pontuada_v2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class FuncionarioModel {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank(message = "O nome é obrigatório.")
        private String nome;

        @NotBlank(message = "O CPF é obrigatório.")
        private String cpf;

        @NotBlank(message = "O e-mail é obrigatório.")
        @Column(unique = true)
        private String email;

        @NotBlank(message = "O telefone é obrigatório.")
        private String telefone;

        @NotBlank(message = "O setor é obrigatório.")
        private String setor;

        @NotNull(message = "O salário é obrigatório.")
        private double salario;

    public FuncionarioModel() {
    }

    public FuncionarioModel(Long id, String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O nome é obrigatório.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CPF é obrigatório.") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O CPF é obrigatório.") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O e-mail é obrigatório.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone é obrigatório.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatório.") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "O setor é obrigatório.") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "O setor é obrigatório.") String setor) {
        this.setor = setor;
    }

    @NotNull(message = "O salário é obrigatório.")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O salário é obrigatório.") double salario) {
        this.salario = salario;
    }
}

