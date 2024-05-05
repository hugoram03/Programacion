package Juegos;

import Juegos.Ahorcado.AhorcadoGame;
import Juegos.Ahorcado.Jugador;
import Juegos.Bingo.BingoGame;
import Juegos.Bingo.Carton;
import Juegos.Bingo.JugadorBingo;
import Juegos.MultiplicationGame.MultiplicationGame;
import Juegos.MultiplicationGame.ThreePlayers;
import Juegos.MultiplicationGame.TwoPlayers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static MultiplicationGame multiplicationGame = new MultiplicationGame();
    static AhorcadoGame ahorcadoGame = new AhorcadoGame();
    static BingoGame bingoGame = new BingoGame();
    static Carton carton = new Carton();
    static boolean ganador = false;
    static ArrayList<JugadorBingo> listaJugadoresBingo = new ArrayList<>();

    public static void main(String[] args) {

        System.out.print("Juegos: \n1- MultiplicationGame \n2- Ahorcado \n3- Bingo \nOpcion: ");
        String opcionJuego = lector.nextLine();

        System.out.print("\nCuantos jugadores van a jugar (2 o 3): ");
        System.out.println("\nSi vas a cargar una partida guardada y no quieres añadir a nadie mas pulsa '0'");
        int numJugadores = lector.nextInt();

        menu(numJugadores, opcionJuego);
        lector.close();
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
                lector.nextLine();
                System.out.println("Quieres cargar una partida ya guardada anteriormente (si/no)");
                String opcion = lector.nextLine();
                if (opcion.equalsIgnoreCase("si")) {
                    do {
                        System.out.println("Numero de posicion que ha sido guardada tu partida (1-10)");
                        opcion = lector.nextLine();
                    } while (Integer.parseInt(opcion) > 10 || Integer.parseInt(opcion) < 1);
                    cargarPartida(opcion);
                }
                cargarListaJugadores(numJugadores);
                bingo(listaJugadoresBingo);
                break;
            default:
                System.out.println("Juego incorrecto o no disponible");
                break;
        }
    }

    private static void cargarListaJugadores(int numJugadores) {
        for (int i = 1; i <= numJugadores; i++) {
            System.out.println("Pulse 'Enter' para añadir la informacion del jugador " + i);
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
                listaJugadoresBingo.add(jugador);
            }
            if (listaJugadoresBingo.isEmpty()) {
                System.exit(0);
            }
        }
    }

    public static void bingo(ArrayList<JugadorBingo> listaJugadoresBingo) {
        mostrarInfo(listaJugadoresBingo);
        bingoGame.llenarBombo();
        int cont = 0;
        do {
            jugar(listaJugadoresBingo);
            lector.nextLine();
            cont++;
            if (cont % 10 == 0) {
                System.out.println("Llevas " + (cont) + " numeros extraidos quieres guardar la partida? (si/no)");
                String opcion = lector.nextLine();
                if (opcion.equalsIgnoreCase("si")) {
                    do {
                        System.out.println("En que posicion quieres guardar tu partida (1-10)");
                        opcion = lector.nextLine();
                    } while (Integer.parseInt(opcion) > 10 || Integer.parseInt(opcion) < 1);

                    guardarPartida(listaJugadoresBingo, bingoGame.bombo, bingoGame.numerosExtraidos, opcion);
                    System.out.println("Partida guardada con exito");
                    System.exit(0);
                }
            }
        } while (!ganador);
    }

    private static void jugar(ArrayList<JugadorBingo> listaJugadoresBingo) {
        int bola = bingoGame.sacarBola();
        System.out.println("Numero extraido: " + bola);
        for (int i = 0; i < listaJugadoresBingo.size(); i++) {
            System.out.println(listaJugadoresBingo.get(i).getNombre() + ":");
            if (listaJugadoresBingo.get(i).compararNumero(bola)) {
                listaJugadoresBingo.get(i).setContadorNums();
            }
            bingoGame.borrarBola(bola);
            if (listaJugadoresBingo.get(i).getContadorNums() == 15) {
                System.out.println("BINGO GANADOR: " + listaJugadoresBingo.get(i).getNombre() + " Edad: " + listaJugadoresBingo.get(i).getEdad() + " De " + listaJugadoresBingo.get(i).getCiudad());
                ganador = true;
            }
        }
        if (!ganador) {
            System.out.println("Pulse 'enter' para entraer la siguiente bola");
        }
    }

    public static void guardarPartida(ArrayList<JugadorBingo> listaJugadoresBingo, ArrayList<Integer> bombo, ArrayList<Integer> numerosExtraidos, String opcion) {
        File fichero = new File("src/Juegos/Bingo/Partidas/partida" + opcion + ".txt");
        try (PrintWriter printwriter = new PrintWriter(fichero)) {
            for (int i = 0; i < listaJugadoresBingo.size(); i++) {
                JugadorBingo jugador = listaJugadoresBingo.get(i);
                printwriter.println(jugador.getNombre() + "," + jugador.getEdad() + "," + jugador.getCiudad());
                int[][] cartonJugador = jugador.getCartonJugador();
                for (int j = 0; j < cartonJugador.length; j++) {
                    for (int k = 0; k < cartonJugador[j].length; k++) {
                        if (numerosExtraidos.contains(cartonJugador[j][k])) {
                            printwriter.print("(" + cartonJugador[j][k] + "),");
                        } else {
                            printwriter.print(cartonJugador[j][k] + ",");
                        }
                    }
                    printwriter.println();
                }
            }
            for (int numero : bombo) {
                printwriter.print(numero + ",");
            }
            printwriter.println();
            for (int numero : numerosExtraidos) {
                printwriter.print(numero + ",");
            }
            printwriter.println();
        } catch (FileNotFoundException e) {
            System.out.println("Error al guardar la partida.");
        }
    }

    public static void cargarPartida(String opcion) {
        File fichero = new File("src/Juegos/Bingo/Partidas/partida" + opcion + ".txt");
        try (Scanner lector = new Scanner((fichero))) {
            while (lector.hasNextLine()) {
                String[] jugadorInfo = lector.nextLine().split(",");
                if (jugadorInfo.length == 3) {
                    String nombre = jugadorInfo[0];
                    int edad = Integer.parseInt(jugadorInfo[1]);
                    String ciudad = jugadorInfo[2];
                    int[][] carton = new int[3][9];
                    for (int i = 0; i < carton.length; i++) {
                        String[] fila = lector.nextLine().split(",");
                        for (int j = 0; j < fila.length; j++) {
                            carton[i][j] = Integer.parseInt(fila[j]);
                        }
                    }
                    listaJugadoresBingo.add(new JugadorBingo(nombre, edad, ciudad, carton));
                } else if (jugadorInfo.length > 3) {
                    ArrayList<Integer> numeros = new ArrayList<>();
                    for (String numero : jugadorInfo) {
                        if (!numero.isEmpty()) {
                            numeros.add(Integer.parseInt(numero));
                        }
                    }
                    if (bingoGame.bombo.isEmpty()) {
                        bingoGame.bombo = numeros;
                    } else {
                        bingoGame.numerosExtraidos = numeros;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al cargar la partida.");
        }
        fichero.delete();
    }

    public static void mostrarInfo(ArrayList<JugadorBingo> listaJugadoresBingo) {
        for (int i = 0; i < listaJugadoresBingo.size(); i++) {
            System.out.print(listaJugadoresBingo.get(i).getNombre() + ":\n");
            carton.mostrarCarton(listaJugadoresBingo.get(i).getCartonJugador());
            System.out.print("\n--------------------------\n");
        }
        System.out.println("Preparados para jugar al bingo? Los numero que tenga en su carton se pondran entre parentesis: (x) ('Enter para empezar la partida')");
        lector.nextLine();
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