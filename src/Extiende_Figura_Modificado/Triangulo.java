package Extiende_Figura_Modificado;

import java.util.Scanner;

public class Triangulo extends Figura implements FiguraAbstracta, Printable{

    private final double BASE;
    private final double ALTURA;
    private static final String NOMBRE = "Triangulo";

    public Triangulo(double BASE, double ALTURA) {
        super(NOMBRE);
        this.BASE = BASE;
        this.ALTURA = ALTURA;
    }

    @Override
    public double area() {
        return (BASE * ALTURA)/2;
    }

    @Override
    public double perimetro() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce un lado del triangulo:");
        double lado = lector.nextDouble();
        if (lado == BASE || lado == ALTURA){
            return (lado * lado) + BASE;
        } else if (BASE == ALTURA){
            return BASE * 3;
        } else {
            return lado + BASE + ALTURA;
        }
    }

    @Override
    public String toString() {
        return "Triangulo{" +
                "base=" + BASE +
                ", altura=" + ALTURA +
                ", area=" + area() +
                '}';
    }

    @Override
    public void print() {
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
