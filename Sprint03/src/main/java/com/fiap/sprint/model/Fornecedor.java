package com.fiap.sprint.model;

public class Fornecedor {
    private Long id;
    private String nome;
    private String enderecoURL;
    private String contato;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnderecoURL() {
        return enderecoURL;
    }

    public void setEnderecoURL(String enderecoURL) {
        this.enderecoURL = enderecoURL;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }
}
