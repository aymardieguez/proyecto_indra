package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CategoriaTest {
    @Test
    void testConstructorAndGetters() {
        Categoria c = new Categoria("Medio Ambiente");
        assertEquals("Medio Ambiente", c.getNombre());
    }

    @Test
    void testEqualsAndHashCode() {
        Categoria c1 = new Categoria("Salud");
        Categoria c2 = new Categoria("Salud");
        Categoria c3 = new Categoria("Educación");
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testToString() {
        Categoria c = new Categoria("Cultura");
        assertTrue(c.toString().contains("Cultura"));
    }
}
