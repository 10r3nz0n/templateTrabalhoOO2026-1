package temadogrupo.repository;

import java.util.ArrayList;
import java.util.List;
import temadogrupo.model.Produto;
import temadogrupo.utilitarios.Video;

/*
 * SOLID S: esta classe cuida apenas da persistencia em memoria.
 * SOLID O: outra persistencia pode surgir sem alterar ProdutoService.
 * SOLID L: esta classe pode substituir ProdutoRepository, sendo injetada
 */

public class ProdutoRepositoryMemoria implements ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepositoryMemoria() {
        this.produtos = new ArrayList<Produto>();
    }

    @Override
    public List<Produto> listar() {
        return new ArrayList<Produto>(produtos);
    }

    @Override
    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public void excluir(int id) {
        /*
         * for (int indice = 0; indice < produtos.size(); indice++) {
         * Produto produtoAtual = produtos.get(indice);
         * 
         * if (produtoAtual.getId() == id) {
         * produtos.remove(indice);
         * return;
         * }
         * }
         */

        // ou For each
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return;
            }
        }
    }
}
