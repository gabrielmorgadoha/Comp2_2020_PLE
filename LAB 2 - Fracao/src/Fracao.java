public class Fracao {

    private int numerador;
    private int denominador;
    private boolean positiva;

    public Fracao(int numerador, int denominador, boolean positiva) {
        this.numerador = numerador;
        this.denominador = denominador;
        this.positiva = positiva;
    }

    public double getValorNumerico() {
        return (isPositiva() ? (double)numerador/(double)denominador : -(double)numerador/(double)denominador);
    }

    public Fracao getFracaoGeratriz() {
        int auxiliar1 = numerador;
        int auxiliar2 = denominador;

        while(auxiliar2 != 0){
            int resto = (auxiliar1 % auxiliar2);
            auxiliar1 = auxiliar2;
            auxiliar2 = resto;
        }

        if(auxiliar1 == 1){
            return this;
        }
        else{
            return new Fracao(numerador /= auxiliar1, denominador /= auxiliar1, positiva);
        }

    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public boolean isPositiva() {
        return positiva;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != Fracao.class){
            return false;
        }

        Fracao fracaoComparativa = ((Fracao) obj).getFracaoGeratriz();

        if (this.numerador == 0 || fracaoComparativa.getNumerador() == 0){
            this.positiva = false;
            fracaoComparativa.positiva = false;
            return true;
        }
        else {
            return this.getFracaoGeratriz().numerador == fracaoComparativa.numerador && this.getFracaoGeratriz().denominador == fracaoComparativa.denominador && this.positiva == fracaoComparativa.positiva;
        }
    }

}
