public class UsuarioInvalidoException extends Exception {

    private String usuarioInvalido;

    public String getUsuarioInvalido(){
        return usuarioInvalido;
    }

    public void setUsuarioInvalido(String usuarioInvalido){
        this.usuarioInvalido = usuarioInvalido;
    }
}
