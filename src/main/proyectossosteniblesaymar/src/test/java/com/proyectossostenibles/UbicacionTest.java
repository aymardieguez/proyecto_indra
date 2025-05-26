package com.proyectossostenibles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class UbicacionTest {
    @Test
    void testConstructorAndGetters() {
        Ubicacion u = new Ubicacion("Calle 1", "Presencial");
        assertEquals("Calle 1", u.getDireccion());
        assertEquals("Presencial", u.getTipo());
    }

    @Test
    void testSetters() {
        Ubicacion u = new Ubicacion("A", "B");
        u.setDireccion("C");
        u.setTipo("Online");
        assertEquals("C", u.getDireccion());
        assertEquals("Online", u.getTipo());
    }

    @Test
    void testToString() {
        Ubicacion u = new Ubicacion("Dir", "Tipo");
        assertTrue(u.toString().contains("Dir"));
        assertTrue(u.toString().contains("Tipo"));
    }

    @Test
    void testEqualsAndHashCode() {
        Ubicacion u1 = new Ubicacion("Dir1", "Presencial");
        Ubicacion u2 = new Ubicacion("Dir1", "Online");
        Ubicacion u3 = new Ubicacion("Dir2", "Presencial");
        assertEquals(u1, u2);
        assertNotEquals(u1, u3);
        assertEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
    }
}
