package br.com.gerenciamento.repository;

import br.com.gerenciamento.model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {
    private final List <Produto> produtos = new ArrayList<>();

    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    public List <Produto> listarTodos(){
        return List.copyOf(produtos);//retorna copia para proteger lista
    }

    public Optional<Produto> buscarPorId(int id){
        return produtos.stream()
                .filter(p->p.id()==id)
                .findFirst();
    }
    public void deletar (int id){
        produtos.removeIf(p -> p.id()==id);
    }
}
