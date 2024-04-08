package com.fiap.sprint.repository;

import com.fiap.sprint.model.Fornecedor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FornecedorRepository {
    private final ConcurrentHashMap<Long, Fornecedor> fornecedores = new ConcurrentHashMap<>();

    private  final AtomicLong idGenerator = new AtomicLong(0);

    public List<Fornecedor> findAll() {
        return new ArrayList<>(fornecedores.values());
    }

    public Fornecedor save(Fornecedor fornecedor) {
        if (fornecedor.getId() == null) {
            fornecedor.setId(idGenerator.incrementAndGet());
        }
        fornecedores.put(fornecedor.getId(),fornecedor);
        return fornecedor;
    }

    public Optional<Fornecedor> findById(Long id) {
        return Optional.ofNullable(fornecedores.get(id));
    }

    public void deleteById(Long id) {
        fornecedores.remove(id);
    }
}
