package EmpresaAgroalimentaria;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Congelado extends Producto implements Cloneable, IUtilidades {
    private int temperaturaCongelacion;

    public Congelado(String nombreProducto, int stock, double precioKilo, Date fechaCaducidad, int numeroLote, int temperaturaCongelacion) {
        super(nombreProducto, stock, precioKilo, fechaCaducidad, numeroLote);
        this.temperaturaCongelacion = temperaturaCongelacion;
    }

    public int getTemperaturaCongelacion() {
        return temperaturaCongelacion;
    }

    public void setTemperaturaCongelacion(int temperaturaCongelacion) {
        this.temperaturaCongelacion = temperaturaCongelacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Congelado congelado = (Congelado) o;
        return temperaturaCongelacion == congelado.temperaturaCongelacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), temperaturaCongelacion);
    }

    @Override
    public String toString() {
        return "Fresco: " + " Fecha de caducidad: " + super.getFechaCaducidad()
                + " Numero de lote " + super.getNumeroLote() + " Temperatura de Congelacion recomendada: " + temperaturaCongelacion;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int sumaStock(int stock) {
        return IUtilidades.super.sumaStock(stock);
    }

    @Override
    public Object completarDatos(Scanner lector, Object o) {
        System.out.print("Nombre del producto: ");
        String nombre = lector.next();
        System.out.print("Numero de stock: ");
        int stock = lector.nextInt();
        if (sumaStock(stock) > 1000){
            stock = 1000;
        }
        System.out.print("Precio por kilo: ");
        double precioKilo = lector.nextDouble();
        System.out.print("Numero de lote: ");
        int numeroLote = lector.nextInt();
        System.out.print("Temperatura recomendada de congelacion: ");
        int tempCongelacion = lector.nextInt();
        o = new Congelado(nombre, stock, precioKilo, null, numeroLote, tempCongelacion);
        return o;
    }
}
