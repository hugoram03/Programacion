package app.objetos;

public enum Clase {
    MAGA(100),
    GUERRERA(50),
    ESTUDIOSA(0),
    INFORMATICA(75),
    CAZADORA(25);


    private int puntuacion;

    Clase(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
