package com.proyectossostenibles;

import java.util.HashMap;
import java.util.Map;

public class Portal {
    private Map<String, Evento> mapaEventos = new HashMap<>();
    private Map<String, Usuario> mapaUsuarios = new HashMap<>();
    private Map<String, Organizador> mapaOrganizadores = new HashMap<>();

    public Map<String, Evento> getMapaEventos() {
        return this.mapaEventos;
    }

    public void setMapaEventos(Map<String, Evento> mapaEventos) {
        this.mapaEventos = mapaEventos;
    }

    public Map<String, Usuario> getMapaUsuarios() {
        return this.mapaUsuarios;
    }

    public void setMapaUsuarios(Map<String, Usuario> mapaUsuarios) {
        this.mapaUsuarios = mapaUsuarios;
    }

    public Map<String, Organizador> getMapaOrganizadores() {
        return this.mapaOrganizadores;
    }

    public void setMapaOrganizadores(Map<String, Organizador> mapaOrganizadores) {
        this.mapaOrganizadores = mapaOrganizadores;
    }

}
