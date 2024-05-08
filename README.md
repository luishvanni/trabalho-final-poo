# Sistema de Controle de Estoque e Pedidos

Este repositório contém a implementação de um sistema de controle de estoque e pedidos em Java, conforme especificado abaixo:

## Parte 1 - Ator Administrador

- Cadastro de fornecedores
- Cadastro de produtos, relacionando-os aos fornecedores
- Manutenção do estoque de produtos

Para cada cadastro, foram implementadas as seguintes funcionalidades:

- Inclusão
- Alteração
- Exclusão
- Consulta (por código e por nome)

Na primeira parte do trabalho, foram utilizados vetores para conter os objetos. Na segunda parte, os vetores foram substituídos por Listas.

## Parte 2

### Ator Cliente

- Tela de consulta de produtos (com pesquisa) e realização de pedidos
  - Carrinho de compras
- Tela de consulta de pedidos
  - Consulta por número do pedido ou intervalo de datas

### Regras para vendas

- Só se pode vender itens que estão em estoque
- Itens com estoque ZERO são mostrados como indisponíveis na consulta
- A realização do pedido diminui a quantidade do estoque
- Se o cliente quiser comprar mais do que há em estoque, recebe uma mensagem de erro, oferecendo-lhe a quantidade máxima disponível
- Deve ser calculado o valor total do pedido e exibido ao cliente
- Tela de consulta de pedidos realizados por parte da administração da loja (Ator Interno)
  - Consulta por número do pedido ou data de realização

A aplicação implementa todos os requisitos previstos no documento, seguindo como padrão de comportamento os sites como Amazon, Mercado Livre ou AliExpress. O sistema é utilizado por dois atores: Internos e Clientes, acessando as funcionalidades através de menus.

## Modelo de Classes

O modelo de classes da aplicação proposta está presente no código fonte.

## Divisão do Trabalho

O trabalho foi dividido em duas partes. A primeira consistiu na implementação das funcionalidades de cadastros de Produtos (com Estoque), Clientes (com Endereço) e Fornecedores (com Endereço). A segunda parte, com a aplicação completa, foi entregue no final do semestre.

Na segunda parte do trabalho, os dados foram todos gravados em arquivos e recuperados a cada execução do programa, simulando uma aplicação que faz uso de bancos de dados. Também foi necessário utilizar exceções programadas pelo desenvolvedor, como no caso de quantidade insuficiente de produtos para realizar um pedido.

## Execução do Programa

Para inicializar o projeto em seu computador, siga os passos abaixo:

### Clonar o Repositório

Abra o terminal e navegue até o diretório onde deseja clonar o repositório. Em seguida, execute o seguinte comando:

```bash
git clone https://github.com/luishvanni/trabalho-final-poo.git
```

##Configurar o Ambiente de Desenvolvimento

Certifique-se de ter o Java Development Kit (JDK) instalado no seu computador. Você pode verificar a instalação usando o comando java -version.
Abra o projeto em um IDE Java, como o Eclipse ou o IntelliJ IDEA.

## Autores

- [@luishvanni](https://www.github.com/luishvanni)
