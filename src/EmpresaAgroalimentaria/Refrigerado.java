package EmpresaAgroalimentaria;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Refrigerado extends Producto implements Cloneable, IUtilidades{
    private int codigo;

    public Refrigerado(String nombreProducto, int stock, double precioKilo, Date fechaCaducidad, int numeroLote, int codigo) {
        super(nombreProducto, stock, precioKilo, fechaCaducidad, numeroLote);
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerado that = (Refrigerado) o;
        return codigo == that.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigo);
    }

    @Override
    public String toString() {
        return  "Refrigerado: " + " Fecha de caducidad: " + super.getFechaCaducidad()
                + " Numero de lote " + super.getNumeroLote() + " Codigo: " + codigo;
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
        System.out.println("Codigo del producto:");
        int codigo = lector.nextInt();
        o = new Refrigerado(nombre, stock, precioKilo, null, numeroLote, codigo);
        return o;
    }
}