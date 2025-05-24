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

}
