package com.proyectossostenibles;

import java.time.LocalDate;

public class Main {
    static Organizador organizador01 = new Organizador("Organizador01", 600123456, "organizador01@gmail.com");
    static Ubicacion ubicacion01 = new Ubicacion("Arillo", "Presencial");
    static Evento evento01 = new Evento("Evento01", ubicacion01, organizador01, "Taller", LocalDate.parse("2025-01-01"),
            10);

    static Usuario usuario01 = new Usuario("Aymar", "aymar01@gmail.com", "primerusuario1234");

    public static void main(String[] args) {
        inscribirUsuario();
        desinscribirUsuario();
    }

    public static void inscribirUsuario() throws RuntimeException {
        try {
            evento01.inscribirUsuario(usuario01);
            System.out.println("Usuario:" + usuario01.getNombre() + " inscrito al evento: " + evento01.getNombre()
                    + " correctamente");
            System.out.println("Usuarios inscritos en ese evento: " + evento01.getMapaUsuarios());
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void desinscribirUsuario() {
        try {
            evento01.desinscribirUsuario(usuario01);
            System.out.println("Usuario desinscrito");
            System.out.println("Usuarios inscritos en ese evento: " + evento01.getMapaUsuarios());
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}