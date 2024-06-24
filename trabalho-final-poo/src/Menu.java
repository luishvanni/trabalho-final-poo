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
                    sistema.alterarFornecedor();
                    break;
                case 2:
                    sistema.alterarCliente();
                    break;
                case 3:
                    sistema.alterarProduto();
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
            System.out.println("1. Consultar Produto por Nome");
            System.out.println("2. Consultar Produto por Código");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.alterarFornecedor();
                    break;
                case 2:
                    sistema.alterarCliente();
                    break;
                case 3:
                    sistema.alterarProduto();
                    break;
                case 0:
                    System.out.println("Voltando ao menu interno...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
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
