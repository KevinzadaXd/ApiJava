package com.teste.teste1.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.teste.teste1.model.Produto;
import com.teste.teste1.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoControler {
    @Autowired
    private ProdutoService produtoservice;
    @GetMapping
    public List<Produto> obterTodos(){
        return produtoservice.obterTodos();
    }
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoservice.adicionar(produto); 

    }
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id){
        return produtoservice.obterPorId(id);
    }
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id){
        produtoservice.deletar(id);
         return "Produto com id : " + id + " foi deletado com sucesso";
    }
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id){
            return produtoservice.atualizar(id, produto);
    }
}
