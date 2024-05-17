package EjercicioFinal;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Objects;

public class Transaccion implements Comparable<Transaccion>{
    private LocalDate fecha;
    private Tipo tipo;
    private double cantidad;
    private int numCuenta;
    private Collator miCollator;

    public Transaccion(LocalDate fecha, Tipo tipo, double cantidad, int numCuenta) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.numCuenta = numCuenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(int numCuenta) {
        this.numCuenta = numCuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaccion that = (Transaccion) o;
        return Double.compare(cantidad, that.cantidad) == 0 && numCuenta == that.numCuenta && Objects.equals(fecha, that.fecha) && tipo == that.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fecha, tipo, cantidad, numCuenta);
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "fecha=" + fecha +
                ", tipo=" + tipo +
                ", cantidad=" + cantidad +
                ", numCuenta=" + numCuenta +
                '}';
    }

    @Override
    public int compareTo(Transaccion o) {
        return miCollator.compare(this.fecha, o.fecha);
    }
}
