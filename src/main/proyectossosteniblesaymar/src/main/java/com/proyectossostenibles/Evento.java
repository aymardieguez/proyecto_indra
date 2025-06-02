package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Evento {
    private String nombre;
    private Ubicacion ubicacion;
    private Organizador organizador;
    private Categoria categoria;
    private LocalDate fecha;
    private int duracion;
    private Map<String, Usuario> mapaUsuarios;

    public Evento(String nombre, Ubicacion ubicacion, Organizador organizador, Categoria categoria, LocalDate fecha,
            int duracion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.organizador = organizador;
        this.categoria = categoria;
        this.fecha = fecha;
        this.duracion = duracion;
        this.mapaUsuarios = new HashMap<>();
    }

    public Evento(String nombre, LocalDate fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public void mostrarUsuariosInscritos() {
        if (!mapaUsuarios.isEmpty()) {
            for (Usuario u : mapaUsuarios.values()) {
                System.out.println(u);
            }
        } else {
            throw new RuntimeException("Mapa de usuarios vacía o proyecto inexistente");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Organizador getOrganizador() {
        return this.organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Map<String, Usuario> getMapaUsuarios() {
        return this.mapaUsuarios;
    }

    public void setMapaUsuarios(Map<String, Usuario> mapaUsuarios) {
        this.mapaUsuarios = mapaUsuarios;
    }

    @Override
    public String toString() {
        return "{" +
                " nombre='" + getNombre() + "'" +
                ", ubicacion='" + getUbicacion() + "'" +
                ", organizador='" + getOrganizador() + "'" +
                ", categoria='" + getCategoria() + "'" +
                ", fecha='" + getFecha() + "'" +
                ", duracion='" + getDuracion() + "'" +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Evento evento = (Evento) o;
        return nombre != null ? nombre.equals(evento.nombre) : evento.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }
}
