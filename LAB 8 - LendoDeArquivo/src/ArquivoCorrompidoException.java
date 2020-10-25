public class ArquivoCorrompidoException extends Exception {

    private int numeroDeLinhasInvalidas;

    public int getNumeroDeLinhasInvalidas(){
        return numeroDeLinhasInvalidas;
    }

    public void setNumeroDeLinhasInvalidas(int numeroDeLinhasInvalidas){
        this.numeroDeLinhasInvalidas = numeroDeLinhasInvalidas;
    }
}
