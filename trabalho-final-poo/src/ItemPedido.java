import java.io.Serializable;

public class ItemPedido  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Produto produto;
    private int quantidade;
    private double precoTotal;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoTotal = produto.getEstoque().getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
}
