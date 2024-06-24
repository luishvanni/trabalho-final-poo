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

    

   

    // Método para incluir um fornecedor
    public boolean incluirFornecedor(String nome, String codigo, String descricao, String telefone, String email, Endereco endereco) {
       
        // Verificar se já existe um fornecedor com o mesmo código
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Já existe um fornecedor com esse código.");
                return false;
        }
    }
        Fornecedor fornecedor = new Fornecedor(nome, codigo,descricao, telefone, email, endereco);
        fornecedores.add(fornecedor);
            return true;
        
}

     // Método para excluir um fornecedor por código
     public boolean excluirFornecedor(String codigo) {
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor f = fornecedores.get(i);
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                fornecedores.remove(i);
                return true; // Fornecedor encontrado e removido
            }
        }
        return false; // Fornecedor não encontrado
    }

    // método para incluir um cliente
    public boolean incluirCliente(String nome, String codigo,String telefone, String email, String cartaoCredito, Endereco endereco) {
        
         // Verificar se já existe um produto com o mesmo código
         for (Cliente cliente : clientes) {
            if (cliente.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Já existe um cliente com esse código.");
                return false;
        }
    }
        
        Cliente cliente = new Cliente(nome, codigo, telefone, email, cartaoCredito, endereco);
        clientes.add(cliente);
        return true;
        
    }


    //método para excluir cliente por CÓDIGO (apenas)
    // Método para excluir um cliente por código
    public boolean excluirCliente(String codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCodigo().equalsIgnoreCase(codigo)) {
                clientes.remove(i);
                return true; // Cliente encontrado e removido
            }
        }
        return false; // Cliente não encontrado
    }

    //método para incluir um produto
    public boolean incluirProduto(String codigo, String nome, String descricao, byte[] foto, double preco, int quantidade) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Já existe um produto com esse código.");
                return false;
            }
        }
    
        
        Estoque estoque = new Estoque(quantidade, preco);
        Produto produto = new Produto(codigo, nome, descricao, foto, estoque);
        produtos.add(produto);
        return true;
    }

    public boolean linkProdutoFornecedor(String codigoProduto, String codigoFornecedor) {
        Produto produto = null;
        Fornecedor fornecedor = null;
        for(Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigoProduto)) {
                produto = p;  
            }
        }
        for(Fornecedor f : fornecedores) {
            if(f.getCodigo().equalsIgnoreCase(codigoFornecedor)) {
                fornecedor = f;
            }
        }
        if (produto == null || fornecedor == null) {
            return false;
        }
        fornecedor.adicionarProduto(produto);
        return true;
    }



    // Método para excluir um produto por código(apenas)
    public boolean excluirProduto(String codigo) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                produtos.remove(i);
                return true; // Produto encontrado e removido
            }
        }
        return false; // Produto não encontrado
    }
    
        
    //método para consultar um produto por NOME
    public Produto consultarProdutoPorNome(String nome) {
        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p; // Produto encontrado
            }
        }
        return null; // Produto não encontrado
    }
    
    //método para consultar produto por CÓDIGO
    public Produto consultarProdutoPorCodigo(String codigo) {
        for(Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(p.toString());
                return p;
            }
        }
        return null;
        
    }


    //método para consultar fornecedor por NOME
    public Fornecedor consultarFornecedorPorNome(String nome) {
        for (Fornecedor f : fornecedores) {
            if (f.getNome().equalsIgnoreCase(nome)) {
                System.out.println(f.toString());
                return f;
            }
        }
        return null;
    }

    //método para consultar fornecedor por CÓDIGO
    public Fornecedor consultarFornecedorPorCodigo(String codigo) {
        for(Fornecedor f : fornecedores) {
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(f.toString());
                return f;
            }
        }
        return null;
        
    }


    //método para consultar cliente por NOME
    public Cliente consultarClientePorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println(c.toString());
                return c;
            }
        }
        return null;
    }

    //método para consultar cliente por CÓDIGO
    public Cliente consultarClientePorCodigo(String codigo) {
        for (Cliente c : clientes) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println(c.toString());
                return c;
            }
        }
        return null;
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
        String codigo = sc.nextLine();
    
        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
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

    private static String lerString(String mensagem) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensagem);
        return sc.nextLine();
    }

}
