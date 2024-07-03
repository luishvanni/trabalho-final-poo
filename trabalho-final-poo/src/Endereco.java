import java.io.Serializable;

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;


    public Endereco(String rua, String numero, String complemento, String bairro, String cep, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }


    public String getRua() {
        return rua;
    }


    public void setRua(String rua) {
        this.rua = rua;
    }


    public String getNumero() {
        return numero;
    }


    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getComplemento() {
        return complemento;
    }


    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }


    public String getBairro() {
        return bairro;
    }


    public void setBairro(String bairro) {
        this.bairro = bairro;
    }


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return  
               "\n" + "Rua: " + rua + 
               "\n" + "Número: " + numero + 
               "\n" + "Complemento: " + complemento + 
               "\n" + "Bairro: " + bairro + 
               "\n" + "CEP: " + cep + 
               "\n" + "Cidade: " + cidade + 
               "\n" + "Estado: " + estado;
    }

    

    

    
}