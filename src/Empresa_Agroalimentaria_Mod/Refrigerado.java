package Empresa_Agroalimentaria_Mod;

import java.time.LocalDate;
import java.util.Objects;

public class Refrigerado extends Producto implements IUtilidades{
    private String codOrg;

    public Refrigerado(LocalDate fechaCad, int numLote, String codOrg) {
        super(fechaCad, numLote);
        this.codOrg = codOrg;
    }

    public String getCodOrg() {
        return codOrg;
    }

    public void setCodOrg(String codOrg) {
        this.codOrg = codOrg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Refrigerado that = (Refrigerado) o;
        return Objects.equals(codOrg, that.codOrg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codOrg);
    }

    @Override
    public String toString() {
        return "Refrigerado{" +
                "codOrg='" + codOrg + '\'' +
                '}';
    }

    @Override
    public String obtenerTipo() {
        return "Refrigerado";
    }
}
