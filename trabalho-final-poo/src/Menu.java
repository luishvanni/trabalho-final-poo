import java.text.SimpleDateFormat;
import java.util.Date;
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
                        System.out.println(nomeCliente.toString());
                    } else {
                        System.out.println("Cliente não encontrado com nome fornecido: " + nomeCliente);
                    }
                    break;

                case 6:
                    System.out.println("Digite o código do cliente:");
                    String codigoCliente = sc.nextLine();

                    Cliente clienteCodigo = sistema.consultarClientePorCodigo(codigoCliente);
                    if (clienteCodigo != null) {
                        System.out.println(codigoCliente.toString());
                    } else {
                        System.out.println("Cliente não encontrado com nome fornecido: " + codigoCliente);
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
                        sc.nextLine(); // limpa o scanner
            
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
                        sc.nextLine(); // limpa o scanner
            
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
                            sc.nextLine(); // limpa o scanner
                        } else if (opcaoProduto == 4) {
                            System.out.println("Novo preço:");
                            novoPreco = sc.nextDouble();
                            sc.nextLine(); // limpa o scanner
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
                    System.out.print("Digite o código ou uma palavra-chave para pesquisa: ");
                    String termo = sc.nextLine();
                    List<Produto> resultado = sistema.pesquisarProduto(termo);
        
                    if (resultado.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                        break;
                    }
        
                    sistema.mostrarProdutos(resultado);
        
                    System.out.print("Digite o número do produto para adicionar ao carrinho ou 0 para voltar ao menu: ");
                    int escolhaProduto = sc.nextInt();
                    sc.nextLine();  // Consumir a nova linha
        
                    if (escolhaProduto == 0) {
                        break;
                    }
        
                    if (escolhaProduto < 1 || escolhaProduto > resultado.size()) {
                        System.out.println("Produto inválido.");
                        break;
                    }
        
                    Produto produtoEscolhido = resultado.get(escolhaProduto - 1);
        
                    System.out.print("Digite a quantidade desejada: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();  // Consumir a nova linha
        
                    if (produtoEscolhido.getEstoque().getQuantidade() >= quantidade) {
                        double precoTotal = produtoEscolhido.getEstoque().getPreco() * quantidade;
                        System.out.println("Total do item: " + String.format("%.2f", precoTotal));
                        System.out.print("Deseja confirmar a adição ao carrinho? (s/n): ");
                        String confirmar = sc.nextLine();
        
                        if (confirmar.equalsIgnoreCase("s")) {
                            sistema.adicionarProdutoAoCarrinho(produtoEscolhido, quantidade);
                        }
                    } else {
                        System.out.println("Quantidade solicitada é maior do que a disponível em estoque.");
                    }
                    break;
        
                case 2:
                    sistema.realizarPedido();
                    break;
        
                case 3:
                    System.out.println("1. Consultar por número do pedido");
                    System.out.println("2. Consultar por intervalo de datas");
                    System.out.print("Escolha uma opção: ");
                    int escolhaPedido = sc.nextInt();
                    sc.nextLine();  // Consumir a nova linha
        
                    switch (escolhaPedido) {
                        case 1:
                            System.out.print("Digite o número do pedido (número na lista): ");
                            int numero = sc.nextInt();
                            sc.nextLine();  // Consumir a nova linha
                            sistema.visualizarPedido(numero);
                            break;
        
                        case 2:
                            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                            System.out.print("Digite a data de início (dd-MM-yyyy): ");
                            String dataInicioStr = sc.nextLine();
                            System.out.print("Digite a data de fim (dd-MM-yyyy): ");
                            String dataFimStr = sc.nextLine();
        
                            try {
                                Date dataInicio = formatter.parse(dataInicioStr);
                                Date dataFim = formatter.parse(dataFimStr);
                                List<Pedido> pedidos = sistema.consultarPedidosPorData(dataInicio, dataFim);
        
                                if (pedidos.isEmpty()) {
                                    System.out.println("Nenhum pedido encontrado nesse intervalo.");
                                } else {
                                    for (Pedido p : pedidos) {
                                        System.out.println(p);
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("Formato de data inválido.");
                            }
                            break;
        
                        default:
                            System.out.println("Opção inválida.");
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
