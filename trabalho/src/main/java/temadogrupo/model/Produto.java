package temadogrupo.model;

/*
 * Classe de dominio da aplicacao.
 *
 * Padrao Builder:
 * O produto passa a ser construido por um objeto auxiliar chamado ProdutoBuilder.
 * Isso evita espalhar muitos construtores quando a entidade crescer com novos atributos.
 *
 * Exemplo de uso:
 * Produto produto = Produto.builder()
 *         .comId(1)
 *         .comNome("Teclado")
 *         .construir();
 *
 * SOLID S: esta classe possui apenas a responsabilidade de representar
 *          os dados de um produto no dominio da aplicacao.
 * 
 * Validacoes:
 * Local	            Responsabilidade	            Exemplo
 * Controller ou DTO	Validar formato da entrada	    Atributo obrigatorio
 * Servico	            Validar caso de uso	            Produto duplicado, permissao, regra que consulta repositorio                                                      
 * Dominio	            Validar invariante do objeto	Produto nao pode existir sem nome valido
 *  
 * Em sistemas maiores, esta classe será derivada em Anemica, JPA, Mapper, DTO, etc... Intermediando back e front ends.
 * 
 */

public class Produto {

    private final int id;
    private final String nome;

    private Produto(ProdutoBuilder produtoBuilder) {
        this.id = produtoBuilder.id;
        // Aqui faz a validacao
        this.nome = validarNome(produtoBuilder.nome);
    }

    public static ProdutoBuilder builder() {
        return new ProdutoBuilder();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    private static String validarNome(String nome)
            throws IllegalArgumentException {
        if (nome == null) {
            // Pode usar esta excecao generica ou partir para personalizar as excecoes para
            // o sistema
            throw new IllegalArgumentException("O nome do produto não pode ser nulo.");
        }

        String nomeTratado = nome.trim();

        if (nomeTratado.isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }

        return nomeTratado;
    }

    @Override
    public String toString() {
        return "Produto{id=" + id + ", nome='" + nome + "'}";
    }

    /*
     * Classe auxiliar do Padrao Builder.
     *
     * Ela guarda temporariamente os dados usados para construir Produto.
     * Ao final, o metodo construir cria o objeto Produto pronto para uso.
     */

    public static class ProdutoBuilder {

        private int id;
        private String nome;

        public ProdutoBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ProdutoBuilder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Produto construir() {
            return new Produto(this);
        }
    }
}
