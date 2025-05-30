package com.proyectossostenibles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class OrganizadorTest {

    @Test
    void testCrearYEliminarEvento() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        o.crearEvento(e);
        assertTrue(o.getMapaEventos().containsKey("Ev"));
        o.eliminarEvento(e);
        assertFalse(o.getMapaEventos().containsKey("Ev"));
    }

    @Test
    void testCrearEventoExistenteLanzaExcepcion() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        o.crearEvento(e);
        assertThrows(RuntimeException.class, () -> o.crearEvento(e));
    }

    @Test
    void testEliminarEventoInexistenteLanzaExcepcion() {
        Organizador o = new Organizador("Org", 1, "mail@o.com");
        Evento e = new Evento("Ev", new Ubicacion("Dir", "Presencial"), o, new Categoria("Cat"),
                java.time.LocalDate.now(), 2);
        assertThrows(RuntimeException.class, () -> o.eliminarEvento(e));
    }
}
