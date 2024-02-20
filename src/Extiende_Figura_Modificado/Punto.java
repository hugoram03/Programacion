package Extiende_Figura_Modificado;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distancia(){
        double distancia = Math.sqrt(Math.pow(x * 2 - x, 2) + Math.pow(y * 2 - y, 2));
        return distancia;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

}
