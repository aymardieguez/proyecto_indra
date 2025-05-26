package com.proyectossostenibles;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    @Test
    void testConstructorAndGetters() {
        Usuario u = new Usuario("Juan", "juan@mail.com", "1234");
        assertEquals("Juan", u.getNombre());
        assertEquals("juan@mail.com", u.getEmail());
        assertEquals("1234", u.getContraseña());
        assertNotNull(u.getMapaEventos());
    }

    @Test
    void testSetters() {
        Usuario u = new Usuario("A", "a@mail.com", "pass");
        u.setNombre("B");
        u.setEmail("b@mail.com");
        u.setContraseña("newpass");
        Map<String, Evento> map = new HashMap<>();
        u.setMapaEventos(map);
        assertEquals("B", u.getNombre());
        assertEquals("b@mail.com", u.getEmail());
        assertEquals("newpass", u.getContraseña());
        assertEquals(map, u.getMapaEventos());
    }

    @Test
    void testEqualsAndHashCode() {
        Usuario u1 = new Usuario("Ana", "ana@mail.com", "1");
        Usuario u2 = new Usuario("Pedro", "ana@mail.com", "2");
        Usuario u3 = new Usuario("Luis", "luis@mail.com", "3");
        assertEquals(u1, u2);
        assertNotEquals(u1, u3);
        assertEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
    }
}
