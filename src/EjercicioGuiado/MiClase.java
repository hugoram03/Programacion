package EjercicioGuiado;

import java.util.Objects;

public class MiClase {
    private int num;
    private String texto;

    public MiClase(int num, String texto) {
        this.num = num;
        this.texto = texto;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiClase miClase = (MiClase) o;
        return num == miClase.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return "MiClase{" +
                "num=" + num +
                ", texto='" + texto + '\'' +
                '}'+"\n";
    }
}
