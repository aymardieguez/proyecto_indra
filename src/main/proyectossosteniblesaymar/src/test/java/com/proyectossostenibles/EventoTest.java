package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
    void testConstructorAndGetters() {
        assertEquals("Ev", e.getNombre());
        assertEquals(ubi, e.getUbicacion());
        assertEquals(org, e.getOrganizador());
        assertEquals(cat, e.getCategoria());
        assertEquals(LocalDate.of(2024, 1, 1), e.getFecha());
        assertEquals(2, e.getDuracion());
        assertNotNull(e.getMapaUsuarios());
    }

    @Test
    void testSetters() {
        Ubicacion nuevaUbi = new Ubicacion("Otra", "Online");
        e.setUbicacion(nuevaUbi);
        e.setOrganizador(org);
        e.setCategoria(cat);
        e.setFecha(LocalDate.of(2025, 5, 26));
        e.setDuracion(5);
        assertEquals(nuevaUbi, e.getUbicacion());
        assertEquals(org, e.getOrganizador());
        assertEquals(cat, e.getCategoria());
        assertEquals(LocalDate.of(2025, 5, 26), e.getFecha());
        assertEquals(5, e.getDuracion());
    }

    @Test
    void testEqualsAndHashCode() {
        Evento e2 = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Evento e3 = new Evento("Otro", ubi, org, cat, LocalDate.now(), 2);
        assertEquals(e, e2);
        assertNotEquals(e, e3);
        assertEquals(e.hashCode(), e2.hashCode());
        assertNotEquals(e.hashCode(), e3.hashCode());
    }

    @Test
    void testInscribirYDesinscribirUsuario() {
        u.inscribirAEvento(e);
        assertTrue(e.getMapaUsuarios().containsKey(u.getNombre() + "_" + e.getFecha()));
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

    @Test
    void testToString() {
        assertTrue(e.toString().contains("Ev"));
        assertTrue(e.toString().contains("Presencial"));
    }

    @Test
    void testSetMapaUsuarios() {
        Map<String, Usuario> map = new HashMap<>();
        e.setMapaUsuarios(map);
        assertEquals(map, e.getMapaUsuarios());
    }
}
