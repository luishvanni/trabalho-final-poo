import java.util.ArrayList;

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
    public boolean alterarFornecedor(String nome, int opcao, String novoValor, Endereco novoEndereco) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getNome().equalsIgnoreCase(nome)) {
                switch (opcao) {
                    case 1:
                        fornecedor.setNome(novoValor);
                        break;
                    case 2:
                        fornecedor.setDescricao(novoValor);
                        break;
                    case 3:
                        fornecedor.setTelefone(novoValor);
                        break;
                    case 4:
                        fornecedor.setEmail(novoValor);
                        break;
                    case 5:
                        fornecedor.setEndereco(novoEndereco);
                        break;
                    default:
                        return false; // opção inválida
                }
                return true; // alteração bem-sucedida
            }
        }
        return false; // fornecedor não encontrado
    }

    //método para alterar produto
    public boolean alterarProduto(String codigo, int opcao, String novoValor, int novaQuantidade, double novoPreco) {
        for (Produto p : produtos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                switch (opcao) {
                    case 1:
                        p.setNome(novoValor);
                        break;
                    case 2:
                        p.setDescricao(novoValor);
                        break;
                    case 3:
                        p.getEstoque().setQuantidade(novaQuantidade);
                        break;
                    case 4:
                        p.getEstoque().setPreco(novoPreco);
                        break;
                    default:
                        return false; // opção inválida
                }
                return true; // alteração bem-sucedida
            }
        }
        return false; // produto não encontrado
    }

    //método para alterar cliente
    public boolean alterarCliente(String nome, int opcao, String novoValor, Endereco novoEndereco) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                switch (opcao) {
                    case 1:
                        cliente.setNome(novoValor);
                        break;
                    case 2:
                        cliente.setTelefone(novoValor);
                        break;
                    case 3:
                        cliente.setEmail(novoValor);
                        break;
                    case 4:
                        cliente.setCartaoCredito(novoValor);
                        break;
                    case 5:
                        cliente.setEndereco(novoEndereco);
                        break;
                    default:
                        return false; // opção inválida
                }
                return true; // alteração bem-sucedida
            }
        }
        return false; // cliente não encontrado
    }
}
