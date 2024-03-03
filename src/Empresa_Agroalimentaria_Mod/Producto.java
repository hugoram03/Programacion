package Empresa_Agroalimentaria_Mod;
import java.time.LocalDate;
import java.util.Objects;

public class Producto implements IUtilidades{
    private LocalDate fechaCad;

    private int numLote;

    public Producto(LocalDate fechaCad, int numLote) {
        this.fechaCad = fechaCad;
        this.numLote = numLote;
    }

    public LocalDate getFechaCad() {
        return fechaCad;
    }

    public void setFechaCad(LocalDate fechaCad) {
        this.fechaCad = fechaCad;
    }

    public int getNumLote() {
        return numLote;
    }

    public void setNumLote(int numLote) {
        this.numLote = numLote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return numLote == producto.numLote && Objects.equals(fechaCad, producto.fechaCad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaCad, numLote);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "fechaCad=" + fechaCad +
                ", numLote=" + numLote +
                '}';
    }

}
