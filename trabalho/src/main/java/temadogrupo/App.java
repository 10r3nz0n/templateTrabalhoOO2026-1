package temadogrupo;

import temadogrupo.config.AplicacaoFactory;
import temadogrupo.controller.ProdutoController;
import temadogrupo.utilitarios.Video;
import temadogrupo.utilitarios.menu.MenuPrincipal;

/*
 * Classe de entrada da aplicacao.
 *
 * Padrao Singleton:
 * Esta classe foi modelada como Singleton para existir apenas uma instancia
 * principal controlando o ciclo de vida da aplicacao de console.
 *
 * Observacao didatica:
 * Este Singleton representa a aplicacao de console como objeto unico.
 * Em ambientes web, o ciclo de vida costuma ser controlado pelo framework.
 *
 * Ideia didatica:
 * Em uma aplicacao desktop ou console, a App representa o processo principal.
 * Em uma API REST, o servidor e o framework mantem o ciclo da aplicacao ativo
 * e encaminham requisicoes HTTP para controllers.
 *
 * Relacao com API REST:
 * Console: MenuPrincipal aciona ProdutoController.
 * API REST: Uma rota HTTP acionaria ProdutoController.
 *
 * SOLID S: esta classe cuida apenas do ciclo principal da aplicacao.
 * Ela inicia, apresenta o menu principal e direciona o usuario para o modulo escolhido.
 *
 * SOLID D: a App nao cria Repository, Service e Controller diretamente.
 * Ela depende da AplicacaoFactory, que centraliza a montagem das dependencias.
 */

public class App {

    private static App instancia;
    private final AplicacaoFactory aplicacaoFactory;

    // Aplicacao

    public static void main(String[] args) {

        try {

            App app = App.getInstancia();
            app.iniciar();
            app.executar();

        } catch (Exception e) {

            IO.println("Erro: " + e.getMessage());

        }
    }

    // Parte Singleton, priva o construtor e tem-se um metodo para devolver o objeto

    private App(AplicacaoFactory aplicacaoFactory) {
        this.aplicacaoFactory = aplicacaoFactory;
    }

    public static synchronized App getInstancia() {
        if (instancia == null) {
            instancia = criarAplicacao();
        }

        return instancia;
    }

    // Fim parte Singleton

    // Metodos auxiliares da APP

    // O que precisa ser construido quando a aplicacao começa
    private static App criarAplicacao() {
        AplicacaoFactory aplicacaoFactory = new AplicacaoFactory();

        return new App(aplicacaoFactory);
    }

    // Iniciando a aplicacao
    private void iniciar() {
        Video.mensagem("Carregando...");
        Video.barraProgresso(30, 10);
        Video.cabecalho("Nossa aplicacao");
    }

    // Executando a aplicacao
    private void executar() {
        int opcaoPrincipal = 0;

        while (opcaoPrincipal != 2) {
            opcaoPrincipal = MenuPrincipal.exibir();

            if (opcaoPrincipal == 1) {
                executarModuloProduto();
            }

            // Aqui vao entrar as outras opcoes do sistema

            else if (opcaoPrincipal == 2) {
                Video.mensagemInfo("Saindo do sistema...");
            }
        }
    }

    // Cada modulo contera seu Factory, para devolver o controler e instanciar o que
    // precisa por vez e nao tudo
    // no carregamento da aplicacao, por isso o Factory
    private void executarModuloProduto() {
        ProdutoController produtoController = aplicacaoFactory.getProdutoController();
        produtoController.executar();
    }
}
