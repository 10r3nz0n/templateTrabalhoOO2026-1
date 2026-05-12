# Projeto Java SOLID adaptado ao Template OO com Java 25

Projeto didatico com App, Menu, Controller, Service e Repository.

## Requisito

JDK 25, pois as classes utilitarias usam `java.lang.IO`.

## Como clonar

- Entra na pasta de seu workspace de projetos pelo terminal.
- Digite git clone https://github.com/10r3nz0n/templateTrabalhoOO2026-1.git

## Como executar

```bash
cd trabalho
mvn clean package
mvn exec:java
```

## Fluxo

```text
App Singleton
AplicacaoFactory
MenuPrincipal / MenuProduto
ProdutoController
ProdutoService
ProdutoRepository
ProdutoRepositoryMemoria
```

## Padroes usados

- `App` usa o Padrao Singleton para representar uma unica aplicacao principal em execucao.
- `AplicacaoFactory` usa uma Simple Factory didatica para montar Controller, Service e Repository.
- `Produto` usa o Padrao Builder para construir objetos de dominio de forma mais organizada.

## Relacao com API REST

- No console, o `MenuPrincipal` aciona o `ProdutoController`.
- Em uma API REST, uma rota HTTP acionaria o controller.
- Em uma API REST com framework, o framework costuma montar controllers, services e repositories.
- Nesta aplicacao sem framework, a `AplicacaoFactory` faz manualmente essa montagem.

## Observacao

- `Video` centraliza a saida com `IO.print` e `IO.println`.
- `Teclado` centraliza a entrada com `IO.readln`.
- `ProdutoRepository` e uma interface com metodos sem corpo.
- `ProdutoRepositoryMemoria` implementa a interface.
