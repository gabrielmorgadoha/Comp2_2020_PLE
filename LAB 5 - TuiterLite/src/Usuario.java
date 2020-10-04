import java.awt.*;

public class Usuario {

    public static final int MIN_TUITES_SENIOR = 200;
    public static final int MIN_TUITES_NINJA = 1000;

    private final String email;
    private String nome;
    private Image foto;
    private int numeroDeTuites = 0;

    // Pode ser INICIANTE, SENIOR ou NINJA
    private static NivelUsuario nivel;

    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
        nivel = NivelUsuario.INICIANTE;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    public NivelUsuario getNivel() {
        return nivel;
    }

    public int getNumeroDeTuites(){
        return this.numeroDeTuites;
    }

    public void setNumeroDeTuites(){
        numeroDeTuites++;
    }

    public static void upgradeSenior(){
        nivel = NivelUsuario.SENIOR;
    }

    public static void upgradeNinja(){
        nivel = NivelUsuario.NINJA;
    }

    @Override
    public boolean equals(Object obj){
        if(obj.getClass() != Usuario.class){
            return false;
        }
        else{
            return this.getEmail().equals(((Usuario) obj).getEmail());
        }
    }
}
