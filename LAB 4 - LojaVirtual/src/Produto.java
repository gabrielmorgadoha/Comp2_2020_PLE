import java.util.ArrayList;

public class Produto {

    private static long nextSeqNum = 1;
    protected static ArrayList<Produto> listaDeTodosOsProdutos = new ArrayList<>();

    protected final long id;
    protected int pesoEmGramas;
    protected int quantidadeEmEstoque;
    protected float preçoEmReais;
    protected String categoria;

    public Produto(int pesoEmGramas, int quantidadeEmEstoque, float preçoEmReais){
        this.id = nextSeqNum++;
        this.pesoEmGramas = pesoEmGramas;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preçoEmReais = preçoEmReais;
    }

    public static int getQuantidadeTodosProdutos(){
        int quantidadeTotal = 0;
        for (Produto produto : listaDeTodosOsProdutos){
            quantidadeTotal += produto.quantidadeEmEstoque;
        }
        return quantidadeTotal;
    }

    public void setElementoListaDeTodosProdutos(Produto produto){
        listaDeTodosOsProdutos.add(produto);
    }

    @Override
    public String toString(){
        return String.format("Recibo - Produto: %d\nPreço: %.2f\nPeso: %d gramas\nCategoria: %s\n",
                this.id, this.preçoEmReais, this.pesoEmGramas, this.categoria);
    }
}

