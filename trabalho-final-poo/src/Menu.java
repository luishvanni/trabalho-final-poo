import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("========================================");
            System.out.println("             MENU PRINCIPAL             ");
            System.out.println("========================================");
            System.out.println("1. Incluir Fornecedor");
            System.out.println("2. Excluir Fornecedor");
            System.out.println("3. Incluir Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Consultar Produto por Nome");
            System.out.println("6. Consultar Produto por Código");
            System.out.println("7. Consultar Fornecedor por Nome");
            System.out.println("8. Alterar Fornecedor");
            System.out.println("9. Alterar Produto");
            System.out.println("0. Sair");
            System.out.println("========================================");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("== Incluir Fornecedor ==");
                    sistema.incluirFornecedor();
                    break;
                case 2:
                    System.out.println("== Excluir Fornecedor ==");
                    sistema.excluirFornecedor();
                    break;
                case 3:
                    System.out.println("== Incluir Produto ==");
                    sistema.incluirProduto();
                    break;
                case 4:
                    System.out.println("== Excluir Produto ==");
                    sistema.excluirProduto();
                    break;
                case 5:
                    System.out.println("== Consultar Produto por Nome ==");
                    sistema.consultarProdutoPorNome();
                    break;
                case 6:
                    System.out.println("== Consultar Produto por Código ==");
                    sistema.consultarProdutoPorCodigo();
                    break;
                case 7:
                    System.out.println("== Consultar Fornecedor por Nome ==");
                    sistema.consultarFornecedorPorNome();
                    break;
                case 8:
                    System.out.println("== Alterar Fornecedor ==");
                    sistema.alterarFornecedor();
                    break;
                case 9:
                    System.out.println("== Alterar Produto ==");
                    sistema.alterarProduto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println("========================================");
            System.out.println();
        } while (opcao != 0);

        sc.close();
    }
}