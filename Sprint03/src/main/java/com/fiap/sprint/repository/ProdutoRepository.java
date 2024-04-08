package com.fiap.sprint.repository;



import com.fiap.sprint.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProdutoRepository {

    private final ConcurrentHashMap<Long, Produto> produtos = new ConcurrentHashMap<>();

    private  final AtomicLong idGenerator = new AtomicLong(0);

    public List<Produto> findAll() {
        return new ArrayList<>(produtos.values());
    }

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(idGenerator.incrementAndGet());
        }
        produtos.put(produto.getId(),produto);
        return produto;
    }

    public Optional<Produto> findById(Long id) {
        return Optional.ofNullable(produtos.get(id));
    }

    public void deleteById(Long id) {
        produtos.remove(id);
    }
}
