
import java.util.HashMap;

public class Usuario {
    private String nombre;
    private String correo_electronico;
    private String contraseña;
    private HashMap<String, Evento> eventosUsuario = new HashMap<>();

    public Usuario(String nombre, String correo_electronico, String contraseña) {
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return this.correo_electronico;
    }

    public void setCorreoElectronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo_electronico() {
        return this.correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public HashMap<String, Evento> getEventosUsuario() {
        return this.eventosUsuario;
    }

    public void setEventosUsuario(HashMap<String, Evento> eventosUsuario) {
        this.eventosUsuario = eventosUsuario;
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() +
                "}";
    }

    // dos usuarios son iguales si tienen el mismo correo electrónico
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return correo_electronico != null && correo_electronico.equals(other.correo_electronico);
    }

    @Override
    public int hashCode() {
        return correo_electronico != null ? correo_electronico.hashCode() : 0;
    }

}
