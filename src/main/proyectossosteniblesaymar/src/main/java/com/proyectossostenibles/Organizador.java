package com.proyectossostenibles;

import java.util.HashMap;
import java.util.Map;

public class Organizador {
    private String nombre;
    private int telefono;
    private String email;
    private Map<String, Evento> mapaEventos;

    public Organizador(String nombre, int telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.mapaEventos = new HashMap<>();
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

    public void mostrarEventos() {
        if (!mapaEventos.isEmpty()) {
            for (String e : mapaEventos.keySet()) {
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
