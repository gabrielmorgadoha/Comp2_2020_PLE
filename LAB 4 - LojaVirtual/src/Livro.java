public class Livro extends Produto{
    final int anoDePublicacao;
    final int numeroDePaginas;
    final String titulo;
    final String autor;

    public Livro(int pesoEmGramas, int quantidadeEmEstoque, float preçoEmReais, int anoDePublicacao, int numeroDePaginas, String titulo, String autor){
        super(pesoEmGramas, quantidadeEmEstoque, preçoEmReais);
        this.categoria = "Publicações";
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDePaginas = numeroDePaginas;
        this.titulo = titulo;
        this.autor = autor;
        setElementoListaDeTodosProdutos(this);
    }

    @Override
    public String toString(){
        return String.format(super.toString() + "Título: %s\nAutor: %s\nAno de publicação: %d\nNúmero de páginas: %d\n\n",
                this.titulo, this.autor, this. anoDePublicacao, this.numeroDePaginas);
    }
}
