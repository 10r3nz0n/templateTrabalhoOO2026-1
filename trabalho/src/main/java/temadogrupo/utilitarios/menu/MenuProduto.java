package temadogrupo.utilitarios.menu;

import java.util.ArrayList;

public class MenuProduto {

    private MenuProduto() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Listar produtos");
        opcoes.add("Cadastrar produto");
        opcoes.add("Excluir produto");
        opcoes.add("Voltar");

        Menu menu = new Menu("CRUD Produto", opcoes);
        return menu.exibir();
    }
}
