package com.example.atividade_pontuada_v2.service;

import com.example.atividade_pontuada_v2.dto.FornecedorDTO;
import com.example.atividade_pontuada_v2.exception.EmailDuplicadoException;
import com.example.atividade_pontuada_v2.exception.EntidadeNaoEncontradaException;
import com.example.atividade_pontuada_v2.model.FornecedorModel;
import com.example.atividade_pontuada_v2.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    public FornecedorDTO salvar(FornecedorModel f) {
        if (repository.existsByEmail(f.getEmail())) {
            throw new EmailDuplicadoException("Fornecedor já cadastrado.");
        }
        return new FornecedorDTO(repository.save(f));
    }

    public List<FornecedorDTO> listarTodos() {
        return repository.findAll().stream().map(FornecedorDTO::new).collect(Collectors.toList());
    }

    public FornecedorDTO buscarPorId(Long id) {
        FornecedorModel f = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado."));
        return new FornecedorDTO(f);
    }

    public FornecedorDTO atualizar(Long id, FornecedorModel dados) {
        FornecedorModel f = repository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado."));
        if (!f.getEmail().equals(dados.getEmail()) && repository.existsByEmail(dados.getEmail())) {
            throw new EmailDuplicadoException("E-mail já cadastrado.");
        }
        f.setNome(dados.getNome());
        f.setCnpj(dados.getCnpj());
        f.setEmail(dados.getEmail());
        f.setTelefone(dados.getTelefone());
        return new FornecedorDTO(repository.save(f));
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Fornecedor não encontrado.");
        }
        repository.deleteById(id);
    }
}
