import java.util.ArrayList;
import java.util.Collections;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite<T> {

    public static final int TAMANHO_MAXIMO_TUITES = 120;
    private ArrayList<String> listaDeUsuarios = new ArrayList<>();

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retorna null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {

        Usuario usuario = new Usuario(nome, email);
        setListaDeUsuarios(nome);
        return usuario;
    }

    /**
     * Tuíta algo, retornando o objeto Tuíte criado.
     * Se o tamanho do texto exceder o limite pré-definido, não faz nada e retorna null.
     * Se o usuário não estiver cadastrado, não faz nada e retorna null.
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {

        boolean usuarioExistente = false;
        for (String nome : listaDeUsuarios){
            if (usuario.getNome().toLowerCase().equals(nome.toLowerCase())) {
                usuarioExistente = true;
                break;
            }
        }

        if (usuarioExistente && texto.length() <= TAMANHO_MAXIMO_TUITES){
            Tuite tuite = new Tuite(usuario, texto);
            usuario.setNumeroDeTuites();
            tuite.getHashtags();
            if (usuario.getNumeroDeTuites() == Usuario.MIN_TUITES_SENIOR){
                Usuario.upgradeSenior();
            }
            else if (usuario.getNumeroDeTuites() == Usuario.MIN_TUITES_NINJA){
                Usuario.upgradeNinja();
            }
            return tuite;
        }
        else{
            return null;
        }
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {

        ArrayList<String> lista = Tuite.listaDeHashtags;
        Collections.sort(lista);

        String stringAux = lista.get(0), hashtagMaisRepetida = lista.get(0);
        int intAux = 1, quantMaisRepetida = 1;

        for (int i = 1; i < lista.size(); i++){
            if (lista.get(i).equals(stringAux)){
                intAux++;
            }
            else{
                intAux = 1;
                stringAux = lista.get(i);
            }
            if (quantMaisRepetida < intAux){
                quantMaisRepetida = intAux;
                hashtagMaisRepetida = lista.get(i);
            }
        }

        return hashtagMaisRepetida;
    }

    public void setListaDeUsuarios(String nomeDeUsuario) {
        listaDeUsuarios.add(nomeDeUsuario);
    }
}
