package com.example.atividade_pontuada_v2.service;

import com.example.atividade_pontuada_v2.dto.ClienteDTO;
import com.example.atividade_pontuada_v2.exception.EmailDuplicadoException;
import com.example.atividade_pontuada_v2.exception.EntidadeNaoEncontradaException;
import com.example.atividade_pontuada_v2.model.ClienteModel;
import com.example.atividade_pontuada_v2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteDTO salvar(ClienteModel c) {
        if (repository.existsByEmail(c.getEmail())) {
            throw new EmailDuplicadoException("Cliente já cadastrado.");
        }
        return new ClienteDTO(repository.save(c));
    }

    public List<ClienteDTO> listarTodos() {
        return repository.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

    public ClienteDTO buscarPorId(Long id) {
        ClienteModel c = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado."));
        return new ClienteDTO(c);
    }

    public ClienteDTO atualizar(Long id, ClienteModel dados) {
        ClienteModel c = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Cliente não encontrado."));
        if (!c.getEmail().equals(dados.getEmail()) && repository.existsByEmail(dados.getEmail())) {
            throw new EmailDuplicadoException("E-mail já cadastrado.");
        }
        c.setNome(dados.getNome());
        c.setCpf(dados.getCpf());
        c.setDataNascimento(dados.getDataNascimento());
        c.setEmail(dados.getEmail());
        c.setSenha(dados.getSenha());
        return new ClienteDTO(repository.save(c));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Cliente não encontrado.");
        }
        repository.deleteById(id);
    }
}