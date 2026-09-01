package ttps.java.clasificados;

public class Usuario {
    String nombreUsuario;
    String clave;
    Perfil perfil;

    public Usuario(String nombreUsuario, String clave, Perfil perfil) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.perfil = perfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public Perfil getPerfil() {
        return perfil;
    }
}
