import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    
    private ArrayList<Fornecedor> fornecedores;
    private ArrayList<Produto> produtos;
    private int contaFornecedor;

    
    public Sistema() {
        fornecedores = new ArrayList<>();
        produtos = new ArrayList<>();
        contaFornecedor = 0;
        
    }

    //método para incluir um fornecedor
    public void incluirFornecedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do fornecedor:");
        String nome = sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Telefone:");
        String telefone = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        System.out.println("Rua:");
        String rua = sc.nextLine();
        System.out.println("Número:");
        String numero = sc.nextLine();
        System.out.println("Complemento:");
        String complemento = sc.nextLine();
        System.out.println("Bairro:");
        String bairro = sc.nextLine();
        System.out.println("Cidade:");
        String cidade = sc.nextLine();
        System.out.println("CEP:");
        String cep = sc.nextLine();
        System.out.println("Estado:");
        String estado = sc.nextLine();
    
        Endereco endereco = new Endereco(rua, numero, complemento, bairro, cidade, cep, estado);
        Fornecedor fornecedor = new Fornecedor(nome, descricao, telefone, email, endereco);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");

        System.out.println(fornecedores.get(contaFornecedor).toString());
        contaFornecedor++;
        
    }

    //método para excluir um fornecedor
    public void excluirFornecedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do fornecedor que deseja excluir:");
        String nome = sc.nextLine();
    
        boolean fornecedorEncontrado = false;
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor f = fornecedores.get(i);
            if (f.getNome().equalsIgnoreCase(nome)) {
                fornecedores.remove(i);
                fornecedorEncontrado = true;
                System.out.println("Fornecedor excluído com sucesso!");
                return;
            }
        }

        System.out.println("Forncedor não encontrado com nome fornecido.");
    
    }


    //método para incluir um produto
    public void incluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do produto:");
        String nome = sc.nextLine();
        System.out.println("Código do produto:");
        int codigo = sc.nextInt();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Quantidade em estoque:");
        int quantidade = sc.nextInt();
        System.out.println("Preço:");
        double preco = sc.nextDouble();
    
        Estoque estoque = new Estoque(quantidade, preco);
        Produto produto = new Produto(codigo, nome, descricao, new byte[0], estoque);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }


    //método para excluir um produto
    public void excluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto que deseja excluir:");
        String nome = sc.nextLine();
    
        boolean produtoEncontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getNome().equalsIgnoreCase(nome)) {
                produtos.remove(i);
                produtoEncontrado = true;
                System.out.println("Produto excluído com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado com nome fornecido.");
    }
    
        
    //método para consultar um produto por NOME
    public void consultarProdutoPorNome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto:");
        String nome = sc.nextLine();
    
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                System.out.println(p.toString());
                return;

            }
        }
        System.out.println("Produto não encontrado com nome fornecido: " + nome);
    }
    
    //método para consultar produto por CÓDIGO
    public void consultarProdutoPorCodigo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto:");
        int codigo = sc.nextInt();

        for(Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                System.out.println(p.toString());
                return;
            }
        }
        System.out.println("Produto não encontrado com código forncecido: " + codigo);
        
    }


    //método para consultar fornecedor por NOME
    public void consultarFornecedorPorNome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do fornecedor:");
        String nome = sc.nextLine();

        for (Fornecedor f : fornecedores) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                System.out.println(f.toString());
                return;
            }
        }
        System.out.println("Fornecedor não encontrado com nome fornecido: " + nome);
    }


    //método para alterar fornecedor 
    public void alterarFornecedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do fornecedor que deseja alterar:");
        String nome = sc.nextLine();
    
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                boolean continuarAlterando = true;
                while (continuarAlterando) {
                    System.out.println("O que deseja alterar?");
                    System.out.println("1. Nome");
                    System.out.println("2. Descrição");
                    System.out.println("3. Telefone");
                    System.out.println("4. Email");
                    System.out.println("5. Endereço");
                    System.out.println("6. Sair");
    
                    int opcao = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner
    
                    switch (opcao) {
                        case 1:
                            System.out.println("Novo nome:");
                            String novoNome = sc.nextLine();
                            fornecedor.setNome(novoNome);
                            break;
                        case 2:
                            System.out.println("Nova descrição:");
                            String novaDescricao = sc.nextLine();
                            fornecedor.setDescricao(novaDescricao);
                            break;
                        case 3:
                            System.out.println("Novo telefone:");
                            String novoTelefone = sc.nextLine();
                            fornecedor.setTelefone(novoTelefone);
                            break;
                        case 4:
                            System.out.println("Novo email:");
                            String novoEmail = sc.nextLine();
                            fornecedor.setEmail(novoEmail);
                            break;
                        case 5:
                            System.out.println("Novo endereço:");
                            System.out.println("Rua:");
                            String novaRua = sc.nextLine();
                            System.out.println("Número:");
                            String novoNumero = sc.nextLine();
                            System.out.println("Complemento:");
                            String novoComplemento = sc.nextLine();
                            System.out.println("Bairro:");
                            String novoBairro = sc.nextLine();
                            System.out.println("Cidade:");
                            String novaCidade = sc.nextLine();
                            System.out.println("CEP:");
                            String novoCep = sc.nextLine();
                            System.out.println("Estado:");
                            String novoEstado = sc.nextLine();
    
                            Endereco novoEndereco = new Endereco(novaRua, novoNumero, novoComplemento, novoBairro, novaCidade, novoCep, novoEstado);
                            fornecedor.setEndereco(novoEndereco);
                            break;
                        case 6:
                            continuarAlterando = false;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
                System.out.println("Fornecedor alterado com sucesso!");
                return;
            
            } 
            System.out.println("Fornecedor não encontrado com o nome forncecido: " + nome);

        }
    }

    //método para alterar produto
    public void alterarProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto que deseja alterar:");
        int codigo = sc.nextInt();
    
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                 boolean produtoEncontrado = true;
                while (produtoEncontrado) {
                    System.out.println("O que deseja alterar?");
                    System.out.println("1. Nome");
                    System.out.println("2. Descrição");
                    System.out.println("3. Quantidade em estoque");
                    System.out.println("4. Preço");
                    System.out.println("5. Sair");
    
                    int opcao = sc.nextInt();
                    sc.nextLine(); // Limpar o buffer do scanner
    
                    switch (opcao) {
                        case 1:
                            System.out.println("Novo nome:");
                            String novoNome = sc.nextLine();
                            p.setNome(novoNome);
                            break;
                        case 2:
                            System.out.println("Nova descrição:");
                            String novaDescricao = sc.nextLine();
                            p.setDescricao(novaDescricao);
                            break;
                        case 3:
                            System.out.println("Nova quantidade em estoque:");
                            int novaQuantidade = sc.nextInt();
                            p.getEstoque().setQuantidade(novaQuantidade);
                            break;
                        case 4:
                            System.out.println("Novo preço:");
                            double novoPreco = sc.nextDouble();
                            p.getEstoque().setPreco(novoPreco);
                            break;
                        case 5:
                            System.out.println("Produto alterado com sucesso!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            return;
                    }
                }
            }
        }
        System.out.println("Produto não econtrado com código fornecido: " + codigo);
    }

}
