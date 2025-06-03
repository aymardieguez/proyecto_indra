package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @Test
    void testConstructorAndGetters() {
        Usuario u = new Usuario("juan@mail.com", "Juan", "1234");
        assertEquals("juan@mail.com", u.getEmail());
        assertEquals("Juan", u.getNombre());
        assertEquals("1234", u.getContraseña());
        assertNotNull(u.getMapaEventos());
    }

    @Test
    void testEqualsAndHashCode() {
        Usuario u1 = new Usuario("ana@mail.com", "Ana", "1");
        Usuario u2 = new Usuario("ana@mail.com", "Pedro", "2");
        Usuario u3 = new Usuario("luis@mail.com", "Pedro", "3");
        assertEquals(u1, u2);
        assertNotEquals(u1, u3);
    }
}
