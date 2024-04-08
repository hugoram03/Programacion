package Juegos.Ahorcado;

import java.util.Random;
import  java.util.ArrayList;

public class MultiplicationGame {

    private int numero1;
    private int number2;
    private double correctAnswer;

    private static final Random random = new Random();
    public MultiplicationGame() {
        reiniciarNumeros();
    }

    public void reiniciarNumeros() {
        numero1 = otherNumero1();
        number2 = otherNumero2();
        correctAnswer = numero1 * number2;
    }

    public int otherNumero1() {
        return random.nextInt(10)+1;
    }
    public int otherNumero2() {
        return random.nextInt(10)+1;
    }


    @Override
    public String toString() {
        reiniciarNumeros();
        return "Operación: " + numero1 + " * " + number2;
    }

    public boolean validarSolucion(int respuestaUsuario) {
        return respuestaUsuario == correctAnswer;
    }
}




