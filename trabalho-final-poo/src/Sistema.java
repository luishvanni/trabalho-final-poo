import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    
    private ArrayList<Fornecedor> fornecedores;
    private ArrayList<Produto> produtos;

    
    public Sistema() {
        fornecedores = new ArrayList<>();
        produtos = new ArrayList<>();
    }



       public void incluirFornecedor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nome do fornecedor:");
        String nome = scanner.nextLine();
        System.out.println("Descrição:");
        String descricao = scanner.nextLine();
        System.out.println("Telefone:");
        String telefone = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Endereço:");
        String endereco = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor(nome, descricao, telefone, email, null);
        fornecedores.add(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso!");
        System.out.println(fornecedor.toString());
    }

    





    
    public void incluir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incluir'");
    }

    


    public void consultar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultar'");
    }


    
    public void alterar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }


    
    public void excluir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

}
