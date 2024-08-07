import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Sistema {
    
    private ArrayList<Fornecedor> fornecedores;
    private ArrayList<Produto> produtos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Pedido> pedidos;
    public Sistema() {
        //fornecedores = new ArrayList<>();
        fornecedores = carregarLista("fornecedores.ser");
        setProdutos(new ArrayList<>());
        //clientes = new ArrayList<>();
        //pedidos = new ArrayList<>();
        produtos = carregarLista("produtos.ser");
        clientes = carregarLista("clientes.ser");
        pedidos = carregarLista("pedidos.ser");
        if (fornecedores == null) fornecedores = new ArrayList<>();
        if (clientes == null) clientes = new ArrayList<>();
        if (pedidos == null) pedidos = new ArrayList<>();

        
    }
    
    @SuppressWarnings({ "unchecked", "unused", "resource" })
    private <T> ArrayList<T> carregarLista(String filename) {
    	File file = new File(filename);
        if (!file.exists()) {
            return new ArrayList<>();
        }
    	ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream(filename));
			return (ArrayList<T>) ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
            
    }

    private <T> void salvarLista(ArrayList<T> lista, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        salvarLista(fornecedores, "fornecedores.ser");

        return true;
        
}

     // Método para excluir um fornecedor por código
     public boolean excluirFornecedor(String codigo) {
        for (int i = 0; i < fornecedores.size(); i++) {
            Fornecedor f = fornecedores.get(i);
            if (f.getCodigo().equalsIgnoreCase(codigo)) {
                fornecedores.remove(i);
                salvarLista(fornecedores, "fornecedores.ser");
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
        salvarLista(clientes, "clientes.ser");

        return true;
        
    }


    //método para excluir cliente por CÓDIGO (apenas)
    // Método para excluir um cliente por código
    public boolean excluirCliente(String codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            if (cliente.getCodigo().equalsIgnoreCase(codigo)) {
                clientes.remove(i);
                salvarLista(clientes, "clientes.ser");

                return true; // Cliente encontrado e removido
            }
        }
        return false; // Cliente não encontrado
    }

    //método para incluir um produto
    public boolean incluirProduto(String codigo, String nome, String descricao, byte[] foto, double preco, int quantidade) {
        for (Produto produto : getProdutos()) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Já existe um produto com esse código.");
                return false;
            }
        }
    
        
        Estoque estoque = new Estoque(quantidade, preco);
        Produto produto = new Produto(codigo, nome, descricao, foto, estoque);
        getProdutos().add(produto);
        salvarLista(produtos, "produtos.ser");

        return true;
    }

    public boolean linkProdutoFornecedor(String codigoProduto, String codigoFornecedor) {
        Produto produto = null;
        Fornecedor fornecedor = null;
        for(Produto p : getProdutos()) {
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
        salvarLista(produtos, "produtos.ser");
        salvarLista(fornecedores, "fornecedores.ser");

        return true;
    }

    public int realizarPedido(Cliente cliente, Produto produto, int quantidade, Scanner sc) {
        if (cliente == null || produto == null) {
            return -1; // Cliente ou Produto não encontrado
        }

        int estoqueDisponivel = produto.getEstoque().getQuantidade();

        // Verificar se há quantidade suficiente no estoque
        if (estoqueDisponivel < quantidade) {
            System.out.println("Quantidade insuficiente no estoque. Apenas " + estoqueDisponivel + " disponível(s).");

            if (estoqueDisponivel > 0) {
                System.out.println("Deseja comprar a quantidade disponível? (s/n)");
                String resposta = sc.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    quantidade = estoqueDisponivel;
                } else {
                    return -1; // Usuário não deseja comprar a quantidade disponível
                }
            } else {
                return -1; // Quantidade insuficiente no estoque e nada disponível
            }
        }

        // Criar um novo pedido
        int numeroPedido = pedidos.size() + 1;
        Date dataPedido = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataPedido);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date dataEntrega = calendar.getTime();
        String situacao = "Pendente";
        Pedido pedido = new Pedido(numeroPedido, new java.sql.Date(dataPedido.getTime()), new java.sql.Date(dataEntrega.getTime()), situacao);

        // Adicionar cliente ao pedido
        pedido.setCliente(cliente);

        // Criar um item de pedido
        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.getItens().add(item);

        // Atualizar o valor total do pedido
        double valorTotal = pedido.getValorTotal() + item.getPrecoTotal();
        pedido.setValorTotal(valorTotal);

        // Atualizar o estoque do produto
        produto.getEstoque().setQuantidade(estoqueDisponivel - quantidade);

        // Adicionar o pedido à lista de pedidos
        pedidos.add(pedido);
        return pedido.getNumero();
    }
    public int adicionarAoPedido(int pedidoN, Produto produto, int quantidade, Scanner sc) {
        
        Pedido pedido = null;

        // Supondo que você tenha uma lista de pedidos no sistema
        for (Pedido p : pedidos) {
            if (p.getNumero() == pedidoN) {
                pedido = p;
                break;
            }
        }

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return -1;
        }

        
        int estoqueDisponivel = produto.getEstoque().getQuantidade();

        // Verificar se há quantidade suficiente no estoque
        if (estoqueDisponivel < quantidade) {
            System.out.println("Quantidade insuficiente no estoque. Apenas " + estoqueDisponivel + " disponível(s).");

            if (estoqueDisponivel > 0) {
                System.out.println("Deseja comprar a quantidade disponível? (s/n)");
                String resposta = sc.nextLine();
                if (resposta.equalsIgnoreCase("s")) {
                    quantidade = estoqueDisponivel;
                } else {
                    return -1; // Usuário não deseja comprar a quantidade disponível
                }
            } else {
                return -1; // Quantidade insuficiente no estoque e nada disponível
            }
        }

        // Criar um item de pedido
        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.getItens().add(item);

        // Atualizar o valor total do pedido
        double valorTotal = pedido.getValorTotal() + item.getPrecoTotal();
        pedido.setValorTotal(valorTotal);

        // Atualizar o estoque do produto
        produto.getEstoque().setQuantidade(estoqueDisponivel - quantidade);

        return pedido.getNumero();
    }

    // Método para consultar pedidos de um cliente
    public ArrayList<Pedido> consultarPedidosCliente(Cliente cliente) {
        ArrayList<Pedido> pedidosCliente = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCodigo().equalsIgnoreCase(cliente.getCodigo())) {
                pedidosCliente.add(pedido);
            }
        }
        return pedidosCliente;
    }
    public void imprimirPedidosPorCliente(String codigoCliente) {
        boolean encontrouPedido = false;
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getCodigo().equals(codigoCliente)) {
                System.out.println(pedido);
                encontrouPedido = true;
            }
        }
        if (!encontrouPedido) {
            System.out.println("Nenhum pedido encontrado para o cliente com código: " + codigoCliente);
        }
    }
    // Método para excluir um produto por código(apenas)
    public boolean excluirProduto(String codigo) {
        for (int i = 0; i < getProdutos().size(); i++) {
            Produto produto = getProdutos().get(i);
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                getProdutos().remove(i);
                return true; // Produto encontrado e removido
            }
        }
        return false; // Produto não encontrado
    }
    
    public Produto consultarProduto(String termo) {
    	Produto p = consultarProdutoPorCodigo(termo);
    	if(p == null) {
    		p = consultarProdutoPorNome(termo);
    	}
    	return p;
    }
    //método para consultar um produto por NOME
    public Produto consultarProdutoPorNome(String nome) {
        for (Produto p : getProdutos()) {
            if (p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                return p; // Produto encontrado
            }
        }
        return null; // Produto não encontrado
    }
    
    //método para consultar produto por CÓDIGO
    public Produto consultarProdutoPorCodigo(String codigo) {
        for(Produto p : getProdutos()) {
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
                System.out.println(c.getNome());
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
        for (Produto p : getProdutos()) {
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
        return false; 
    }
    public Pedido consultarPedidoPorNumero(int numeroPedido) {
        for (Pedido pedido : pedidos) {
            if (pedido.getNumero() == numeroPedido) {
                return pedido;
            }
        }
        return null;
    }
    
    public ArrayList<Pedido> consultarPedidosPorData(Date data) {
        ArrayList<Pedido> pedidosNaData = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            
            if (pedido.getDataPedido().toString().equals(data.toString())) {
                pedidosNaData.add(pedido);
            }
        }
        return pedidosNaData;
    }
    public void salvaPedidos() {
    	salvarLista(pedidos, "pedidos.ser");
    }
    public boolean confirmarEntregaPedido(int numero) {
        Pedido pedido = consultarPedidoPorNumero(numero);
        if (pedido != null && !pedido.getSituacao().equalsIgnoreCase("Entregue")) {
            pedido.setSituacao("ENTREGUE");
            pedido.setDataEntrega(new java.sql.Date(System.currentTimeMillis()));
            salvarLista(pedidos, "pedidos.ser");
            return true;
        }
        return false;
    }

    public boolean cancelarPedido(int numero) {
        Pedido pedido = consultarPedidoPorNumero(numero);
        if (pedido != null && !pedido.getSituacao().equalsIgnoreCase("Entregue")) {
            pedido.setSituacao("CANCELADO");
            pedido.setDataCancelamento(new java.sql.Date(System.currentTimeMillis()));
            salvarLista(pedidos, "pedidos.ser");

            return true;
        }
        return false;
    }


	public	 ArrayList<Produto> getProdutos() {
		return produtos;
	}


	private void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
}
