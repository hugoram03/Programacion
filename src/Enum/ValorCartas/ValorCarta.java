package Enum.ValorCartas;

public enum ValorCarta {
    A(1),
    DOS(2),
    TRES(3),
    CUATRO(4),
    CINCO(5),
    SEIS(6),
    SIETE(7),
    OCHO(8),
    NUEVE(9),
    DIEZ(10),
    J(10),
    Q(11),
    K(12);
    private final int PUNTOS;

    ValorCarta(int PUNTOS) {
        this.PUNTOS = PUNTOS;
    }

    public int getPUNTOS() {
        return PUNTOS;
    }

    public int obtenerPuntos() {
        return this.getPUNTOS();
    }
}