import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
    private static final HashMap<String, Usuario> usuarioByEmail = new HashMap<>();
    private static final HashMap<String, Integer> contByHashtag = new HashMap<>();

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * Se o email informado já estiver em uso, não faz nada e retorna null.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {

        Usuario usuario = new Usuario(nome, email);
        usuarioByEmail.put(email, usuario);
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

        if (!usuarioByEmail.containsKey(usuario.getEmail()) || texto.length() > TAMANHO_MAXIMO_TUITES){
            return null;
        }
        else {
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
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {

        int aux = 0;
        String hashtagMaisRepetida = null;
        ArrayList<String> lista = Tuite.listaDeHashtags;
        Collections.sort(lista);

        for (int i = 0; i < lista.size(); i++) {
            if (contByHashtag.containsKey(lista.get(i))) {
                contByHashtag.put(lista.get(i), contByHashtag.get(lista.get(i)) + 1);
            }
            else {
                contByHashtag.put(lista.get(i), 1);
            }
        }

        for (String i : contByHashtag.keySet()){
            if (contByHashtag.get(i) > aux){
                aux = contByHashtag.get(i);
                hashtagMaisRepetida = i;
            }
        }

        return hashtagMaisRepetida;
    }
}


