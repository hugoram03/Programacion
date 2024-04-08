package Juegos.Ahorcado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);
    static final MultiplicationGame multiplicationGame = new MultiplicationGame();
    static final AhorcadoGame ahorcadoGame = new AhorcadoGame();

    public static void main(String[] args) {

        System.out.print("Juegos disponibles: \n(1) MultiplicationGame \n(2) Ahorcado \n\nA que videojuego desea jugar: ");
        String opcionJuego = sc.nextLine();

        System.out.print("\nCuantos jugadores van a jugar (2) o (3): ");
        int numJugadores = sc.nextInt();

        menu(numJugadores, opcionJuego);

    }

    //menu para seleccionar el juego
    public static void menu(int numJugadores, String opcionJuego) {
        ArrayList<Player> listaJugadores = numJugadores(numJugadores);

        switch (opcionJuego) {
            case "1":
                multiplicationGame(listaJugadores);
                break;
            case "2":
                ahorcado(listaJugadores);
                break;
            default:
                System.out.println("Juego incorrecto o no disponible");
                break;
        }
    }

    //Método que devuelve un arrayList con los jugadores elegidos
    private static ArrayList<Player> numJugadores(int numJugadores) {
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

    public static void multiplicationGame(ArrayList<Player> listaJugadores) {
        do {
            for (int i = 0; i < listaJugadores.size(); i++) {
                System.out.print("Turno de " + listaJugadores.get(i).getNombre() + ": |" + multiplicationGame.toString() + ": ");
                int respuesta = sc.nextInt();

                sc.nextLine();

                //Validación de la respuesta
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

    //NOTA: Se que el metodo es bastante largo, he querido hacer un metodo por juego, intentare meter cosas en la clase AhorcadoGame;
    public static void ahorcado(ArrayList<Player> listaJugadores) {

        final String palabra = ahorcadoGame.mostrarIncognita();
        System.out.println(ahorcadoGame.toString());
        ArrayList<Character> letrasIntroducidas = new ArrayList<>();

        int fallos = 12;

        while (fallos > 0) {

            for (int i = 0; i < listaJugadores.size(); i++) {
                System.out.print("\nTurno de " + listaJugadores.get(i).getNombre() + ", introduzca una letra: ");
                char letraCharacter = sc.next().charAt(0);

                if(verificarCosas(letraCharacter, fallos) == Boolean.FALSE) {
                    fallos--;
                }

                if (ahorcadoGame.ganador()) {
                    System.out.println("Bien hecho, " + listaJugadores.get(i).getNombre() + "es el ganador del ahoorcado");
                    return;
                }
            }
            if (fallos == 6) {
                System.out.println("La palabra oculta es de tipo: "+ ahorcadoGame.mostrarTipo());
            }
        }
    }

    public static boolean verificarCosas(char letraCharacter, int fallos) {
        if (ahorcadoGame.verificarLetra(letraCharacter)) {
            System.out.println("Bien hecho, se ha encontrado la letra (" + letraCharacter + "): " + ahorcadoGame.cambios());
            return true;
        } else {
            System.out.println("Te has equivocado, no se ha encontrado la letra (" + letraCharacter + "): " + ahorcadoGame.cambios() + "\nNúmero de intentos: " + (fallos-1));
            return false;
        }
    }

}





