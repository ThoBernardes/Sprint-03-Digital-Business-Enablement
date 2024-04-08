package com.fiap.sprint.service;


import com.fiap.sprint.model.Produto;
import com.fiap.sprint.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository ProdutoRepository;

    public List<Produto> findAll() {
        return ProdutoRepository.findAll();
    }

    public Produto save(Produto fornecedor) {
        return ProdutoRepository.save(fornecedor);
    }

    public Optional<Produto> findById(Long id) {
        return ProdutoRepository.findById(id);
    }

    public void deleteById(Long id) {
        ProdutoRepository.deleteById(id);
    }
}
