package com.proyectossostenibles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class EventoTest {
    @Test
    void testConstructorAndGetters() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e = new Evento("Ev", ubi, org, cat, LocalDate.of(2024, 1, 1), 2);
        assertEquals("Ev", e.getNombre());
        assertEquals(ubi, e.getUbicacion());
        assertEquals(org, e.getOrganizador());
        assertEquals(cat, e.getCategoria());
        assertEquals(LocalDate.of(2024, 1, 1), e.getFecha());
        assertEquals(2, e.getDuracion());
    }

    @Test
    void testEqualsAndHashCode() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e1 = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Evento e2 = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Evento e3 = new Evento("Otro", ubi, org, cat, LocalDate.now(), 2);
        assertEquals(e1, e2);
        assertNotEquals(e1, e3);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

}
