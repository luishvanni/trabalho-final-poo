import java.util.ArrayList;
import java.util.List;

public class Fornecedor{
    
    private String nome;
    private String codigo;
    private String descricao;
    private String telefone;
    private String email;
    private Endereco endereco;
    private List<Produto> produtos;


    public Fornecedor(String nome, String codigo ,String descricao, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
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


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
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


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    private String produtosToString() {
        String f = "";
        if (produtos.isEmpty()) {
            f += "Nenhum produto registrado no momento.";
        }
        for(Produto p : produtos) {
            f += p.toString();
        }
        return f;
    }
    
    @Override
    public String toString() {
        return 
            "----------------------------------------\n" +
            "Nome: " + nome + "\n" +
            "Código: " + codigo + "\n" +
            "Descrição: " + descricao + "\n" +
            "Telefone: " + telefone + "\n" +
            "Email: " + email + "\n" +
            "Endereço: " + endereco.toString() + "\n" +
            "Produtos: \n" + produtosToString();
            
        
}


}
   
