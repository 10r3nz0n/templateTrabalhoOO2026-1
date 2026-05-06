package temadogrupo.controller;

import java.util.List;
import temadogrupo.model.Produto;
import temadogrupo.service.ProdutoService;
import temadogrupo.utilitarios.Teclado;
import temadogrupo.utilitarios.Video;
import temadogrupo.utilitarios.menu.MenuProduto;

/*
 * SOLID S: esta classe controla o fluxo de tela do modulo de produtos.
 * Ela recebe a escolha do usuario, coleta dados pela classe Teclado,
 * exibe mensagens pela classe Video e chama o ProdutoService.
 *
 * O controller nao conhece detalhes de persistencia.
 *
 * Padrao Builder:
 * Na criacao de Produto, o controller usa Produto.builder().
 * Assim, a construcao do objeto fica mais clara e preparada para crescer
 * quando Produto tiver mais atributos.
 */

public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void executar() {
        int opcaoProduto = 0;

        while (opcaoProduto != 4) {
            opcaoProduto = MenuProduto.exibir();

            if (opcaoProduto == 1) {
                listarProdutos();
            } else if (opcaoProduto == 2) {
                cadastrarProduto();
            } else if (opcaoProduto == 3) {
                excluirProduto();
            }
        }
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();

        Video.cabecalho("Produtos cadastrados");

        if (produtos.isEmpty()) {
            Video.mensagemAlerta("Nenhum produto cadastrado.");
            Video.pausarEnterContinuar();
            return;
        }

        /*
         * for (int indice = 0; indice < produtos.size(); indice++) {
         * Produto produto = produtos.get(indice);
         * Video.mensagem(produto.toString());
         * }
         */

        // ou For each
        for (Produto produto : produtos) {
            Video.mensagem(produto.toString());
        }

        Video.pausarEnterContinuar();
    }

    private void cadastrarProduto() {
        Video.cabecalho("Cadastrar produto");

        int id = Teclado.readInteger("Id: ");
        String nome = Teclado.readString("Nome: ");

        Produto produto = Produto.builder()
                .setId(id)
                .setNome(nome)
                .construir();
        try {
            produtoService.adicionarProduto(produto);
        } catch (IllegalArgumentException e) {
            IO.println("Erro: " + e.getMessage());
        }

        Video.mensagemOk("Produto cadastrado.");
        Video.pausarEnterContinuar();
    }

    private void excluirProduto() {
        Video.cabecalho("Excluir produto");

        int id = Teclado.readInteger("Id para exclusao: ");

        produtoService.excluirProduto(id);
        Video.mensagemOk("Operacao de exclusao enviada.");
        Video.pausarEnterContinuar();
    }
}