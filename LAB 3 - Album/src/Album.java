import java.util.ArrayList;

public class Album {

    public static final float PREENCHIMENTO_MINIMO_PARA_PERMITIR_AUTO_COMPLETAR = 0.9f;  // 90%

    private final int totalFigurinhas;
    private final int quantFigurinhasPorPacotinho;
    private int totalPacotinhosRecebidos = 0;
    ArrayList<Integer> quantidadeFigurinhasRepetidas = new ArrayList<>();
    ArrayList<Figurinha> figurinhasObtidas = new ArrayList<>();

    public Album(int totalFigurinhas, int quantFigurinhasPorPacotinho) {
        this.totalFigurinhas = totalFigurinhas;
        this.quantFigurinhasPorPacotinho = quantFigurinhasPorPacotinho;
        for(int aux = 0; aux < totalFigurinhas; aux++){
            figurinhasObtidas.add(null);
            quantidadeFigurinhasRepetidas.add(0);
        }
    }

    public void receberNovoPacotinho(Figurinha[] pacotinho) {
         for (Figurinha figurinha : pacotinho) {
            int posicaoReal = figurinha.getPosicao() - 1;
            if (figurinhasObtidas.get(posicaoReal) == null){
                figurinhasObtidas.set(posicaoReal, figurinha);
            }
            else{
                quantidadeFigurinhasRepetidas.set(posicaoReal, (quantidadeFigurinhasRepetidas.get(posicaoReal) + 1));
            }
        }
        totalPacotinhosRecebidos++;
    }

    public int getTotalPacotinhosRecebidos() {
        return totalPacotinhosRecebidos;
    }

    public void encomendarFigurinhasRestantes() {
        if (getQuantFigurinhasColadas() >= 180){
            for (int i = 0; i < totalFigurinhas; i++){
                if (figurinhasObtidas.get(i) == null){
                    Figurinha figurinha = new Figurinha(i, String.format("http://urlFakeDaFigurinha%d.jpg", i));
                    figurinhasObtidas.set(i, figurinha);
                }
            }
        }
    }

    public boolean possuiFigurinhaColada(int posicao) {
        return figurinhasObtidas.get(posicao - 1) != null;
    }

    public boolean possuiFigurinhaColada(Figurinha figurinha) {  // overload
        return possuiFigurinhaColada(figurinha.getPosicao());
    }

    public boolean possuiFigurinhaRepetida(int posicao) {
       return quantidadeFigurinhasRepetidas.get(posicao - 1) != 0;
    }

    public boolean possuiFigurinhaRepetida(Figurinha figurinha) {  // overload
        return possuiFigurinhaRepetida(figurinha.getPosicao());
    }

    public int getQuantFigurinhasColadas() {
        int figurinhasColadasAtualmente = 0;
        for (Figurinha auxiliar : figurinhasObtidas) {
            if (auxiliar != null){
                figurinhasColadasAtualmente++;
            }
        }
        return figurinhasColadasAtualmente;
    }

    public int getQuantFigurinhasRepetidas() {
        int repetidas = 0;
        for (int posicao : quantidadeFigurinhasRepetidas){
            repetidas += posicao;
        }
        return repetidas;
    }

    public int getQuantFigurinhasFaltando() {
        return totalFigurinhas - getQuantFigurinhasColadas();
    }

}
