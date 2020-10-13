import java.util.ArrayList;

public class Tuite<T> {

    private final Usuario autor;
    private final String texto;
    private Object arquivoAnexado;
    protected static ArrayList<String> listaDeHashtags = new ArrayList<>();

    public Tuite(Usuario autor, String texto) {
        this.autor = autor;
        this.texto = texto;
    }

    public void anexarAlgo(T anexo) {
        this.arquivoAnexado = anexo;
    }

    public Object getAnexo() {
        return arquivoAnexado;
    }

    public Usuario getAutor() {
        return this.autor;
    }

    public String getTexto() {
        return this.texto;
    }

    public ArrayList<String> getHashtags() {
        String[] palavras = getTexto().split("[\\s]");
        for (String palavra: palavras){
            if (palavra.startsWith("#")){
                listaDeHashtags.add(palavra);
            }
        }
        return listaDeHashtags;
    }
}
