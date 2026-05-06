package temadogrupo.utilitarios.menu;

import java.util.ArrayList;

public class MenuPrincipal {

    private MenuPrincipal() {
    }

    public static int exibir() {
        ArrayList<String> opcoes = new ArrayList<String>();
        opcoes.add("Produtos");
        opcoes.add("Sair");

        Menu menu = new Menu("Menu Principal", opcoes);
        return menu.exibir();
    }
}
