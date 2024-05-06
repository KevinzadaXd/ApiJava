package com.teste.teste1.repository;
import org.springframework.stereotype.Repository;
import com.teste.teste1.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
    public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

    } 