package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static Map<String, Usuario> mapaUsuarios = new HashMap<>();
    static Map<String, Evento> mapaEventos = new HashMap<>();
    static Map<String, Organizador> mapaOrganizadores = new HashMap<>();

    public static void main(String[] args) {
        int opcion;

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
                case 0 -> System.out.println("Saliendo del programa.");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
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
        System.out.println("0. Salir");
    }

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

    public static void crearEvento() {
        System.out.println("Nombre del evento: ");
        String nombre = teclado.nextLine();

        System.out.println("Dirección del evento: ");
        String direccion = teclado.nextLine();

        System.out.println("Tipo de evento (Presencial/Online): ");
        String tipo = teclado.nextLine();
        Ubicacion ubicacion = new Ubicacion(direccion, tipo);

        System.out.println("Nombre del organizador (debe existir): ");
        String nombreOrganizador = teclado.nextLine();
        Organizador organizador = mapaOrganizadores.get(nombreOrganizador);

        if (organizador == null) {
            System.out.println("Organizador no encontrado. Cree uno primero.");
            return;
        }

        System.out.println("Categoría del evento: ");
        String categoria = teclado.nextLine();

        System.out.println("Fecha del evento (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(teclado.nextLine());

        System.out.println("Duración (en horas): ");
        int duracion = Integer.parseInt(teclado.nextLine());

        Evento evento = new Evento(nombre, ubicacion, organizador, categoria, fecha, duracion);
        mapaEventos.put(nombre, evento);
        organizador.crearEvento(evento);

        System.out.println("Evento creado correctamente.");
    }

    public static void inscribirUsuario() {
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

    public static void desinscribirUsuario() {
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

    public static void eliminarEvento() {
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
}
