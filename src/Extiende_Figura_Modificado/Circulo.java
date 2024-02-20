package Extiende_Figura_Modificado;

public class Circulo extends Figura implements FiguraAbstracta {

    private final double PI = Math.PI;
    private final double radio;
    private static final String NOMBRE = "Circulo";
    private Punto punto;

    public Circulo(double radio, Punto punto) {
        super(NOMBRE);
        this.radio = radio;
        this.punto = punto;
    }

    @Override
    public double area() {
        return radio * Math.pow(PI, 2);
    }

    @Override
    public double perimetro() {
        return (2 * PI) * radio;
    }

    @Override
    public String toString() {
        return "Circulo \nRadio= " + radio + "\n Area= " + area();
    }

}
