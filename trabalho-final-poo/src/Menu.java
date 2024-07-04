import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        int tipoUsuario;

        do {
            System.out.println("========================================");
            System.out.println("              BEM-VINDO(A)!");
            System.out.println("        MENU DE SELEÇÃO DE USUÁRIO      ");
            System.out.println("========================================");
            System.out.println("1. Interno");
            System.out.println("2. Cliente");
            System.out.println("0. Sair");
            System.out.println("========================================");
            System.out.print("Escolha o tipo de usuário: ");
            tipoUsuario = sc.nextInt();
            sc.nextLine();

            switch (tipoUsuario) {
                case 1:
                    System.out.println("== MENU INTERNO ==");
                    exibirMenuInterno(sistema, sc);
                    break;
                case 2:
                    System.out.println("== MENU CLIENTE ==");
                    exibirMenuCliente(sistema, sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (tipoUsuario != 0);

        sc.close();
    }

    public static void exibirMenuInterno(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("========================================");
            System.out.println("             MENU INTERNO               ");
            System.out.println("========================================");
            System.out.println("1. Inclusão");
            System.out.println("2. Exclusão");
            System.out.println("3. Consulta");
            System.out.println("4. Alteração");
            System.out.println("0. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    exibirMenuInclusao(sistema, sc);
                    break;
                case 2:
                    exibirMenuExclusao(sistema, sc);
                    break;
                case 3:
                    exibirMenuConsulta(sistema, sc);
                    break;
                case 4:
                    exibirMenuAlteracao(sistema, sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenuInclusao(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("----------------------------------------");
            System.out.println("           MENU DE INCLUSÃO             ");
            System.out.println("----------------------------------------");
            System.out.println("1. Incluir Fornecedor");
            System.out.println("2. Incluir Cliente");
            System.out.println("3. Incluir Produto");
            System.out.println("4. Lincar fornecedor e produto");
            System.out.println("0. Voltar");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do fornecedor:");
                    String nome = sc.nextLine();
                    System.out.println("Código:");
                    String codigo = sc.nextLine();
                    System.out.println("Descrição:");
                    String descricao = sc.nextLine();
                    System.out.println("Telefone:");
                    String telefone = sc.nextLine();
                    System.out.println("Email:");
                    String email = sc.nextLine();

                    Endereco endereco = lerEndereco();

                    if (sistema.incluirFornecedor(nome, codigo, descricao, telefone, email, endereco)) {
                        System.out.println("Fornecedor incluido com sucesso!");
                    } else {
                        System.out.println("Erro ao incluir forncedor!");
                    }
                    break;
                case 2:
                    System.out.println("Nome do cliente:");
                    String nomeCliente = sc.nextLine();
                    System.out.println("Código:");
                    String codigoCliente = sc.nextLine();
                    System.out.println("Telefone:");
                    String telefoneCliente = sc.nextLine();
                    System.out.println("E-mail:");
                    String emailCliente = sc.nextLine();
                    System.out.println("Cartão de crédito:");
                    String cartaoCredito = sc.nextLine();

                    Endereco enderecoCliente = lerEndereco();

                    if (sistema.incluirCliente(nomeCliente, codigoCliente, telefoneCliente, emailCliente, cartaoCredito,
                            enderecoCliente)) {
                        System.out.println("Cliente incluido com sucesso!");
                    } else {
                        System.out.println("Erro ao incluir cliente!");
                    }

                    break;
                case 3:
                    System.out.println("Código do produto:");
                    String codigoProduto = sc.nextLine();
                    System.out.println("Nome do produto:");
                    String nomeProduto = sc.nextLine();
                    System.out.println("Descrição:");
                    String descricaoProduto = sc.nextLine();
                    System.out.println("Quantidade em estoque:");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Preço:");
                    double preco = sc.nextDouble();

                    if (sistema.incluirProduto(codigoProduto, nomeProduto, descricaoProduto, null, preco, quantidade)) {
                        System.out.println("Produto incluido com sucesso!");
                    } else {
                        System.out.println("Erro ao incluir produto!");
                    }

                    break;
                case 4:
                    System.out.println("Código do produto:");
                    String codigoProdutoLink = sc.nextLine();
                    System.out.println("Código do fornecedor:");
                    String codigoFornecedor = sc.nextLine();

                    if (sistema.linkProdutoFornecedor(codigoProdutoLink, codigoFornecedor)) {
                        System.out.println("Produto linkado com fornecedor com sucesso!");
                    } else {
                        System.out.println("Erro ao linkar produto com fornecedor!");
                    }
                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenuExclusao(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("----------------------------------------");
            System.out.println("           MENU DE EXCLUSÃO             ");
            System.out.println("----------------------------------------");
            System.out.println("1. Excluir Fornecedor");
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Excluir Produto");
            System.out.println("0. Voltar");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.println("Digite o código do fornecedor que deseja excluir:");
                    String codigo = sc.nextLine();

                    if (sistema.excluirFornecedor(codigo)) {
                        System.out.println("Fornecedor excluído com sucesso!");
                    } else {
                        System.out.println("Fornecedor não encontrado com o código fornecido: " + codigo);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Digite o código do cliente que deseja excluir:");
                    String codigo = sc.nextLine();

                    if (sistema.excluirCliente(codigo)) {
                        System.out.println("Cliente excluído com sucesso!");
                    } else {
                        System.out.println("Cliente não encontrado com o código fornecido: " + codigo);
                    }
                    break;
                }
                case 3: {
                    System.out.println("Digite o código do produto que deseja excluir:");
                    String codigo = sc.nextLine();

                    if (sistema.excluirProduto(codigo)) {
                        System.out.println("Produto excluído com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado com o código fornecido: " + codigo);
                    }
                    break;
                }
                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenuConsulta(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("----------------------------------------");
            System.out.println("           MENU DE CONSULTA             ");
            System.out.println("----------------------------------------");
            System.out.println("1. Consultar Produto por Nome");
            System.out.println("2. Consultar Produto por Código");
            System.out.println("3. Consultar Fornecedor por Nome");
            System.out.println("4. Consultar Fornecedor por Código");
            System.out.println("5. Consultar Cliente por Nome");
            System.out.println("6. Consultar Cliente por Código");
            System.out.println("7. Consultar Pedido por Código");
            System.out.println("8. Consultar Pedido por Data");
            System.out.println("9. Confirmar entrega pedido");
            System.out.println("10. Cancelar pedido");
            System.out.println("0. Voltar");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = sc.nextLine();

                    Produto produto = sistema.consultarProdutoPorNome(nome);
                    if (produto != null) {
                        System.out.println(produto.toString());
                    } else {
                        System.out.println("Produto não encontrado com o nome fornecido: " + nome);
                    }
                    break;

                case 2:
                    System.out.println("Digite o código do produto:");
                    String codigo = sc.nextLine();

                    Produto produtoCodigo = sistema.consultarProdutoPorCodigo(codigo);
                    if (produtoCodigo != null) {
                        System.out.println(produtoCodigo.toString());
                    } else {
                        System.out.println("Produto não encontrado com o nome fornecido: " + codigo);
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do fornecedor:");
                    String nomeFornecedor = sc.nextLine();

                    Fornecedor fornecedor = sistema.consultarFornecedorPorNome(nomeFornecedor);
                    if (fornecedor != null) {
                        System.out.println(nomeFornecedor.toString());
                    } else {
                        System.out.println("Fornecedor não encontrado com o nome fornecido: " + nomeFornecedor);
                    }

                    break;

                case 4:
                    System.out.println("Digite o código do fornecedor:");
                    String codigoFornecedor = sc.nextLine();

                    Fornecedor fornecedorCodigo = sistema.consultarFornecedorPorCodigo(codigoFornecedor);
                    if (fornecedorCodigo != null) {
                        System.out.println(codigoFornecedor.toString());
                    } else {
                        System.out.println("Fornecedor não encontrado com o código fornecido: " + codigoFornecedor);
                    }

                    break;

                case 5:
                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = sc.nextLine();
                
                    Cliente cliente = sistema.consultarClientePorNome(nomeCliente);
                    if (cliente != null) {
                        System.out.println(cliente.toString()); 
                        System.out.println("----------------------------------------");
                        System.out.println("Pedidos do Cliente:");
                        System.out.println("----------------------------------------");
                        sistema.imprimirPedidosPorCliente(cliente.getCodigo());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("Cliente não encontrado com nome fornecido: " + nomeCliente);
                    }
                    break;

                case 6:
                    System.out.println("Digite o código do cliente:");
                    String codigoCliente = sc.nextLine();

                    Cliente clienteCodigo = sistema.consultarClientePorCodigo(codigoCliente);
                    if (clienteCodigo != null) {
                        System.out.println(clienteCodigo.toString());
                        System.out.println("----------------------------------------");
                        System.out.println("Pedidos do Cliente:");
                        System.out.println("----------------------------------------");
                        sistema.imprimirPedidosPorCliente(clienteCodigo.getCodigo());
                        System.out.println("----------------------------------------");
                    } else {
                        System.out.println("Cliente não encontrado com nome fornecido: " + codigoCliente);
                    }
                    break;
                case 7:
                    System.out.println("Digite o número do pedido:");
                    int numeroPedido = sc.nextInt();
                    sc.nextLine();

                    Pedido pedido = sistema.consultarPedidoPorNumero(numeroPedido);
                    if (pedido != null) {
                        System.out.println(pedido.toString());
                    } else {
                        System.out.println("Pedido não encontrado com o número fornecido: " + numeroPedido);
                    }
                    break;

                case 8:
                    System.out.println("Digite a data do pedido (yyyy-mm-dd):");
                    String dataStr = sc.nextLine();

                    try {
                        Date dataPedido = Date.valueOf(dataStr);
                        ArrayList<Pedido> pedidos = sistema.consultarPedidosPorData(dataPedido);
                        if (pedidos != null && !pedidos.isEmpty()) {
                            for (Pedido p : pedidos) {
                                System.out.println(p.toString());
                                System.out.println("----------------------------------------");
                            }
                        } else {
                            System.out.println("Nenhum pedido encontrado para a data fornecida: " + dataStr);
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Formato de data inválido. Por favor, use o formato yyyy-mm-dd.");
                    }
                    break;
                case 9:
                    System.out.println("Digite o número do pedido a ser entregue:");
                    int numeroEntrega = sc.nextInt();
                    sc.nextLine();
                    boolean entregaConfirmada = sistema.confirmarEntregaPedido(numeroEntrega);
                    if (entregaConfirmada) {
                        System.out.println("Entrega do pedido confirmada.");
                    } else {
                        System.out.println("Pedido não encontrado ou já entregue.");
                    }
                    break;

                case 10:
                    System.out.println("Digite o número do pedido a ser cancelado:");
                    int numeroCancelamento = sc.nextInt();
                    sc.nextLine();
                    boolean cancelamentoConfirmado = sistema.cancelarPedido(numeroCancelamento);
                    if (cancelamentoConfirmado) {
                        System.out.println("Pedido cancelado com sucesso.");
                    } else {
                        System.out.println("Pedido não encontrado ou não pode ser cancelado.");
                    }
                    break;

                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    public static void exibirMenuAlteracao(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("----------------------------------------");
            System.out.println("           MENU DE ALTERAÇÃO            ");
            System.out.println("----------------------------------------");
            System.out.println("1. Alterar Fornecedor");
            System.out.println("2. Alterar Cliente");
            System.out.println("3. Alterar Produto");
            System.out.println("0. Voltar");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    alterarFornecedor(sc, sistema);
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente que deseja alterar:");
                    String nomeCliente = sc.nextLine();
            
                    while (true) {
                        System.out.println("O que deseja alterar?");
                        System.out.println("1. Nome");
                        System.out.println("2. Telefone");
                        System.out.println("3. Email");
                        System.out.println("4. Cartão de Crédito");
                        System.out.println("5. Endereço");
                        System.out.println("6. Sair");
            
                        int opcaoCliente = sc.nextInt();
                        sc.nextLine(); 
            
                        if (opcaoCliente == 6) {
                            break;
                        }
            
                        String novoValor = "";
                        Endereco novoEndereco = null;
            
                        if (opcaoCliente >= 1 && opcaoCliente <= 4) {
                            System.out.println("Digite o novo valor:");
                            novoValor = sc.nextLine();
                        } else if (opcaoCliente == 5) {
                            novoEndereco = lerEndereco();
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
            
                        boolean sucesso = sistema.alterarCliente(nomeCliente, opcaoCliente, novoValor, novoEndereco);
                        if (sucesso) {
                            System.out.println("Cliente alterado com sucesso!");
                        } else {
                            System.out.println("Cliente não encontrado ou opção inválida.");
                        }
                        sistema.alterarCliente(nomeCliente, opcaoCliente, novoValor, novoEndereco);
                    }
                        break;
                case 3:
                    System.out.println("Digite o código do produto que deseja alterar:");
                    String codigo = sc.nextLine();
            
                    while (true) {
                        System.out.println("O que deseja alterar?");
                        System.out.println("1. Nome");
                        System.out.println("2. Descrição");
                        System.out.println("3. Quantidade em estoque");
                        System.out.println("4. Preço");
                        System.out.println("5. Sair");
            
                        int opcaoProduto = sc.nextInt();
                        sc.nextLine(); 
            
                        if (opcaoProduto == 5) {
                            break;
                        }
            
                        String novoValor = "";
                        int novaQuantidade = 0;
                        double novoPreco = 0.0;
            
                        if (opcaoProduto == 1 || opcaoProduto == 2) {
                            System.out.println("Digite o novo valor:");
                            novoValor = sc.nextLine();
                        } else if (opcaoProduto == 3) {
                            System.out.println("Nova quantidade em estoque:");
                            novaQuantidade = sc.nextInt();
                            sc.nextLine(); 
                        } else if (opcaoProduto == 4) {
                            System.out.println("Novo preço:");
                            novoPreco = sc.nextDouble();
                            sc.nextLine(); 
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
            
                        boolean sucesso = sistema.alterarProduto(codigo, opcaoProduto, novoValor, novaQuantidade, novoPreco);
                        if (sucesso) {
                            System.out.println("Produto alterado com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado ou opção inválida.");
                        }
                    }
                        break;
                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }while(opcao!=0);

    }

    public static void exibirMenuCliente(Sistema sistema, Scanner sc) {
        int opcao;

        do {
            System.out.println("----------------------------------------");
            System.out.println("             MENU CLIENTE               ");
            System.out.println("----------------------------------------");
            System.out.println("1. Consultar produto");
            System.out.println("2. Realizar pedido");
            System.out.println("3. Consultar pedidos");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    consultarProduto(sistema, sc);
                    break;
                case 2:
                	realizarPedido(sistema, sc);
                    break;
                case 3:
                    consultarPedidosCliente(sistema, sc);
                    break;
                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
    private static void consultarProduto(Sistema sistema, Scanner sc) {
        System.out.println("Digite o código ou uma palavra-chave para pesquisa:");
        String termo = sc.nextLine();

        Produto produto = sistema.consultarProduto(termo);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
    public static Produto escolherProduto(Sistema sistema, Scanner sc) {
        System.out.println("\n\nLista de Produtos: \nEscolha o produto que deseja adicionar ao carrinho");
        for (int i = 0; i < sistema.getProdutos().size(); i++) {
            System.out.println((i + 1) + ". " + sistema.getProdutos().get(i).toString());
        }

        System.out.println("Digite o código do produto ou a posição na lista:");
        String entrada = sc.nextLine();

        try {
            int posicao = Integer.parseInt(entrada) - 1;
            if (posicao >= 0 && posicao < sistema.getProdutos().size()) {
                return sistema.getProdutos().get(posicao);
            } else {
                System.out.println("Posição inválida.");
            }
        } catch (NumberFormatException e) {
            for (Produto produto : sistema.getProdutos()) {
                if (produto.getCodigo().equals(entrada)) {
                    return produto;
                }
            }
            System.out.println("Código do produto não encontrado.");
        }

        return null;
    }
    private static void realizarPedido(Sistema sistema, Scanner sc) {
        System.out.println("Digite o código do cliente:");
        String codigoCliente = sc.nextLine();
        Cliente cliente = sistema.consultarClientePorCodigo(codigoCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
        
        //String codigoProduto = sc.nextLine();
        System.out.println("Escolha o produto na lista abaixo:");

        Produto produto = escolherProduto(sistema, sc);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.println("Digite a quantidade:");
        int quantidade = sc.nextInt();
        sc.nextLine();
        System.out.println("Valor total do item: "+(produto.getEstoque().getPreco() * quantidade)+"\nAdicionar ao carrinho? (s/n)");
        String resposta = sc.nextLine();
        if (resposta.equalsIgnoreCase("s")) {
        	int pedido = sistema.realizarPedido(cliente, produto, quantidade, sc);
            if (pedido > 0) {
            	boolean maisProdutos = true;
                while (maisProdutos) {
                	System.out.println("Deseja adicionar mais produtos ao pedido? (s/n)");
                     resposta = sc.nextLine();
                    if (!resposta.equalsIgnoreCase("s")) {
                        maisProdutos = false;
                        continue;
                    }
                    System.out.println("Digite o código do produto:");
                    String codigoProduto2 = sc.nextLine();
                    Produto produto2 = sistema.consultarProdutoPorCodigo(codigoProduto2);

                    if (produto2 == null) {
                        System.out.println("Produto não encontrado.");
                        continue;
                    }

                    System.out.println("Digite a quantidade:");
                    int quantidade2 = sc.nextInt();
                    sc.nextLine();

                    sistema.adicionarAoPedido(pedido, produto2, quantidade2, sc);
                }
                Pedido p = sistema.consultarPedidoPorNumero(pedido);
                if (p != null) {
                    double valorTotalPedido = p.getValorTotal();
                    double valorComIcms = valorTotalPedido * 1.17;
                    System.out.println("Resumo do Pedido:");
                    System.out.println(pedido);
                    System.out.println("Valor total com ICMS (17%): " + valorComIcms);
                    System.out.println("Confirmar pedido? (s/n)");
                    String confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("s")) {
                    	p.setSituacao("NOVO");
                    	sistema.salvaPedidos();
                        System.out.println("Pedido confirmado!");
                    } else {
                        System.out.println("Pedido cancelado.");
                        // Se desejar, você pode implementar uma lógica para cancelar o pedido no sistema
                    }
                } else {
                    System.out.println("Erro ao recuperar o pedido.");
                }
            } else {
                System.out.println("Erro ao realizar pedido.");
            }
        }
        
    }
    private static void consultarPedidosCliente(Sistema sistema, Scanner sc) {
        System.out.println("Digite o código do cliente:");
        String codigoCliente = sc.nextLine();

        Cliente cliente = sistema.consultarClientePorCodigo(codigoCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        List<Pedido> pedidos = sistema.consultarPedidosCliente(cliente);
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado para este cliente.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }	

    private static void alterarFornecedor(Scanner sc, Sistema sistema) {
        System.out.println("Digite o nome do fornecedor que deseja alterar:");
        String nome = sc.nextLine();

        while (true) {
            System.out.println("O que deseja alterar?");
            System.out.println("1. Nome");
            System.out.println("2. Descrição");
            System.out.println("3. Telefone");
            System.out.println("4. Email");
            System.out.println("5. Endereço");
            System.out.println("6. Sair");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpa o scanner

            if (opcao == 6) {
                break;
            }

            String novoValor = "";
            Endereco novoEndereco = null;

            if (opcao >= 1 && opcao <= 4) {
                System.out.println("Digite o novo valor:");
                novoValor = sc.nextLine();
            } else if (opcao == 5) {
                novoEndereco = lerEndereco();
            } else {
                System.out.println("Opção inválida.");
                continue;
            }

            boolean sucesso = sistema.alterarFornecedor(nome, opcao, novoValor, novoEndereco);
            if (sucesso) {
                System.out.println("Fornecedor alterado com sucesso!");
            } else {
                System.out.println("Fornecedor não encontrado ou opção inválida.");
            }
        }
    }

    // Métodos para entrada de dados

    private static String lerString(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextLine();
    }

    private static Endereco lerEndereco() {
        String rua = lerString("Rua:");
        String numero = lerString("Número:");
        String complemento = lerString("Complemento:");
        String bairro = lerString("Bairro:");
        String cidade = lerString("Cidade:");
        String cep = lerString("CEP:");
        String estado = lerString("Estado:");
        return new Endereco(rua, numero, complemento, bairro, cidade, cep, estado);
    }
}
