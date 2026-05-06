package temadogrupo.utilitarios.menu;

import java.util.ArrayList;
import temadogrupo.utilitarios.Teclado;
import temadogrupo.utilitarios.Video;

/*
 * SOLID S: esta classe cuida apenas da exibicao de um menu generico
 * e da leitura da opcao escolhida.
 */

public class Menu {

    private String titulo;
    private ArrayList<String> opcoesMenu;

    public Menu(String titulo, ArrayList<String> opcoesMenu) {
        this.titulo = titulo;
        this.opcoesMenu = opcoesMenu;
    }

    public int exibir() {
        int opcaoEscolhida;

        Video.cabecalho(titulo);

        for (int indice = 0; indice < opcoesMenu.size(); indice++) {
            Video.mensagem((indice + 1) + " - " + opcoesMenu.get(indice));
        }

        Video.linhaEmBranco();

        do {
            opcaoEscolhida = Teclado.readInteger("Qual a sua opcao: ");

            if (opcaoEscolhida < 1 || opcaoEscolhida > opcoesMenu.size()) {
                Video.mensagemAlerta("Opcao invalida. Tente novamente.");
            }
        } while (opcaoEscolhida < 1 || opcaoEscolhida > opcoesMenu.size());

        return opcaoEscolhida;
    }
}
