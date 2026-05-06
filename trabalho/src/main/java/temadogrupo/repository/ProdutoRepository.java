package temadogrupo.repository;

import java.util.List;
import temadogrupo.model.Produto;

/*
 * SOLID I: interface pequena e especifica para operacoes de produto.
 * SOLID D: camadas superiores dependem desta abstracao.
 */

//Este é o contrato que qualquer repositorio tem que ter para poder ser trocado

public interface ProdutoRepository {

    List<Produto> listar();

    void adicionar(Produto produto);

    void excluir(int id);
}
