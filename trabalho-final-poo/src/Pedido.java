import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer numero;
    private Date dataPedido;
    private Date dataEntrega;
    private Date dataCancelamento;
    private String situacao;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private double valorTotal;
    
    
    public Pedido(Integer numero, Date dataPedido, Date dataEntrega, String situacao) {
        this.numero = numero;
        this.dataPedido = dataPedido;
        this.setDataEntrega(dataEntrega);
        this.situacao = situacao;
        this.valorTotal = 0.0;
        this.itens = new ArrayList<>();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }	

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(ArrayList<ItemPedido> itens) {
		this.itens = itens;
	}
	@Override
    public String toString() {
		float total = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("Número do Pedido: ").append(numero)
          .append("\nData do Pedido: ").append(dataPedido)
          .append("\nData de Entrega: ").append(getDataEntrega())
          .append("\nSituação: ").append(situacao)
          .append("\nCliente: ").append(cliente.getNome())
          .append("\nItens do Pedido:\n");

        for (ItemPedido item : itens) {
            sb.append("Produto: ").append(item.getProduto().getNome())
              .append("\nQuantidade: ").append(item.getQuantidade())
              .append("\nPreço Unitário: R$ ").append(String.format("%.2f", item.getProduto().getEstoque().getPreco()))
              .append("\nPreço Total: R$ ").append(String.format("%.2f", item.getPrecoTotal()))
              .append("\n\n");
            total+=item.getPrecoTotal();
        }
        
        double ICMS = total * 0.17;
        sb.append("Valor Total do Pedido com ICMS: R$ ").append(String.format("%.2f", total+ICMS));
        return sb.toString();
    }

	public Date getDataCancelamento() {
		return dataCancelamento;
	}

	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
}
