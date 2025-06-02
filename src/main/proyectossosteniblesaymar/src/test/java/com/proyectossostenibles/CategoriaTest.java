package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
