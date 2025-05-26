package com.proyectossostenibles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class OrganizadorTest {
    @Test
    void testConstructorAndGetters() {
        Organizador o = new Organizador("Org1", 123, "org@mail.com");
        assertEquals("Org1", o.getNombre());
        assertEquals(123, o.getTelefono());
        assertEquals("org@mail.com", o.getEmail());
        assertNotNull(o.getMapaEventos());
    }

    @Test
    void testSetters() {
        Organizador o = new Organizador("A", 1, "a@mail.com");
        o.setNombre("B");
        o.setTelefono(2);
        o.setEmail("b@mail.com");
        Map<String, Evento> map = new HashMap<>();
        o.setMapaEventos(map);
        assertEquals("B", o.getNombre());
        assertEquals(2, o.getTelefono());
        assertEquals("b@mail.com", o.getEmail());
        assertEquals(map, o.getMapaEventos());
    }

    @Test
    void testToString() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        assertTrue(o.toString().contains("Org"));
        assertTrue(o.toString().contains("mail@o.com"));
    }

    @Test
    void testEqualsAndHashCode() {
        Organizador o1 = new Organizador("Org", 1, "mail@o.com");
        Organizador o2 = new Organizador("Otro", 2, "mail@o.com");
        Organizador o3 = new Organizador("Org", 1, "otro@o.com");
        assertEquals(o1, o2);
        assertNotEquals(o1, o3);
        assertEquals(o1.hashCode(), o2.hashCode());
        assertNotEquals(o1.hashCode(), o3.hashCode());
    }

    @Test
    void testCrearYEliminarEvento() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        o.crearEvento(e);
        assertTrue(o.getMapaEventos().containsKey("Ev"));
        o.eliminarEvento(e);
        assertFalse(o.getMapaEventos().containsKey("Ev"));
    }

    @Test
    void testCrearEventoExistenteLanzaExcepcion() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        o.crearEvento(e);
        assertThrows(RuntimeException.class, () -> o.crearEvento(e));
    }

    @Test
    void testEliminarEventoInexistenteLanzaExcepcion() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        assertThrows(RuntimeException.class, () -> o.eliminarEvento(e));
    }
}
