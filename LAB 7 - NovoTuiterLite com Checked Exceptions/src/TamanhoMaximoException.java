public class TamanhoMaximoException extends Exception {

    private int letrasExcedentes;

    public int getLetrasExcedentes(){
        return letrasExcedentes;
    }

    public void setLetrasExcedentes(int letrasExcedentes){
        this.letrasExcedentes = letrasExcedentes;
    }
}
