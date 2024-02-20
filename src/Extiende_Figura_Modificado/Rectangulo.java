package Extiende_Figura_Modificado;

public class Rectangulo extends Figura implements FiguraAbstracta, Printable {

    private final double base;
    private final double altura;
    private static final String NOMBRE = "Circulo";

    //TODO en todas las clases repetimos el nombre, para el super y para el toString:
    // private static final String NOMBRE = "Rectángulo";

    public Rectangulo(double base, double altura) {
        super(NOMBRE);
        this.base = base;
        this.altura = altura;
    }

    /**
     * Method implementation to calculate the area
     */
    public double area() {
        return this.base * this.altura;
    }

    public double perimetro() {
        return (2 * base) + (2 * altura);
    }


    /**
     * Returns a representative string of the square.
     */
    @Override
    public String toString() {
        return "Rectangulo{" +
                "base=" + base +
                ", altura=" + altura +
                ", area=" + area() +
                '}';
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public void print() {
        for (int i = 0; i < altura; i++) {

            for (int j = 0; j < base; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
