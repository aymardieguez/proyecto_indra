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
    void testSetNombre() {
        Categoria c = new Categoria("A");
        c.setNombre("B");
        assertEquals("B", c.getNombre());
    }

    @Test
    void testToString() {
        Categoria c = new Categoria("Cultura");
        assertTrue(c.toString().contains("Cultura"));
    }

    @Test
    void testEqualsAndHashCode() {
        Categoria c1 = new Categoria("Salud");
        Categoria c2 = new Categoria("Salud");
        Categoria c3 = new Categoria("Educación");
        assertEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertEquals(c1.hashCode(), c2.hashCode());
        assertNotEquals(c1.hashCode(), c3.hashCode());
    }

    @Test
    void testEqualsNullAndOtherClass() {
        Categoria c = new Categoria("X");
        assertNotEquals(c, null);
        assertNotEquals(c, "otraClase");
        assertEquals(c, c); // mismo objeto
    }

    @Test
    void testHashCodeNullNombre() {
        Categoria c = new Categoria(null);
        assertEquals(0, c.hashCode());
    }
}
