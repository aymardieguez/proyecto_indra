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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Ubicacion that = (Ubicacion) o;
        return direccion != null ? direccion.equals(that.direccion) : that.direccion == null;
    }

    @Override
    public int hashCode() {
        return direccion != null ? direccion.hashCode() : 0;
    }
}
