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
            System.out.println("0. Voltar");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    sistema.incluirFornecedor();
                    break;
                case 2:
                    sistema.incluirCliente();
                    break;
                case 3:
                    sistema.incluirProduto();
                    break;
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
                case 1:
                    sistema.excluirFornecedor();
                    break;
                case 2:
                    sistema.excluirCliente();
                    break;
                case 3:
                    sistema.excluirProduto();
                    break;
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
                    sistema.consultarProdutoPorNome();
                    break;
                case 2:
                    sistema.consultarProdutoPorCodigo();
                    break;
                case 3:
                    sistema.consultarFornecedorPorNome();
                    break;
                case 4:
                    sistema.consultarFornecedorPorCodigo();
                    break;
                case 5:
                    sistema.consultarClientePorNome();
                    break;
                case 6:
                    sistema.consultarClientePorCodigo();
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
        } while (opcao != 0);
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
                    System.out.println("== Consultar Produto por Nome ==");
                    sistema.consultarProdutoPorNome();
                    break;
                case 2:
                    System.out.println("== Consultar Produto por Código ==");
                    sistema.consultarProdutoPorCodigo();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}