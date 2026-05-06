package temadogrupo.service;

import java.util.List;
import temadogrupo.model.Produto;
import temadogrupo.repository.ProdutoRepository;

/*
 * SOLID S: esta classe concentra regras de negocio de produto.
 * SOLID D: depende da interface ProdutoRepository, nao da implementacao concreta.
 */
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        // Injetando o repositorio, que pode ser o em Memoria
        // Ou pode ser outro - persistindo...
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.listar();
    }

    public void adicionarProduto(Produto produto) {
        // Estas validacaoes sao garantias para o dominio, validam obrigatoriedades,
        // formatos
        // a classe de dominio o faz tambem validacoes e la dispara excecoes
        if (produto == null) {
            return;
        }

        if (produto.getNome() == null || produto.getNome().trim().isEmpty()) {
            return;
        }

        // O produto ja existe? Evitar.... consultar o repositorio

        produtoRepository.adicionar(produto);
    }

    public void excluirProduto(int id) {
        produtoRepository.excluir(id);
    }
}
