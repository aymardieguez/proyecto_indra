package com.proyectossostenibles;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Evento {
    private String nombre;
    private Ubicacion ubicacion;
    private Organizador organizador;
    private String categoria;
    private LocalDate fecha;
    private int duracion;
    private Map<String, Usuario> mapaUsuarios;

    public Evento(String nombre, Ubicacion ubicacion, Organizador organizador, String categoria, LocalDate fecha,
            int duracion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.organizador = organizador;
        this.categoria = categoria;
        this.fecha = fecha;
        this.duracion = duracion;
        this.mapaUsuarios = new HashMap<>();
    }

    public void inscribirUsuario(Usuario usuario) {
        if (!mapaUsuarios.containsKey(usuario.getNombre())) {
            mapaUsuarios.put(usuario.getNombre(), usuario);
            usuario.getMapaEventos().put(this.nombre,
                    this);
        } else {
            throw new RuntimeException("El usuario ya está inscrito en el evento");
        }
    }

    public void desinscribirUsuario(Usuario usuario) {
        if (mapaUsuarios.containsKey(usuario.getNombre())) {
            mapaUsuarios.remove(usuario.getNombre());
            usuario.getMapaEventos().remove(this.nombre);

        } else {
            throw new RuntimeException("El usuario no existe en este evento");
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

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
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

}
