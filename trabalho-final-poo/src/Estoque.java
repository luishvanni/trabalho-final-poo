public class Estoque implements Cadastro{
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
    public void incluir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incluir'");
    }

    @Override
    public void consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }

    @Override
    public void alterar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }

    @Override
    public void excluir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

      
}
