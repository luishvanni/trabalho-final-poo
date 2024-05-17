import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    
    private ArrayList<Fornecedor> fornecedores;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;

    
    public Sistema() {
        fornecedores = new ArrayList<>();
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        
    }

    // Métodos para entrada de dados

    private String lerString(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextLine();
    }

    private Endereco lerEndereco() {
        String rua = lerString("Rua:");
        String numero = lerString("Número:");
        String complemento = lerString("Complemento:");
        String bairro = lerString("Bairro:");
        String cidade = lerString("Cidade:");
        String cep = lerString("CEP:");
        String estado = lerString("Estado:");
        return new Endereco(rua, numero, complemento, bairro, cidade, cep, estado);
    }

    // Método para incluir um fornecedor
    public void incluirFornecedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do fornecedor:");
        String nome = sc.nextLine();
        System.out.println("Código:");
        int codigo = sc.nextInt();

        // Verificar se já existe um fornecedor com o mesmo código
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getCodigo() == codigo) {
                System.out.println("Já existe um fornecedor com esse código.");
                return;
        }
    }
        sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Telefone:");
        String telefone = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();

        Endereco endereco = lerEndereco();

        Fornecedor fornecedor = new Fornecedor(nome, codigo,descricao, telefone, email, endereco);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
}

    //método para excluir um fornecedor por CÓDIGO (apenas)
    public void excluirFornecedor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do fornecedor que deseja excluir:");
        int codigo = sc.nextInt();
        sc.nextLine();
    
        boolean fornecedorEncontrado = false;
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor f = fornecedores.get(i);
            if (f.getCodigo() == codigo) {
                fornecedores.remove(i);
                fornecedorEncontrado = true;
                System.out.println("Fornecedor excluído com sucesso!");
                return;
            }
        }

        System.out.println("Forncedor não encontrado com código fornecido: " + codigo);
    
    }

    // método para incluir um cliente
    public void incluirCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do cliente:");
        String nome = sc.nextLine();
        System.out.println("Código:");
        int codigo = sc.nextInt();
         // Verificar se já existe um produto com o mesmo código
         for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                System.out.println("Já existe um cliente com esse código.");
                return;
        }
    }

        System.out.println("Telefone:");
        String telefone = sc.nextLine();
        System.out.println("E-mail:");
        String email = sc.nextLine();
        System.out.println("Cartão de crédito:");
        String cartaoCredito = sc.nextLine();
        
        Endereco endereco = lerEndereco();
        
        Cliente cliente = new Cliente(nome, codigo, telefone, email, cartaoCredito, endereco);
        clientes.add(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }


    //método para excluir cliente por CÓDIGO (apenas)
    public void excluirCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do cliente que deseja excluir:");
        int codigo = sc.nextInt();
        sc.nextInt();
    
        boolean clienteEncontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCodigo() == codigo) {
                clientes.remove(i);
                clienteEncontrado = true;
                System.out.println("Cliente excluído com sucesso!");
                return;
            }
        }

        System.out.println("Cliente não encontrado com o código fornecido: " + codigo);
        
    }

    //método para incluir um produto
    public void incluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do produto:");
        String nome = sc.nextLine();
        System.out.println("Código do produto:");
        int codigo = sc.nextInt();

        // Verificar se já existe um produto com o mesmo código
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                System.out.println("Já existe um produto com esse código.");
                return;
        }
    }

        sc.nextLine();
        System.out.println("Descrição:");
        String descricao = sc.nextLine();
        System.out.println("Quantidade em estoque:");
        int quantidade = sc.nextInt();
        sc.nextLine();
        System.out.println("Preço:");
        double preco = sc.nextDouble();
    
        Estoque estoque = new Estoque(quantidade, preco);
        Produto produto = new Produto(codigo, nome, descricao, new byte[0], estoque);
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }


    //método para excluir um produto por CÓDIGO (apenas)
    public void excluirProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto que deseja excluir:");
        int codigo = sc.nextInt();
        sc.nextLine();
    
        boolean produtoEncontrado = false;
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getCodigo() == codigo) {
                produtos.remove(i);
                produtoEncontrado = true;
                System.out.println("Produto excluído com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado com código fornecido: " + codigo);
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

    //método para consultar fornecedor por CÓDIGO
    public void consultarFornecedorPorCodigo() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Digite o código do fornecedor:");
        int codigo = sc.nextInt();

        for(Fornecedor f : fornecedores) {
            if (f.getCodigo() == codigo) {
                System.out.println(f.toString());
                return;
            }
        }
        System.out.println("Fornecedor não encontrado com código forncecido: " + codigo);
        
    }


    //método para consultar cliente por NOME
    public void consultarClientePorNome() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente:");
        String nome = sc.nextLine();

        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Cliente não encontrado com nome fornecido: " + nome);
    }

    //método para consultar cliente por CÓDIGO
    public void consultarClientePorCodigo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do cliente:");
        int codigo = sc.nextInt();

        for (Cliente c : clientes) {
            if (c.getCodigo() == codigo) {
                System.out.println(c.toString());
                return;
            }
        }
        System.out.println("Cliente não encontrado com nome fornecido: " + codigo);
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
                    sc.nextLine(); // limpa o scanner
    
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
                
                            Endereco novoEndereco = lerEndereco();
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
                    sc.nextLine(); 
    
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

    //método para alterar cliente
    public void alterarCliente() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente que deseja alterar:");
        String nome = sc.nextLine();
    
        
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                boolean clienteEncontrado = true;
                while (clienteEncontrado) {
                    System.out.println("O que deseja alterar?");
                    System.out.println("1. Nome");
                    System.out.println("2. Telefone");
                    System.out.println("3. Email");
                    System.out.println("4. Cartão de Crédito");
                    System.out.println("5. Endereço");
                    System.out.println("6. Sair");
    
                    int opcao = sc.nextInt();
                    sc.nextLine(); 
    
                    switch (opcao) {
                        case 1:
                            System.out.println("Novo nome:");
                            String novoNome = sc.nextLine();
                            cliente.setNome(novoNome);
                            break;
                        case 2:
                            System.out.println("Novo telefone:");
                            String novoTelefone = sc.nextLine();
                            cliente.setTelefone(novoTelefone);
                            break;
                        case 3:
                            System.out.println("Novo email:");
                            String novoEmail = sc.nextLine();
                            cliente.setEmail(novoEmail);
                            break;
                        case 4:
                            System.out.println("Novo cartão de crédito:");
                            String novoCartaoCredito = sc.nextLine();
                            cliente.setCartaoCredito(novoCartaoCredito);
                            break;
                        case 5:
                            System.out.println("Novo endereço:");

                            Endereco novoEndereco = lerEndereco();
                            cliente.setEndereco(novoEndereco);
                            break;
                        case 6:
                            System.out.println("Cliente alterado com sucesso!");
                            return;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                }
            }
        }
        System.out.println("Cliente não econtrado com nome fornecido: " + nome);
        
    }

}
