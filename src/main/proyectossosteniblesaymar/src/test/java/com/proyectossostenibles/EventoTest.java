package com.proyectossostenibles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EventoTest {
    private Organizador org;
    private Categoria cat;
    private Ubicacion ubi;
    private Evento e;
    private Usuario u;

    @BeforeEach
    void setUp() {
        org = new Organizador("Org", 1, "mail@o.com");
        cat = new Categoria("Cat");
        ubi = new Ubicacion("Dir", "Presencial");
        e = new Evento("Ev", ubi, org, cat, LocalDate.of(2024, 1, 1), 2);
        u = new Usuario("Juan", "juan@mail.com", "1234");
    }

    @Test
    void testInscribirYDesinscribirUsuario() {
        u.inscribirAEvento(e);
        assertTrue(!e.getMapaUsuarios().containsKey(u.getNombre() + "_" + e.getFecha()));
        assertTrue(u.getMapaEventos().containsKey(e.getNombre() + "_" + e.getFecha()));
        u.desinscribirDeEvento(e);
        assertFalse(e.getMapaUsuarios().containsKey(u.getNombre() + "_" + e.getFecha()));
        assertFalse(u.getMapaEventos().containsKey(e.getNombre() + "_" + e.getFecha()));
    }

    @Test
    void testInscribirUsuarioExistenteLanzaExcepcion() {
        u.inscribirAEvento(e);
        Exception ex = assertThrows(RuntimeException.class, () -> u.inscribirAEvento(e));
        assertNotNull(ex.getMessage());
    }

    @Test
    void testDesinscribirUsuarioInexistenteLanzaExcepcion() {
        RuntimeException ex = assertThrows(RuntimeException.class, () -> u.desinscribirDeEvento(e));
        assertNotNull(ex.getMessage());
    }
}
