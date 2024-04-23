package Extiende_Figura_Modificado;

import java.util.Comparator;

public class Figura implements Comparator<Figura>, FiguraAbstracta{
    private String nombre;

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public double area() {
        return 0;
    }

    @Override
    public double perimetro() {
        return 0;
    }

    @Override
    public int compare(Figura o1, Figura o2) {
        return Double.compare(o1.area(), o2.area());
    }
}
