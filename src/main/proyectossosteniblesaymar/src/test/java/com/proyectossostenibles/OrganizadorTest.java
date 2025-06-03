package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

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
    void testEqualsAndHashCode() {
        Organizador o1 = new Organizador("Org", 1, "mail@o.com");
        Organizador o2 = new Organizador("Otro", 2, "mail@o.com");
        Organizador o3 = new Organizador("Org", 1, "otro@o.com");
        assertEquals(o1, o2);
        assertNotEquals(o1, o3);
        assertEquals(o1.hashCode(), o2.hashCode());
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
}
