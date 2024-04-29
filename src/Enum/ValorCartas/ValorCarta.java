package Enum.ValorCartas;

public enum ValorCarta {
    A,
    UNO,
    DOS,
    TRES,
    CUATRO,
    CINCO,
    SEIS,
    SIETE,
    OCHO,
    NUEVE,
    DIEZ,
    J,
    Q,
    K;

    public int obtenerPuntos(){
        int puntos = 0;
        if (this.equals(ValorCarta.UNO)){
            puntos = 1;
        } else if (this.equals(ValorCarta.DOS)){
            puntos = 2;
        } else if (this.equals(ValorCarta.TRES)){
            puntos = 3;
        } else if (this.equals(ValorCarta.CUATRO)) {
            puntos = 4;
        } else if (this.equals(ValorCarta.CINCO)){
            puntos = 5;
        } else if (this.equals(ValorCarta.SEIS)){
            puntos = 6;
        } else if (this.equals(ValorCarta.SIETE)){
            puntos = 7;
        } else if (this.equals(ValorCarta.OCHO)){
            puntos = 8;
        } else if (this.equals(ValorCarta.NUEVE)){
            puntos = 9;
        } else if (this.equals(ValorCarta.DIEZ)){
            puntos = 10;
        } else if (this.equals(ValorCarta.J)){
            puntos = 10;
        } else if (this.equals(ValorCarta.Q)){
            puntos = 10;
        } else if (this.equals(ValorCarta.K)){
            puntos = 10;
        }
        return puntos;
    }

}
