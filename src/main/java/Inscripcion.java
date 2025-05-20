public class Inscripcion {
    private Usuario usuario;
    private Evento evento;

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Evento getEvento() {
        return this.evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public void inscribirUsuario(Usuario usuario, Evento evento) {
        if (usuario.getEventosUsuario().containsKey(evento.getNombre())) {
            System.out.println("El usuario ya está inscrito en el evento");
            throw new IllegalArgumentException("El usuario ya está inscrito en el evento");
        } else {
            usuario.getEventosUsuario().put(evento.getNombre(), evento);
            evento.getUsuariosEvento().put(usuario.getCorreoElectronico(), usuario);
            System.out.println("Usuario inscrito en el evento");
        }
    }

    public void desinscribirUsuario(Usuario usuario, Evento evento) {
        if (usuario.getEventosUsuario().containsKey(this.evento.getNombre())) {
            usuario.getEventosUsuario().remove(this.evento.getNombre());
            evento.getUsuariosEvento().remove(usuario.getCorreoElectronico());
            System.out.println("Usuario desinscrito del evento");
        } else {
            System.out.println("El usuario no está inscrito en el evento");
            throw new IllegalArgumentException("El usuario no está inscrito en el evento");
        }
    }

}
