import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    
    private ArrayList<Fornecedor> fornecedores;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;
    private List<Pedido> pedidos;
    private List<ItemPedido> carrinho;

    public Sistema() {
        fornecedores = new ArrayList<>();
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
        pedidos = new ArrayList<>();
        carrinho = new ArrayList<>();

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
                        return false; 
                }
                return true; 
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
                        return false; 
                }
                return true;  
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
                        return false; 
                }
                return true; 
            }
        }
        return false; // cliente não encontrado
    } 

     // Adiciona um produto ao sistema
     public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    // Adiciona um pedido ao sistema
    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Pesquisa um produto por código ou palavra-chave
    public List<Produto> pesquisarProduto(String termo) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCodigo().contains(termo) || produto.getNome().contains(termo) || produto.getDescricao().contains(termo)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    // Consulta um pedido por número
    public Pedido consultarPedidoPorNumero(int numero) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numero) {
                return pedido;
            }
        }
        return null;
    }

    // Consulta pedidos por intervalo de datas
    public List<Pedido> consultarPedidosPorData(Date inicio, Date fim) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (!pedido.getDataPedido().before(inicio) && !pedido.getDataPedido().after(fim)) {
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public void realizarPedido() {
        if (carrinho.isEmpty()) {
            System.out.println("O carrinho está vazio.");
            return;
        }
    
        int numeroPedido = pedidos.size() + 1;  // Exemplo para gerar número sequencial
        Date dataPedido = new Date();
        Date dataEntrega = new Date(); // Data prevista de entrega, pode ser ajustada conforme necessidade
        String situacao = "NOVO";
    
        // Calcula o valor total do pedido com ICMS
        double valorTotal = 0;
        for (ItemPedido item : carrinho) {
            valorTotal += item.getPreco();
        }
        valorTotal *= 1.17;  // Adiciona 17% de ICMS
    
        // Cria o pedido com valor total calculado
        Pedido pedido = new Pedido(numeroPedido, dataPedido, dataEntrega, situacao, carrinho, valorTotal);
    
        // Adiciona o pedido à lista
        adicionarPedido(pedido);
    
        // Limpa o carrinho após a realização do pedido
        //carrinho.clear();
        System.out.println("Pedido realizado com sucesso! Número do pedido: " + numeroPedido + ", Valor total: " + String.format("%.2f", valorTotal));
    }

    // Adiciona um produto ao carrinho
    public void adicionarProdutoAoCarrinho(Produto produto, int quantidade) {
        if (produto.getEstoque().getQuantidade() < quantidade) {
            System.out.println("Quantidade solicitada é maior que o estoque disponível. Quantidade máxima disponível: " + produto.getEstoque().getQuantidade());
            return;
        }

        double preco = produto.getEstoque().getPreco() * quantidade;
        ItemPedido itemPedido = new ItemPedido(produto, null, quantidade, preco);
        carrinho.add(itemPedido);
        produto.getEstoque().setQuantidade(produto.getEstoque().getQuantidade() - quantidade);
        System.out.println("Produto adicionado ao carrinho.");
    }

    // Mostra a lista de produtos disponíveis
    public void mostrarProdutos(List<Produto> produtos) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
            System.out.println(i + 1 + ". Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Descrição: " + produto.getDescricao() + ", Preço: " + produto.getEstoque().getPreco() + ", Estoque: " + produto.getEstoque().getQuantidade());
        }
    }

    public void visualizarPedido(int numero) {
        Pedido pedido = this.pedidos.stream()
            .filter(p -> p.getNumero() == numero)
            .findFirst()
            .orElse(null);
    
        if (pedido != null) {
            System.out.println(pedido);
            System.out.println(pedido.exibirItens());  // Adicionado para exibir os itens do pedido
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }
}
