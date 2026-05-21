package com.example.atividade_pontuada_v2.service;

import com.example.atividade_pontuada_v2.dto.FuncionarioDTO;
import com.example.atividade_pontuada_v2.exception.EmailDuplicadoException;
import com.example.atividade_pontuada_v2.exception.EntidadeNaoEncontradaException;
import com.example.atividade_pontuada_v2.model.FuncionarioModel;
import com.example.atividade_pontuada_v2.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDTO salvar(FuncionarioModel f) {
        if (repository.existsByEmail(f.getEmail())) {
            throw new EmailDuplicadoException("Funcionário já cadastrado.");
        }
        return new FuncionarioDTO(repository.save(f));
    }

    public List<FuncionarioDTO> listarTodos() {
        return repository.findAll().stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }

    public FuncionarioDTO buscarPorId(Long id) {
        FuncionarioModel f = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        return new FuncionarioDTO(f);
    }

    public FuncionarioDTO atualizar(Long id, FuncionarioModel dados) {
        FuncionarioModel f = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Funcionário não encontrado."));
        if (!f.getEmail().equals(dados.getEmail()) && repository.existsByEmail(dados.getEmail())) {
            throw new EmailDuplicadoException("E-mail já cadastrado.");
        }
        f.setNome(dados.getNome());
        f.setCpf(dados.getCpf());
        f.setEmail(dados.getEmail());
        f.setTelefone(dados.getTelefone());
        f.setSetor(dados.getSetor());
        f.setSalario(dados.getSalario());
        return new FuncionarioDTO(repository.save(f));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Funcionário não encontrado.");
        }
        repository.deleteById(id);
    }
}