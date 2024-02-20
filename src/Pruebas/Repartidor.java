package Pruebas;

import java.util.Objects;

public class Repartidor extends Empleado implements Cloneable{
    private int id;

    public Repartidor(String nombre, String apellido, int edad, double salario, int id) {
        super(nombre, apellido, edad, salario);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  super.toString() + "id=" + id + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Repartidor that = (Repartidor) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
