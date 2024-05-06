package com.teste.teste1.services;

import com.teste.teste1.model.Produto;
import com.teste.teste1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterPorId(Integer id) {
        return produtoRepository.findById(id);
    }

    public Produto adicionar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Integer id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizar(Integer id, Produto produto) {
        Produto existingProduto = produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto not found with id: " + id));
        existingProduto.setNome(produto.getNome());
        existingProduto.setObservacao(produto.getObservacao());
        existingProduto.setValor(produto.getValor());
        return produtoRepository.save(existingProduto);
    }
}