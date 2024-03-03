package EmpresaAgroalimentaria;

import java.util.ArrayList;
import java.util.Objects;

public class Almacen implements Cloneable{

    private String nombreProducto;
    private int stock;
    private double precioKilo;

    public Almacen(String nombreProducto, int stock, double precioKilo) {
        this.nombreProducto = nombreProducto;
        if (stock <= 0){
            stock = 1;
        }
        this.stock = stock;
        if (precioKilo <= 0){
            precioKilo = 1;
        }
        this.precioKilo = precioKilo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioKilo() {
        return precioKilo;
    }

    public void setPrecioKilo(double precioKilo) {
        this.precioKilo = precioKilo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Almacen almacen = (Almacen) o;
        return stock == almacen.stock && Double.compare(precioKilo, almacen.precioKilo) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock, precioKilo);
    }

    @Override
    public String toString() {
        return "Almacen{" + " stock=" + stock +
                ", precioKilo=" + precioKilo +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
