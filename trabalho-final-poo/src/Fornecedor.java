public class Fornecedor{
    
    private String nome;
    private int codigo;
    private String descricao;
    private String telefone;
    private String email;
    private Endereco endereco;


    public Fornecedor(String nome, int codigo ,String descricao, String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
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


    @Override
    public String toString() {
        return 
        "----------------------------------------" +
        "\n" + "Nome: " + nome + 
        "\n" + "Código: " + codigo +
        "\n" + "Descrição: " + descricao + 
        "," + " Telefone: " + telefone + 
        "," + " Email: " + email + 
        "\n" + "Endereco: " + getEndereco().toString();
    }


}
   
