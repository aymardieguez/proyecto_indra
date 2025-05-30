package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UbicacionTest {

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
