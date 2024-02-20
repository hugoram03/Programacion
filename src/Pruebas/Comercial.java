package Pruebas;

import java.util.Objects;

public class Comercial extends Empleado implements Cloneable{

    private double comision;

    public Comercial(String nombre, String apellido, int edad, double salario, double comision) {
        super(nombre, apellido, edad, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Comercial comercial = (Comercial) o;
        return Double.compare(comision, comercial.comision) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comision);
    }

    @Override
    public String toString() {
        return "Comercial{" + super.toString() +
                "comision=" + comision +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
