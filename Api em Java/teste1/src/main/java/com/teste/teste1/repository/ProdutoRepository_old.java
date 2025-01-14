package com.teste.teste1.repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import com.teste.teste1.model.Produto;
import com.teste.teste1.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository_old {

    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId= 0;
     
    public List<Produto> obterTodos(){
            return produtos;
    }

    /**
     * @return
     */
    public Optional<Produto> obterPorId(Integer id){      
        return produtos.stream()
        .filter(produto -> produto.getId() == id)
        .findFirst();
    }


        public Produto adicionar(Produto produto){
            ultimoId++;
            produto.setId(ultimoId);
            produtos.add(produto);
            return produto;
        }

        public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);

        }

        public Produto atualizar(Produto produto){
              
           Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

           if(produtoEncontrado.isEmpty()){
            throw new ResourceNotFoundException ("Produto não pode ser atualizado");
           }
           deletar(produto.getId());

           produtos.add(produto);

           return produto;



        }

}
