package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class UbicacionTest {
    @Test
    void testEqualsAndHashCode() {
        Ubicacion u1 = new Ubicacion("Dir1", "Presencial");
        Ubicacion u2 = new Ubicacion("Dir1", "Online");
        Ubicacion u3 = new Ubicacion("Dir2", "Presencial");
        Ubicacion u4 = new Ubicacion("Dir2", "Presencial");
        assertNotEquals(u1, u2);
        assertEquals(u3, u4);

    }
}
