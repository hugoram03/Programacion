package Empresa_Agroalimentaria_Mod;

import java.time.LocalDate;
import java.util.Objects;

public class Congelado extends Producto{
    private double temperatura;

    public Congelado(LocalDate fechaCad, int numLote, double temperatura) {
        super(fechaCad, numLote);
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Congelado congelado = (Congelado) o;
        return Double.compare(temperatura, congelado.temperatura) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), temperatura);
    }

    @Override
    public String toString() {
        return "Congelado{" +
                "temperatura=" + temperatura +
                '}';
    }
    @Override
    public String obtenerTipo() {
        return "Congelado";
    }
}
