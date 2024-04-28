package Juegos;

import Juegos.Ahorcado.AhorcadoGame;
import Juegos.Ahorcado.Jugador;
import Juegos.Bingo.BingoGame;
import Juegos.Bingo.Carton;
import Juegos.Bingo.JugadorBingo;
import Juegos.MultiplicationGame.MultiplicationGame;
import Juegos.MultiplicationGame.ThreePlayers;
import Juegos.MultiplicationGame.TwoPlayers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static MultiplicationGame multiplicationGame = new MultiplicationGame();
    static AhorcadoGame ahorcadoGame = new AhorcadoGame();
    static BingoGame bingoGame = new BingoGame();
    static Carton carton = new Carton();

    public static void main(String[] args) {

        System.out.print("Juegos: \n1- MultiplicationGame \n2- Ahorcado \n3- Bingo \nOpcion: ");
        String opcionJuego = lector.nextLine();

        System.out.print("\nCuantos jugadores van a jugar (2 o 3): ");
        int numJugadores = lector.nextInt();

        menu(numJugadores, opcionJuego);

    }

    public static void menu(int numJugadores, String opcionJuego) {
        ArrayList<Jugador> listaJugadores = numJugadores(numJugadores);

        switch (opcionJuego) {
            case "1":
                multiplicationGame(listaJugadores);
                break;
            case "2":
                ahorcado(listaJugadores);
                break;
            case "3":
                bingo(numJugadores);
                break;
            default:
                System.out.println("Juego incorrecto o no disponible");
                break;
        }
    }

    public static void bingo(int numJugadores) {
        for (int i = 1; i <= numJugadores; i++) {
            System.out.println("Añade tu informacion jugador " + i);
            lector.nextLine();
            System.out.print("Nombre: ");
            String nombre = lector.nextLine();
            System.out.print("Edad: ");
            int edad = lector.nextInt();
            System.out.print("Ciudad: ");
            lector.nextLine();
            String ciudad = lector.nextLine();
            if (edad < 18) {
                System.out.println("Lo siento " + nombre + " no puedes jugar al bingo por que eres menor de edad");
            } else {
                JugadorBingo jugador = new JugadorBingo(nombre, edad, ciudad, carton.getCarton());
                bingoGame.anadirjugador(jugador);
            }
        }
    }

    public static ArrayList<Jugador> numJugadores(int numJugadores) {
        if (numJugadores == 2) {
            TwoPlayers dosJugadores = new TwoPlayers();
            return dosJugadores.getAllPlayers();
        } else if (numJugadores == 3) {
            ThreePlayers tresJugadores = new ThreePlayers();
            return tresJugadores.getAllPlayers();
        } else {
            return null;
        }
    }

    public static void multiplicationGame(ArrayList<Jugador> listaJugadores) {
        do {
            for (int i = 0; i < listaJugadores.size(); i++) {
                System.out.print("Turno de " + listaJugadores.get(i).getNombre() + ": |" + multiplicationGame.toString() + ": ");
                int respuesta = lector.nextInt();

                lector.nextLine();


                if (multiplicationGame.validarSolucion(respuesta)) {
                    System.out.println("Respuesta correcta, puedes seguir \n");
                } else {
                    System.out.println("Respuesta incorrecta, ha perdido su turno durante el juego ");
                    listaJugadores.remove(i);
                    break;
                }
            }
        } while (listaJugadores.size() > 1);
        System.out.println("\n El ganador es: " + listaJugadores.get(0).getNombre());
    }

    public static void ahorcado(ArrayList<Jugador> listaJugadores) {

        final String palabra = ahorcadoGame.mostrarIncognita();
        System.out.println(ahorcadoGame.toString());
        ArrayList<Character> letrasIntroducidas = new ArrayList<>();

        int rondas = 12;

        while (rondas > 0) {

            for (int i = 0; i < listaJugadores.size(); i++) {
                System.out.print("\nTurno de " + listaJugadores.get(i).getNombre() + ", introduce una letra: ");
                char letraCharacter = lector.next().charAt(0);

                if (!verificarCaracter(letraCharacter, rondas)) {
                    rondas--;
                }
                if (rondas == 6) {
                    System.out.println("La palabra oculta es de tipo: " + ahorcadoGame.mostrarTipo());
                }
                if (ahorcadoGame.ganador()) {
                    System.out.println("Enhorabuena, el " + listaJugadores.get(i).getNombre() + " es el ganador del ahorcado");
                    return;
                }
            }
        }
        System.out.println("La palabra a adivinar era: " + ahorcadoGame.mostrarIncognita());
    }

    public static boolean verificarCaracter(char letraCharacter, int fallos) {
        if (ahorcadoGame.verificarLetra(letraCharacter)) {
            System.out.println("Se ha encontrado la letra (" + letraCharacter + "): " + ahorcadoGame.PalabraOcultaTXT());
            return true;
        } else {
            System.out.println("Te has equivocado, no se ha encontrado la letra (" + letraCharacter + "): " + ahorcadoGame.PalabraOcultaTXT() + "\nNúmero de intentos: " + (fallos - 1));
            return false;
        }
    }
}