package Extiende_Figura_Modificado;

public class Cilindro implements FiguraAbstracta {

    private double radio;
    private double altura;
    private Circulo circulo;
    private final double PI = Math.PI;

    public Cilindro(double radio, double altura, Circulo circulo) {
        this.radio = radio;
        this.altura = altura;
        this.circulo = circulo;
    }

    @Override
    public double area() {
        return 2 * PI * Math.pow(radio, 2) + 2 * PI * radio * altura;
    }

    @Override
    public double perimetro() {
        return 2 * PI * radio;
    }

    public double volumen() {
        return PI * Math.round((Math.pow(radio, 2) * altura) * 100.0) / 100.0;
    }
}
