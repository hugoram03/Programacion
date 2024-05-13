package Ejercicios_Map.Gestion_Empleados;

import java.util.Objects;

public class Empleado {
    private int id;
    private String nombre;
    private Enum rango;

    public Empleado(int id, String nombre, Enum rango) {
        this.id = id;
        this.nombre = nombre;
        this.rango = rango;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Enum getRango() {
        return rango;
    }

    public void setRango(Enum rango) {
        this.rango = rango;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rango='" + rango + '\'' +
                '}';
    }
}
