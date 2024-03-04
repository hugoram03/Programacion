package Empresa_Agroalimentaria_Mod;

import java.time.LocalDate;
import java.util.Objects;

public class Fresco extends Producto {
    private LocalDate fechaEnvasado;
    private String pais;

    public Fresco(LocalDate fechaCad, int numLote, LocalDate fechaEnvasado, String pais) {
        super(fechaCad, numLote);
        this.fechaEnvasado = fechaEnvasado;
        this.pais = pais;
    }

    public LocalDate getFechaEnvasado() {
        return fechaEnvasado;
    }

    public void setFechaEnvasado(LocalDate fechaEnvasado) {
        this.fechaEnvasado = fechaEnvasado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fresco fresco = (Fresco) o;
        return Objects.equals(fechaEnvasado, fresco.fechaEnvasado) && Objects.equals(pais, fresco.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaEnvasado, pais);
    }

    @Override
    public String toString() {
        return "Fresco{" +
                "fechaEnvasado=" + fechaEnvasado +
                ", pais='" + pais + '\'' +
                '}';
    }
    @Override
    public String obtenerTipo() {
        return "Fresco";
    }
}

