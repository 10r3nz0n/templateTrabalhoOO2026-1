package temadogrupo.config;

import temadogrupo.controller.ProdutoController;
import temadogrupo.repository.ProdutoRepository;
import temadogrupo.repository.ProdutoRepositoryMemoria;
import temadogrupo.service.ProdutoService;

/*
 * Classe responsavel por montar os objetos principais da aplicacao.
 *
 * Este arquivo representa uma Simple Factory didatica.
 * Ela concentra a criacao de Repository, Service e Controller.
 *
 * A App Singleton usa esta factory para nao ficar responsavel por conhecer
 * diretamente todas as classes concretas da cadeia Controller, Service e Repository.
 *
 * Relacao com API REST:
 * Em uma API REST com framework, como Spring, o framework normalmente cria
 * controllers, services e repositories e injeta as dependencias automaticamente.
 * Nesta aplicacao de console, como nao existe framework, esta factory faz
 * manualmente uma parte parecida desse trabalho de configuracao.
 *
 * Menu de console:
 * MenuPrincipal aciona ProdutoController.
 *
 * API REST:
 * Uma rota HTTP acionaria ProdutoController.
 *
 * Nos dois cenarios, o controller continua sendo o ponto de entrada do caso de uso.
 *
 * SOLID S: esta classe tem uma responsabilidade principal: criar e conectar dependencias.
 * SOLID D: as camadas superiores recebem objetos prontos por composicao.
 * SOLID O: outro repositorio pode ser usado sem mudar ProdutoService ou ProdutoController.
 */
public class AplicacaoFactory {

    private ProdutoController produtoController;

    public ProdutoController getProdutoController() {
        if (produtoController == null) {
            produtoController = criarProdutoController();
        }

        return produtoController;
    }

    private ProdutoController criarProdutoController() {
        ProdutoRepository produtoRepository = criarProdutoRepository();
        ProdutoService produtoService = new ProdutoService(produtoRepository);

        return new ProdutoController(produtoService);
    }

    private ProdutoRepository criarProdutoRepository() {
        return new ProdutoRepositoryMemoria();
    }
}
