import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear organizador
        Organizador organizador = new Organizador();
        organizador.setNombre("EcoEventos");
        organizador.setCorreo_electronico("eco@eventos.com");
        organizador.setTelefono(123456789);

        // Crear ubicación
        Ubicacion ubicacion = new Ubicacion("Madrid");

        // Crear categoría
        Categoria categoria = new Categoria("Taller");

        // Crear evento
        Evento evento = new Evento();
        evento.setNombre("Taller de reciclaje");
        evento.setFecha(LocalDate.of(2025, 6, 10));
        evento.setDuracion(2);
        evento.setUbicacion(ubicacion);
        evento.setOrganizador(organizador);
        evento.setCategoria(categoria);

        // Registrar el evento en el sistema
        Portal.eventos.put(evento.getNombre(), evento);

        // Registrar usuarios
        Portal.registrarUsuario("Ana Pérez", "ana@gmail.com", "clave123");
        Portal.registrarUsuario("Luis Gómez", "luis@gmail.com", "1234");

        // Inscribir usuario al evento
        Usuario usuarioAna = Portal.usuarios.get("ana@gmail.com");
        evento.inscribirUsuario(usuarioAna);

        // Intentar inscribirla otra vez (debería lanzar error)
        try {
            evento.inscribirUsuario(usuarioAna);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Mostrar inscritos
        System.out.println("Usuarios inscritos en el evento:");
        for (Usuario u : evento.getUsuariosEvento().values()) {
            System.out.println(u.getNombre() + " - " + u.getCorreoElectronico());
        }
    }
}
