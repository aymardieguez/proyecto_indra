import java.util.HashMap;

public class Portal {
    static HashMap<String, Usuario> usuarios = new HashMap<>();
    static HashMap<String, Evento> eventos = new HashMap<>();
    static HashMap<String, Organizador> organizadores = new HashMap<>();

    public static void registrarUsuario(String nombre, String correo_electronico, String contraseña) {
        Usuario usuario = new Usuario(nombre, correo_electronico, contraseña);
        if (usuarios.containsKey(correo_electronico)) {
            System.out.println("El usuario ya existe");
            throw new IllegalArgumentException("El usuario ya existe");
        } else {
            System.out.println("Usuario registrado");
            usuarios.put(correo_electronico, usuario);
        }
    }
}
