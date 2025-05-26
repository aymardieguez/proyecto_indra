package com.proyectossostenibles;

public class Categoria implements Comparable<Categoria> {
    private String nombre;

    public Categoria(String nombre) {
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Categoria that = (Categoria) o;
        return nombre != null ? nombre.equals(that.nombre) : that.nombre == null;
    }

    @Override
    public int hashCode() {
        return nombre != null ? nombre.hashCode() : 0;
    }

    @Override
    public int compareTo(Categoria o) {
        if (this.nombre == null && o.nombre == null)
            return 0;
        if (this.nombre == null)
            return -1;
        if (o.nombre == null)
            return 1;
        return this.nombre.compareToIgnoreCase(o.nombre);
    }
}
