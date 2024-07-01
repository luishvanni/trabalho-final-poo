import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;


public class Pedido {
    
    private int numero;
    private Date dataPedido;
    private Date dataEntrega;
    private String situacao;
    private List<ItemPedido> itens;
    private double valorTotal;


    public Pedido(int numero, Date dataPedido, Date dataEntrega, String situacao, List<ItemPedido> itens, double valorTotal) {
        this.numero = numero;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.situacao = situacao;
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
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

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    

    @Override
    public String toString() {
        Double precoTotal = 0.0;
        for (ItemPedido itemPedido : itens) {
            precoTotal += itemPedido.getPreco();
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        StringBuilder retorno = new StringBuilder("\nPedido:\n\n" +
            "Número - " + numero + "\n" +
            "Valor - " + String.format("%.2f", precoTotal * 1.17) + "\n" +
            "Data da confirmação: - " + formatter.format(dataPedido) + "\n" +
            "Data prevista (entrega): - " + formatter.format(dataEntrega) + "\n" +
            "Situação - " + situacao);

        return retorno.toString();
    }

    public String exibirItens() {
        StringBuilder retorno = new StringBuilder("Itens do pedido:\n");
    
        for (ItemPedido item : itens) {
            if (item.getProduto() == null) {
                retorno.append("Produto inválido\n");
                continue;
            }
    
            Produto produto = item.getProduto();
            if (produto.getFoto() == null) produto.setFoto(new byte[0]);  // Definir uma foto padrão vazia
            if (produto.getDescricao() == null) produto.setDescricao("Descrição não disponível");  // Descrição padrão se estiver faltando
    
            retorno.append("\nNome: '" + produto.getNome() + "'; Foto - " + new String(produto.getFoto()) + "; Descrição: " + produto.getDescricao() +
                ";\nQuantidade: " + item.getQuantidade() + "; Valor Total: - " + item.getPreco() + "; Valor Unitário - " + produto.getEstoque().getPreco() + ";");
        }
    
        retorno.append("\n");
    
        return retorno.toString();
    }
    

    
     
}
