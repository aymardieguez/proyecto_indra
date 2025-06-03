package com.proyectossostenibles;

import java.util.HashMap;
import java.util.Map;

public class Usuario {
    private String email;
    private String nombre;
    private String contraseña;
    private Map<String, Evento> mapaEventos;

    public Usuario(String email, String nombre, String contraseña) {
        if (!esCorreoValido(email)) {
            throw new IllegalArgumentException("Correo electrónico inválido: " + email);
        }
        this.email = email;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.mapaEventos = new HashMap<>();
    }

    private boolean esCorreoValido(String email) {
        return email != null && email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public void inscribirAEvento(Evento e) {
        if (mapaEventos.containsKey(e.getNombre())) {
            throw new RuntimeException("Ya estás inscrito a este evento o no existe.");
        } else {
            mapaEventos.put(e.getNombre(), e);
            e.getMapaUsuarios().put(this.email, this); // Añadimos el usuario al mapa de usuarios del evento
        }
    }

    public void desinscribirDeEvento(Evento e) {
        if (mapaEventos.containsKey(e.getNombre())) {
            mapaEventos.remove(e.getNombre());
            e.getMapaUsuarios().remove(this.email); // Eliminamos el usuario del mapa de usuarios del evento
        } else {
            throw new RuntimeException("No estás inscrito a ese evento o no existe.");
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
                " email='" + getEmail() + "'" +
                ", nombre='" + getNombre() + "'" +
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
