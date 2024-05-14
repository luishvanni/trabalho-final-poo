public class Estoque{
    private Integer quantidade;
    private Double preco;

    
    public Estoque(Integer quantidade, Double preco) {
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public Double getPreco() {
        return preco;
    }


    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        String precoFormatado = String.format("R$%,.2f", preco); //deixa o preço no formato BR
        return "Quantidade: " + quantidade + ", Preço = " + precoFormatado;
}

    

      
}
