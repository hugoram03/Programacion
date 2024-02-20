package Extiende_Figura_Modificado;

public class Caja extends Rectangulo implements FiguraAbstracta, Printable{

    public double ancho;
    public Caja(double base, double altura, double ancho) {
        super(base, altura);
        this.ancho = ancho;
        setNombre("Caja");
    }
    @Override
    public double area() {
        return super.area() * ancho;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }
    @Override
    public void print() {
        super.print();
    }
}
