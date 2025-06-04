package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Organizador {
    private String nombre;
    private int telefono;
    private String email;
    private Map<String, Evento> mapaEventos;

    public Organizador(String nombre, int telefono, String email) {
        if (!esCorreoValido(email)) {
            throw new IllegalArgumentException("Correo electrónico inválido: " + email);
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.mapaEventos = new HashMap<>();
    }

    private boolean esCorreoValido(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public void crearEvento(Evento evento) {
        if (!mapaEventos.containsKey(evento.getNombre())) {
            mapaEventos.put(evento.getNombre(), evento);
        } else {
            throw new RuntimeException("El evento ya existe");
        }
    }

    public void eliminarEvento(Evento evento) {
        if (mapaEventos.containsKey(evento.getNombre())) {
            mapaEventos.remove(evento.getNombre());
        } else {
            throw new RuntimeException("El evento no existe, no se puede borrar");
        }
    }

    public boolean modificarNombreEvento(Evento e, String nombreNuevo) {
        if (mapaEventos.containsKey(e.getNombre())) {
            String nombreViejo = e.getNombre();
            Evento evento = mapaEventos.get(nombreViejo);
            evento.setNombre(nombreNuevo);
            mapaEventos.remove(nombreViejo);
            mapaEventos.put(nombreNuevo, evento);
            return true;
        } else {
            throw new RuntimeException("El evento no existe, no se puede modificar");
        }
    }

    public boolean modificarFechaEvento(Evento e, LocalDate nuevaFecha) {
        if (mapaEventos.containsKey(e.getNombre())) {
            Evento evento = mapaEventos.get(e.getNombre());
            evento.setFecha(nuevaFecha);
            return true;
        } else {
            throw new RuntimeException("El evento no existe, no se puede modificar");
        }
    }

    public boolean modificarUbicacionEvento(Evento e, Ubicacion nuevaUbicacion) {
        if (mapaEventos.containsKey(e.getNombre())) {
            Evento evento = mapaEventos.get(e.getNombre());
            evento.setUbicacion(nuevaUbicacion);
            return true;
        } else {
            throw new RuntimeException("El evento no existe, no se puede modificar");
        }
    }

    public void mostrarEventos() {
        if (!mapaEventos.isEmpty()) {
            for (Evento e : mapaEventos.values()) {
                System.out.println(e);
            }
        } else {
            throw new RuntimeException("Este organizador no tiene eventos");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, Evento> getMapaEventos() {
        return this.mapaEventos;
    }

    public void setMapaEventos(Map<String, Evento> mapaEventos) {
        this.mapaEventos = mapaEventos;
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", telefono='" + getTelefono() + "'" +
                ", email='" + getEmail() + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Organizador that = (Organizador) o;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

}
