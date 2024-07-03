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

        //populaProdutos(produtos);
       //populaClientes(clientes);
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

    
    public static void populaClientes(ArrayList<Cliente> clientes) {
        clientes.add(new Cliente("Ana Silva", "C1", "1234-5678", "ana.silva@example.com", "1111-2222-3333-0001", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Carlos Pereira", "C2", "1234-5679", "carlos.pereira@example.com", "1111-2222-3333-0002", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Fernanda Oliveira", "C3", "1234-5680", "fernanda.oliveira@example.com", "1111-2222-3333-0003", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Lucas Souza", "C4", "1234-5681", "lucas.souza@example.com", "1111-2222-3333-0004", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Mariana Costa", "C5", "1234-5682", "mariana.costa@example.com", "1111-2222-3333-0005", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Roberto Lima", "C6", "1234-5683", "roberto.lima@example.com", "1111-2222-3333-0006", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Juliana Ferreira", "C7", "1234-5684", "juliana.ferreira@example.com", "1111-2222-3333-0007", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Bruno Mendes", "C8", "1234-5685", "bruno.mendes@example.com", "1111-2222-3333-0008", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Patrícia Ramos", "C9", "1234-5686", "patricia.ramos@example.com", "1111-2222-3333-0009", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("João Batista", "C10", "1234-5687", "joao.batista@example.com", "1111-2222-3333-0010", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Carolina Rocha", "C11", "1234-5688", "carolina.rocha@example.com", "1111-2222-3333-0011", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Gabriel Martins", "C12", "1234-5689", "gabriel.martins@example.com", "1111-2222-3333-0012", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Isabela Gomes", "C13", "1234-5690", "isabela.gomes@example.com", "1111-2222-3333-0013", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Matheus Alves", "C14", "1234-5691", "matheus.alves@example.com", "1111-2222-3333-0014", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Beatriz Moraes", "C15", "1234-5692", "beatriz.moraes@example.com", "1111-2222-3333-0015", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Thiago Ribeiro", "C16", "1234-5693", "thiago.ribeiro@example.com", "1111-2222-3333-0016", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Larissa Carvalho", "C17", "1234-5694", "larissa.carvalho@example.com", "1111-2222-3333-0017", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Felipe Nunes", "C18", "1234-5695", "felipe.nunes@example.com", "1111-2222-3333-0018", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Amanda Teixeira", "C19", "1234-5696", "amanda.teixeira@example.com", "1111-2222-3333-0019", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
        clientes.add(new Cliente("Vinicius Barbosa", "C20", "1234-5697", "vinicius.barbosa@example.com", "1111-2222-3333-0020", new Endereco("Rua das Flores", "1", "casa", "Jardim", "01000-000", "São Paulo", "SP")));
    }

    public static void populaProdutos(ArrayList<Produto> produtos) {
        produtos.add(new Produto("P1", "Smartphone", "Smartphone de última geração", new byte[]{1, 2, 3}, new Estoque(50, 1999.99)));
        produtos.add(new Produto("P2", "Notebook", "Notebook potente para trabalho e jogos", new byte[]{4, 5, 6}, new Estoque(30, 3499.99)));
        produtos.add(new Produto("P3", "Tablet", "Tablet leve e versátil", new byte[]{7, 8, 9}, new Estoque(40, 1299.99)));
        produtos.add(new Produto("P4", "Smartwatch", "Relógio inteligente com várias funções", new byte[]{10, 11, 12}, new Estoque(60, 799.99)));
        produtos.add(new Produto("P5", "Fone de Ouvido", "Fone de ouvido com cancelamento de ruído", new byte[]{13, 14, 15}, new Estoque(70, 499.99)));
        produtos.add(new Produto("P6", "Câmera Digital", "Câmera digital com alta resolução", new byte[]{16, 17, 18}, new Estoque(20, 2999.99)));
        produtos.add(new Produto("P7", "Monitor", "Monitor 4K de alta definição", new byte[]{19, 20, 21}, new Estoque(35, 1599.99)));
        produtos.add(new Produto("P8", "Teclado Mecânico", "Teclado mecânico para gamers", new byte[]{22, 23, 24}, new Estoque(50, 399.99)));
        produtos.add(new Produto("P9", "Mouse Gamer", "Mouse com alta precisão e RGB", new byte[]{25, 26, 27}, new Estoque(80, 299.99)));
        produtos.add(new Produto("P10", "Impressora", "Impressora multifuncional", new byte[]{28, 29, 30}, new Estoque(25, 899.99)));
        produtos.add(new Produto("P11", "Roteador", "Roteador Wi-Fi de alta velocidade", new byte[]{31, 32, 33}, new Estoque(40, 599.99)));
        produtos.add(new Produto("P12", "HD Externo", "HD externo de 1TB", new byte[]{34, 35, 36}, new Estoque(60, 349.99)));
        produtos.add(new Produto("P13", "SSD", "SSD de 512GB", new byte[]{37, 38, 39}, new Estoque(70, 499.99)));
        produtos.add(new Produto("P14", "Memória RAM", "Memória RAM de 16GB", new byte[]{40, 41, 42}, new Estoque(50, 699.99)));
        produtos.add(new Produto("P15", "Placa de Vídeo", "Placa de vídeo para gamers", new byte[]{43, 44, 45}, new Estoque(15, 3499.99)));
        produtos.add(new Produto("P16", "Fonte de Alimentação", "Fonte de alimentação de 750W", new byte[]{46, 47, 48}, new Estoque(30, 499.99)));
        produtos.add(new Produto("P17", "Gabinete", "Gabinete ATX com iluminação RGB", new byte[]{49, 50, 51}, new Estoque(25, 399.99)));
        produtos.add(new Produto("P18", "Ventoinha", "Ventoinha para gabinete", new byte[]{52, 53, 54}, new Estoque(80, 69.99)));
        produtos.add(new Produto("P19", "Microfone", "Microfone condensador para gravação", new byte[]{55, 56, 57}, new Estoque(40, 299.99)));
        produtos.add(new Produto("P20", "Caixa de Som", "Caixa de som Bluetooth", new byte[]{58, 59, 60}, new Estoque(50, 249.99)));
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
