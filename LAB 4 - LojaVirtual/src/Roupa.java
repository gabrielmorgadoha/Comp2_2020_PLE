public class Roupa extends Produto{
    final char tamanho;
    String cor;

    public Roupa(int pesoEmGramas, int quantidadeEmEstoque, float preçoEmReais, char tamanho, String cor){
        super(pesoEmGramas, quantidadeEmEstoque, preçoEmReais);
        this.categoria = "Vestuário";
        this.tamanho = tamanho;
        this.cor = cor;
        setElementoListaDeTodosProdutos(this);
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "Tamanho: %c\nCor: %s\n\n",
                this.tamanho, this.cor);
    }
}
