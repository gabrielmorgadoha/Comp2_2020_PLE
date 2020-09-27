import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LojaVirtualTest {

    private static final double DOUBLE_DELTA = 0.00001;

    @Test
    public void testarQuantidadeEmEstoque() {
        Livro livro1 = new Livro(500, 3, 20.00f, 2008, 300, "Ovo Cozido", "Paulo");
        assertEquals("O estoque deve mostrar a quantidade do produto especificado.", 3, LojaVirtual.getTamanhoEstoque(livro1));
        LojaVirtual.incluirProdutoNoEstoque(livro1, 2);
        assertEquals("O estoque precisa contabilizar as novas peças.", 5, LojaVirtual.getTamanhoEstoque(livro1));

        Livro livro2 = new Livro(300, 1, 27.43f, 1997, 138, "Silva", "E Silva");
        assertEquals("O estoque precisa contabilizar todos os produtos.", 6, LojaVirtual.getTamanhoEstoque());

        Roupa roupa1 = new Roupa(700, 2, 33.99f, 'm', "azul");
        assertEquals("O estoque precisa contabilizar o novo tipo de produto inserido.", 8, LojaVirtual.getTamanhoEstoque());
        Produto.listaDeTodosOsProdutos.clear();
    }

    @Test
    public void testarVendaDeProdutos() {
        Livro livro1 = new Livro(660, 0, 33.54f, 2001, 432, "Safira de Sapato", "Hypacea Jamisa");
        assertEquals("A loja não pode vender um produto fora de estoque.", "Esta venda não pode ser concluída.", LojaVirtual.efetuarVenda(livro1, 1));

        Livro livro2 = new Livro(200, 5, 22.97f, 2018, 64, "Felipe Neto - A Vida por trás das câmeras", "Felipe Neto");
        LojaVirtual.efetuarVenda(livro2, 2);
        assertEquals("A loja precisa subtrair do estoque o item vendido.", 3, LojaVirtual.getTamanhoEstoque(livro2));
        assertEquals("A loja precisa ter receber um valor igual a venda.", 45.94, LojaVirtual.getTotalValorDeVendas(), DOUBLE_DELTA);

        Roupa roupa1 = new Roupa(550, 7, 44.99f, 'p', "verde");
        LojaVirtual.efetuarVenda(roupa1, 1);
        assertEquals("O estoque precisa subtrair as peças de todas as categorias.", 9, LojaVirtual.getTamanhoEstoque());
        assertEquals("A loja precisa contabilizar o valor total de vendas.", 90.93, LojaVirtual.getTotalValorDeVendas(), DOUBLE_DELTA);
        Produto.listaDeTodosOsProdutos.clear();
    }
}
