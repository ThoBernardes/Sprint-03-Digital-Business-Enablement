package com.fiap.sprint.service;

import com.fiap.sprint.model.Fornecedor;
import com.fiap.sprint.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> findAll() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor save(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public Optional<Fornecedor> findById(Long id) {
        return fornecedorRepository.findById(id);
    }

    public void deleteById(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
