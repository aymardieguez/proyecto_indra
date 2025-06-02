package com.proyectossostenibles;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String nombre;
    private String email;
    private String contraseña;
    private Map<String, Evento> mapaEventos;

    public Usuario(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.mapaEventos = new HashMap<>();
    }

    public void inscribirAEvento(Evento e) {
        String nombreYFecha = e.getNombre() + "_" + e.getFecha().toString();
        if (mapaEventos.containsKey(nombreYFecha)) {
            throw new RuntimeException("Ya estás inscrito a este evento en esa fecha o no existe.");
        } else {
            mapaEventos.put(nombreYFecha, e);
            e.getMapaUsuarios().put(this.nombre, this); // Añadimos el usuario al mapa de usuarios del evento
        }
    }

    public void desinscribirDeEvento(Evento e) {
        String nombreYFecha = e.getNombre() + "_" + e.getFecha().toString();
        if (mapaEventos.containsKey(nombreYFecha)) {
            mapaEventos.remove(nombreYFecha);
            e.getMapaUsuarios().remove(this.nombre); // Eliminamos el usuario del mapa de usuarios del evento
        } else {
            throw new RuntimeException("No estás inscrito a ese evento en esa fecha o no existe.");
        }
    }

    public void mostrarEventos() {
        if (!mapaEventos.isEmpty()) {
            for (Evento e : mapaEventos.values()) {
                System.out.println(e);
            }
        } else {
            throw new RuntimeException("Este usuario no está inscrito a ningún evento o no existe.");
        }

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
                ", email='" + getEmail() + "'" +
                ", contraseña='" + getContraseña() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return email != null ? email.equals(usuario.email) : usuario.email == null;
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

}
