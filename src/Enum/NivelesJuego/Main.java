package Enum.NivelesJuego;

import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        EstadoJuego estadoJuego = EstadoJuego.PAUSADO;
        NivelJuego nivelJuego = NivelJuego.AVANZADO;

        System.out.println(nivelJuego.esAvanzado() ? "El juego esta en dificultad avanzada" : "El juego no esta en dificultad avanzada");
        estadoJuego.mostrarEstado();
    }
}
