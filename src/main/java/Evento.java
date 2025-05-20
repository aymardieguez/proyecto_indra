
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

class Evento {

    private String nombre;
    private LocalDate fecha;
    private int duracion;
    private Ubicacion ubicacion;
    private Organizador organizador;
    private Categoria categoria;
    // creación del mapa de usuarios
    private HashMap<String, Usuario> usuariosEvento = new HashMap<>();
    static Scanner teclado = new Scanner(System.in);

    public Evento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Organizador getOrganizador() {
        return this.organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public HashMap<String, Usuario> getUsuariosEvento() {
        return this.usuariosEvento;
    }

    public void setUsuariosEvento(HashMap<String, Usuario> usuariosEvento) {
        this.usuariosEvento = usuariosEvento;
    }

}
