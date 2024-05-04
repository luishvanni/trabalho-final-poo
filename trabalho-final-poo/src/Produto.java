public class Produto{
    
    private String nome;
    private String descricao;
    private byte[] foto;
    private Estoque estoque;

    public Produto(String nome, String descricao, byte[] foto, Estoque estoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
 

}