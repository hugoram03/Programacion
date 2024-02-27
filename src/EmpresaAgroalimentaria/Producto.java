package EmpresaAgroalimentaria;

import java.util.Date;
import java.util.Objects;

public class Producto extends Almacen implements Cloneable{
    private Date fechaCaducidad;
    private int numeroLote;

    public Producto(String nombreProducto, int stock, double precioKilo, Date fechaCaducidad, int numeroLote) {
        super(nombreProducto, stock, precioKilo);
        this.fechaCaducidad = fechaCaducidad;
        this.numeroLote = numeroLote;
    }

    public Date getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(Date fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public int getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(int numeroLote) {
        this.numeroLote = numeroLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return numeroLote == producto.numeroLote;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroLote);
    }

    @Override
    public String toString() {
        return "Producto:" + "fechaCaducidad: " + fechaCaducidad + ", numeroLote: " + numeroLote;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
