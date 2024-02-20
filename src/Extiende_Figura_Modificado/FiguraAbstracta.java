package Extiende_Figura_Modificado;

public interface FiguraAbstracta {

    static public boolean mayorQue(FiguraAbstracta otra, FiguraAbstracta una) {
        return una.area() > otra.area();
    }

    abstract public double area();

    abstract public double perimetro();

    // TODO este método no tiene sentido si no lo implementas. Siempre vamos a poder seguir heredandolo en sus clases
    //  hijas.
    public String toString();

}
