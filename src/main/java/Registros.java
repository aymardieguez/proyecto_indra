
import java.util.HashMap;

public class Registros {
    private HashMap<String, Evento> eventosRegistrados = new HashMap<>();
    private HashMap<String, Usuario> usuariosRegistrados = new HashMap<>();
    private HashMap<String, Organizador> organizadoresRegistrados = new HashMap<>();

    public HashMap<String, Evento> getEventosRegistrados() {
        return eventosRegistrados;
    }

    public void setEventosRegistrados(HashMap<String, Evento> eventosRegistrados) {
        this.eventosRegistrados = eventosRegistrados;
    }

    public HashMap<String, Usuario> getUsuariosRegistrados() {
        return usuariosRegistrados;
    }

    public void setUsuariosRegistrados(HashMap<String, Usuario> usuariosRegistrados) {
        this.usuariosRegistrados = usuariosRegistrados;
    }

    public HashMap<String, Organizador> getOrganizadoresRegistrados() {
        return this.organizadoresRegistrados;
    }

    public void setOrganizadoresRegistrados(HashMap<String, Organizador> organizadoresRegistrados) {
        this.organizadoresRegistrados = organizadoresRegistrados;
    }

}
