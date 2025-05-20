
import java.time.LocalDate;

class Evento {

    private String nombre;
    private LocalDate fecha;
    private int duracion;
    private String ubicacion;
    private String tipo;
    private String organizador;

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

    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOrganizador() {
        return this.organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

}
