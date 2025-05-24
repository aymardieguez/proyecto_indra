package com.proyectossostenibles;

public class Ubicacion {
    private String direccion;
    private String tipo;

    public Ubicacion(String direccion, String tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "{" +
                " direccion='" + getDireccion() + "'" +
                ", tipo='" + getTipo() + "'" +
                "}";
    }

}
