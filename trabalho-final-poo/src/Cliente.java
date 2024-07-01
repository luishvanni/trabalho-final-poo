import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String codigo;
    private String telefone;
    private String email;
    private String cartaoCredito;
    private Endereco endereco;
    private List<Pedido> pedidos;


    public Cliente(String nome,String codigo, String telefone, String email, String cartaoCredito, Endereco endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.telefone = telefone;
        this.email = email;
        this.cartaoCredito = cartaoCredito;
        this.endereco = endereco;
        this.pedidos = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getCartaoCredito() {
        return cartaoCredito;
    }


    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }


    @Override
    public String toString() {
        return 
        "----------------------------------------" +
        "\n" + "Nome: " + nome + 
        "\n" + "Código: " + codigo +
        "\n" + "Telefone:" + telefone + ", Email:" + email + ", cartaoCredito = "+ cartaoCredito + 
        "\n" + "Endereco: " + getEndereco().toString() + (!pedidos.isEmpty() ? "\n" + pedidos.toString(): "\n");
    }

}
