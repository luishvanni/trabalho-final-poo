public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.incluirFornecedor();
        sistema.excluirFornecedor();
       
        sistema.incluirProduto();
        sistema.excluirProduto();

        
        sistema.consultarProdutoPorNome();
        sistema.consultarProdutoPorCodigo();

        sistema.consultarFornecedorPorNome();

        sistema.alterarFornecedor();
        sistema.alterarProduto();
        



    }
}
