import java.util.Arrays;

public class Produto{


    private int codigo;
    private String nome;
    private String descricao;
    private byte[] foto;
    private Estoque estoque;

   

    public Produto(int codigo,String nome, String descricao, byte[] foto, Estoque estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.estoque = estoque;
    }

    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
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


    @Override
    public String toString() {
        return "nome=" + nome + ", descricao=" + descricao + ", foto=" + Arrays.toString(foto) + ", estoque=" + getEstoque().toString();
    }



}