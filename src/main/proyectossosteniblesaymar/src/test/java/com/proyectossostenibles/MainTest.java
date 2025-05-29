package com.proyectossostenibles;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    @BeforeEach
    void setUp() {
        Main.init();
    }

    @Test
    void testInitDatosEjemplo() {
        assertFalse(Main.mapaUsuarios.isEmpty());
        assertFalse(Main.mapaEventos.isEmpty());
        assertFalse(Main.mapaOrganizadores.isEmpty());
        assertFalse(Main.conjuntoCategorias.isEmpty());
    }

    @Test
    void testMostrarUsuariosNoLanzaExcepcion() {
        assertDoesNotThrow(() -> Main.mostrarUsuarios());
    }

    @Test
    void testMostrarEventosNoLanzaExcepcion() {
        assertDoesNotThrow(() -> Main.mostrarEventos());
    }

    @Test
    void testMostrarOrganizadoresNoLanzaExcepcion() {
        assertDoesNotThrow(() -> Main.mostrarOrganizadores());
    }

    @Test
    void testMostrarCategoriasNoLanzaExcepcion() {
        assertDoesNotThrow(() -> Main.mostrarCategorias());
    }

    @Test
    void testMostrarMapaEventosDeUnUsuarioUsuarioNoExiste() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream("NoExiste\n".getBytes()));
        assertDoesNotThrow(() -> Main.mostrarMapaEventosDeUnUsuario());
        System.setIn(sysInBackup);
    }

    @Test
    void testMostrarMapaEventosDeUnUsuarioConEventos() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream((Main.usuarioEjemplo.getNombre() + "\n").getBytes()));
        assertDoesNotThrow(() -> Main.mostrarMapaEventosDeUnUsuario());
        System.setIn(sysInBackup);
    }

    @Test
    void testMostrarUsuariosDeUnEventoEventoNoExiste() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream("NoExiste\n".getBytes()));
        assertDoesNotThrow(() -> Main.mostrarUsuariosDeUnEvento());
        System.setIn(sysInBackup);
    }

    @Test
    void testMostrarUsuariosDeUnEventoConUsuarios() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream((Main.eventoEjemplo.getNombre() + "\n").getBytes()));
        assertDoesNotThrow(() -> Main.mostrarUsuariosDeUnEvento());
        System.setIn(sysInBackup);
    }

    @Test
    void testMostrarMapaEventosDeUnOrganizadorNoExiste() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream("NoExiste\n".getBytes()));
        assertDoesNotThrow(() -> Main.mostrarMapaEventosDeUnOrganizador());
        System.setIn(sysInBackup);
    }

    @Test
    void testMostrarMapaEventosDeUnOrganizadorConEventos() {
        InputStream sysInBackup = System.in;
        System.setIn(new ByteArrayInputStream((Main.organizadorEjemplo.getNombre() + "\n").getBytes()));
        assertDoesNotThrow(() -> Main.mostrarMapaEventosDeUnOrganizador());
        System.setIn(sysInBackup);
    }
}
