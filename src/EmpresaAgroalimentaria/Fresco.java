package EmpresaAgroalimentaria;

import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

public class Fresco extends Producto implements IUtilidades {
    private Date fechaEnvasado;
    private String paisOrigen;

    public Fresco(String nombreProducto, int stock, double precioKilo, Date fechaCaducidad, int numeroLote, Date fechaEnvasado, String paisOrigen) {
        super(nombreProducto, stock, precioKilo, fechaCaducidad, numeroLote);
        this.fechaEnvasado = fechaEnvasado;
        this.paisOrigen = paisOrigen;
    }

    public Date getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(Date fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fresco fresco = (Fresco) o;
        return Objects.equals(fechaEnvasado, fresco.fechaEnvasado) && Objects.equals(paisOrigen, fresco.paisOrigen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fechaEnvasado, paisOrigen);
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + " Fresco: " + " Fecha de caducidad: " + super.getFechaCaducidad()
                + " Numero de lote" + super.getNumeroLote() + "fechaEnvasado: " + fechaEnvasado + ", paisOrigen: " + paisOrigen;
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
        System.out.print("Pais de origen: ");
        String pais = lector.next();
        o = new Fresco(nombre, stock, precioKilo, null, numeroLote, null, pais);
        return o;
    }
}
