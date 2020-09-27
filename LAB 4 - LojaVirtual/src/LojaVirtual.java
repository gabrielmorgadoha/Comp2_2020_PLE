public class LojaVirtual {

    private static double valorTotalDeVendas = 0;

    public static int getTamanhoEstoque(){
        return Produto.getQuantidadeTodosProdutos();
    }

    public static int getTamanhoEstoque(Produto produto){
        return produto.quantidadeEmEstoque;
    }

    public static void incluirProdutoNoEstoque(Produto produto, int quantidade){
        produto.quantidadeEmEstoque += quantidade;
    }

    private static boolean receberPagamento(float valor){
        valorTotalDeVendas += valor;
        return true;
    }

    public static String efetuarVenda(Produto produto, int quantidade){
        if (produto.quantidadeEmEstoque > 0 && produto.quantidadeEmEstoque >= quantidade){
            produto.quantidadeEmEstoque -= quantidade;
            for(int i = 0; i < quantidade; i++){
                receberPagamento(produto.preçoEmReais);
            }
            return produto.toString();
        }
        else{
            return "Esta venda não pode ser concluída.";
        }
    }

    public static double getTotalValorDeVendas(){
        return valorTotalDeVendas;
    }
}
