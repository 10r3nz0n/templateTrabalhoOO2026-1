package temadogrupo.repository;

import java.util.ArrayList;
import java.util.List;
import temadogrupo.model.Produto;

/*
* SOLID S: esta classe estende a ideia de repositorio pra disco, nativo OO
* SOLID O: eh uma outra persistencia para injecao
* SOLID L: esta classe pode substituir ProdutoRepository, sendo injetada no servico
*/

public class ProdutoRepositoryPersistenciaOONativo implements ProdutoRepository {

    private List<Produto> produtos;

    public ProdutoRepositoryPersistenciaOONativo() {
        this.produtos = new ArrayList<Produto>();
    }

    @Override
    public void adicionar(Produto produto) {
        // TODO

    }

    @Override
    public void excluir(int id) {
        // TODO

    }

    @Override
    public List<Produto> listar() {
        // TODO
        return null;
    }

    // resolver aqui como o novo repositorio trabalha e injetar ele no servico,
    // no lugar da injecao do repositorio em memoria

}
