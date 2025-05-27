package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static Map<String, Usuario> mapaUsuarios = new HashMap<>();
    static Map<String, Evento> mapaEventos = new HashMap<>();
    static Map<String, Organizador> mapaOrganizadores = new HashMap<>();
    static Set<Categoria> conjuntoCategorias = new TreeSet<>();

    // Instancias de ejemplo para pruebas
    static Categoria categoriaEjemplo;
    static Categoria categoriaEjemplo2;
    static Ubicacion ubicacionEjemplo;
    static Ubicacion ubicacionOnline;
    static Organizador organizadorEjemplo;
    static Organizador organizadorEjemplo2;
    static Usuario usuarioEjemplo;
    static Usuario usuarioEjemplo2;
    static Evento eventoEjemplo;
    static Evento eventoEjemplo2;

    public static void main(String[] args) {
        int opcion;
        init(); // inicializa los ejemplos
        do {
            mostrarMenu();
            System.out.println("Seleccione una opción: ");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion) {
                case 1 -> crearUsuario();
                case 2 -> crearOrganizador();
                case 3 -> crearEvento();
                case 4 -> inscribirUsuario();
                case 5 -> desinscribirUsuario();
                case 6 -> eliminarEvento();
                case 7 -> mostrarUsuarios();
                case 8 -> mostrarEventos();
                case 9 -> mostrarOrganizadores();
                case 10 -> mostrarCategorias();
                case 11 -> mostrarMapaEventosDeUnUsuario();
                case 12 -> mostrarUsuariosDeUnEvento();
                case 13 -> mostrarMapaEventosDeUnOrganizador();
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Crear usuario");
        System.out.println("2. Crear organizador");
        System.out.println("3. Crear evento");
        System.out.println("4. Inscribir usuario a evento");
        System.out.println("5. Desinscribir usuario de evento");
        System.out.println("6. Eliminar evento");
        System.out.println("7. Mostrar usuarios");
        System.out.println("8. Mostrar eventos");
        System.out.println("9. Mostrar organizadores");
        System.out.println("10. Mostrar categorías");
        System.out.println("11. Mostrar eventos de un usuario");
        System.out.println("12. Mostrar usuarios de un evento");
        System.out.println("13. Mostrar los eventos de un organizador");
        System.out.println("0. Salir");
    }

    // pedimos los datos y si no existe el usuario (mismo email) creamos un usuario
    // en el Portal (sin eventos asociados)
    public static void crearUsuario() {
        System.out.println("Nombre de usuario: ");
        String nombre = teclado.nextLine();
        System.out.println("Email: ");
        String email = teclado.nextLine();
        System.out.println("Contraseña: ");
        String contraseña = teclado.nextLine();
        for (Usuario u : mapaUsuarios.values()) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Ya hay un usuario con este email, no se admiten emails duplicados.");
                return;
            }
        }
        mapaUsuarios.put(nombre, new Usuario(nombre, email, contraseña));
        System.out.println("Usuario creado correctamente.");

    }

    // pedimos los datos y si no existe el organizador (mismo email) creamos un
    // organizador
    // en el Portal (sin eventos asociados)
    public static void crearOrganizador() {
        System.out.println("Nombre del organizador: ");
        String nombre = teclado.nextLine();
        System.out.println("Teléfono: ");
        int telefono = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Email: ");
        String email = teclado.nextLine();
        for (Organizador o : mapaOrganizadores.values()) {
            if (o.getEmail().equalsIgnoreCase(email)) {
                System.out.println("Ya hay un organizador con este email, no se admiten emails duplicados.");
                return;
            }
        }
        mapaOrganizadores.put(nombre, new Organizador(nombre, telefono, email));
        System.out.println("Organizador creado correctamente.");

    }

    // pedimos los datos para crear el evento y si son válidos llamamos a la función
    // crearEvento(Usuario usuario) dentro de la clase Organizador
    public static void crearEvento() throws RuntimeException {
        System.out.println("Nombre del evento: ");
        String nombre = teclado.nextLine();

        System.out.println("Dirección del evento: ");
        String direccion = teclado.nextLine();

        System.out.println("Tipo de evento (Presencial/Online): ");
        String tipo = teclado.nextLine();
        if (!tipo.equalsIgnoreCase("Presencial") && !tipo.equalsIgnoreCase("Online")) {
            System.out.println("Tipo de evento no válido. Debe ser 'Presencial' o 'Online'.");
            return;
        }
        Ubicacion ubicacion = new Ubicacion(direccion, tipo);

        System.out.println("Nombre del organizador (debe existir): ");
        String nombreOrganizador = teclado.nextLine();
        Organizador organizador = mapaOrganizadores.get(nombreOrganizador);

        if (organizador == null) {
            System.out.println("Organizador no encontrado. Cree uno primero.");
            return;
        }

        System.out.println("Categoría del evento: ");
        Categoria categoria = new Categoria(teclado.nextLine());

        System.out.println("Fecha del evento (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(teclado.nextLine());

        System.out.println("Duración (en horas): ");
        int duracion = Integer.parseInt(teclado.nextLine());

        try {
            Evento evento = new Evento(nombre, ubicacion, organizador, categoria, fecha, duracion);
            mapaEventos.put(nombre, evento);
            organizador.crearEvento(evento);
            System.out.println("Evento creado correctamente.");
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    // pedimos los datos y si el evento existe, llamamos a la funcion
    // eliminarEvento(Evento evento) en la clase Organizador
    public static void eliminarEvento() {
        mostrarEventos();
        System.out.println("Nombre del evento a eliminar: ");
        String nombreEvento = teclado.nextLine();
        Evento evento = mapaEventos.remove(nombreEvento);

        if (evento != null) {
            Organizador organizador = evento.getOrganizador();
            organizador.eliminarEvento(evento);
            System.out.println("Evento eliminado correctamente.");
        } else {
            System.out.println("Evento no encontrado.");
        }
    }

    // se comprueba que exista el usuario en el Portal y si existe, se llama a la
    // funcion inscribirUsuario(Usuario usuario) en la clase Evento
    public static void inscribirUsuario() throws RuntimeException {
        mostrarUsuarios();
        System.out.println("Nombre del usuario: ");
        String nombreUsuario = teclado.nextLine();
        Usuario usuario = mapaUsuarios.get(nombreUsuario);

        System.out.println("Nombre del evento: ");
        String nombreEvento = teclado.nextLine();
        Evento evento = mapaEventos.get(nombreEvento);

        if (usuario == null || evento == null) {
            System.out.println("Usuario o evento no encontrado.");
            return;
        }

        try {
            evento.inscribirUsuario(usuario);
            System.out.println("Usuario inscrito correctamente.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // se comprueba que exista el usuario en el Portal y si existe, se llama a la
    // funcion inscribirUsuario(Usuario usuario) en la clase Evento.
    // OJO, desinscribir un usuario no lo elimina del Portal!!
    public static void desinscribirUsuario() throws RuntimeException {
        mostrarUsuarios();
        System.out.println("Nombre del usuario: ");
        String nombreUsuario = teclado.nextLine();
        Usuario usuario = mapaUsuarios.get(nombreUsuario);

        System.out.println("Nombre del evento: ");
        String nombreEvento = teclado.nextLine();
        Evento evento = mapaEventos.get(nombreEvento);

        if (usuario == null || evento == null) {
            System.out.println("Usuario o evento no encontrado.");
            return;
        }

        try {
            evento.desinscribirUsuario(usuario);
            System.out.println("Usuario desinscrito correctamente.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    // métodos para mostrar los datos que hay en todo el portal, todos los usuarios,
    // eventos, organizadores, categorias...
    public static void mostrarUsuarios() {
        for (Usuario u : mapaUsuarios.values()) {
            System.out.println(u);
        }
    }

    public static void mostrarEventos() {
        for (Evento e : mapaEventos.values()) {
            System.out.println(e);
        }
    }

    public static void mostrarOrganizadores() {
        for (Organizador o : mapaOrganizadores.values()) {
            System.out.println(o);
        }
    }

    public static void mostrarCategorias() {
        for (Evento e : mapaEventos.values()) {
            conjuntoCategorias.add(e.getCategoria());
        }
        for (Categoria c : conjuntoCategorias) {
            System.out.println(c);
        }
    }

    // métodos para mostrar datos en específico de cada usuario, evento o
    // organizador
    public static void mostrarMapaEventosDeUnUsuario() throws RuntimeException {
        mostrarUsuarios();
        System.out.println("Introduce el nombre del usuario: ");
        String nombreUsuario = teclado.nextLine();
        Usuario usuario = mapaUsuarios.get(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        try {

            usuario.mostrarEventos();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void mostrarUsuariosDeUnEvento() throws RuntimeException {
        mostrarEventos();
        System.out.println("Introduce el nombre del evento:");
        String nombreEvento = teclado.nextLine();
        try {
            Evento evento = mapaEventos.get(nombreEvento);
            evento.mostrarUsuariosInscritos();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void mostrarMapaEventosDeUnOrganizador() throws RuntimeException {
        mostrarOrganizadores();
        System.out.println("Introduce el organizador:");
        String nombreOrganizador = teclado.nextLine();
        try {
            Organizador organizador = mapaOrganizadores.get(nombreOrganizador);
            organizador.mostrarEventos();
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }

    // método para inicializar los ejemplos para realizar pruebas en el programa
    public static void init() {
        categoriaEjemplo = new Categoria("Taller");
        categoriaEjemplo2 = new Categoria("Conferencia");
        ubicacionEjemplo = new Ubicacion("Calle Mayor 1", "Presencial");
        ubicacionOnline = new Ubicacion("Zoom", "Online");
        organizadorEjemplo = new Organizador("EcoEmpresa", 123456789, "eco@empresa.com");
        organizadorEjemplo2 = new Organizador("SostenibleOrg", 987654321, "sostenible@org.com");
        usuarioEjemplo = new Usuario("Ana", "ana@email.com", "pass123");
        usuarioEjemplo2 = new Usuario("Luis", "luis@email.com", "pass456");
        eventoEjemplo = new Evento(
                "Taller Reciclaje",
                ubicacionEjemplo,
                organizadorEjemplo,
                categoriaEjemplo,
                LocalDate.of(2025, 6, 10),
                2);
        eventoEjemplo2 = new Evento(
                "Conferencia Energía",
                ubicacionOnline,
                organizadorEjemplo2,
                categoriaEjemplo2,
                LocalDate.of(2025, 7, 5),
                3);

        // Categorías
        conjuntoCategorias.add(categoriaEjemplo);
        conjuntoCategorias.add(categoriaEjemplo2);

        // Organizadores
        mapaOrganizadores.put(organizadorEjemplo.getNombre(), organizadorEjemplo);
        mapaOrganizadores.put(organizadorEjemplo2.getNombre(), organizadorEjemplo2);

        // Usuarios
        mapaUsuarios.put(usuarioEjemplo.getNombre(), usuarioEjemplo);
        mapaUsuarios.put(usuarioEjemplo2.getNombre(), usuarioEjemplo2);

        // Eventos
        mapaEventos.put(eventoEjemplo.getNombre(), eventoEjemplo);
        mapaEventos.put(eventoEjemplo2.getNombre(), eventoEjemplo2);

        // Asociar eventos a organizadores
        organizadorEjemplo.crearEvento(eventoEjemplo);
        organizadorEjemplo2.crearEvento(eventoEjemplo2);

        // Inscribir usuarios a eventos
        eventoEjemplo.inscribirUsuario(usuarioEjemplo);
        eventoEjemplo2.inscribirUsuario(usuarioEjemplo2);
    }
}
