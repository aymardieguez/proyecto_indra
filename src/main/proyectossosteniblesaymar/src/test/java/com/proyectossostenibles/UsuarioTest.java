package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    @Test
    void testEqualsAndHashCode() {
        Usuario u1 = new Usuario("Ana", "ana@mail.com", "1");
        Usuario u2 = new Usuario("Ana Luisa", "ana@mail.com", "2");
        Usuario u3 = new Usuario("Ana", "ana2006@mail.com", "3");
        assertEquals(u1, u2);
        assertNotEquals(u1, u3);
        assertEquals(u1.hashCode(), u2.hashCode());
        assertNotEquals(u1.hashCode(), u3.hashCode());
    }
}
