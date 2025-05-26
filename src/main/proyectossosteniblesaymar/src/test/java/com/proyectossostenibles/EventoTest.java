package com.proyectossostenibles;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

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
        assertNotNull(e.getMapaUsuarios());
    }

    @Test
    void testSetters() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Ubicacion nuevaUbi = new Ubicacion("Otra", "Online");
        e.setUbicacion(nuevaUbi);
        e.setOrganizador(org);
        e.setCategoria(cat);
        e.setFecha(LocalDate.of(2025, 5, 26));
        e.setDuracion(5);
        assertEquals(nuevaUbi, e.getUbicacion());
        assertEquals(org, e.getOrganizador());
        assertEquals(cat, e.getCategoria());
        assertEquals(LocalDate.of(2025, 5, 26), e.getFecha());
        assertEquals(5, e.getDuracion());
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
        assertNotEquals(e1.hashCode(), e3.hashCode());
    }

    @Test
    void testInscribirYDesinscribirUsuario() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Usuario u = new Usuario("Juan", "juan@mail.com", "1234");
        e.inscribirUsuario(u);
        assertTrue(e.getMapaUsuarios().containsKey("Juan"));
        assertTrue(u.getMapaEventos().containsKey("Ev"));
        e.desinscribirUsuario(u);
        assertFalse(e.getMapaUsuarios().containsKey("Juan"));
        assertFalse(u.getMapaEventos().containsKey("Ev"));
    }

    @Test
    void testInscribirUsuarioExistenteLanzaExcepcion() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Usuario u = new Usuario("Juan", "juan@mail.com", "1234");
        e.inscribirUsuario(u);
        assertThrows(RuntimeException.class, () -> e.inscribirUsuario(u));
    }

    @Test
    void testDesinscribirUsuarioInexistenteLanzaExcepcion() {
        Organizador org = new Organizador("Org", 1, "mail@o.com");
        Categoria cat = new Categoria("Cat");
        Ubicacion ubi = new Ubicacion("Dir", "Presencial");
        Evento e = new Evento("Ev", ubi, org, cat, LocalDate.now(), 2);
        Usuario u = new Usuario("Juan", "juan@mail.com", "1234");
        assertThrows(RuntimeException.class, () -> e.desinscribirUsuario(u));
    }
}
