package EjercicioFinalLeyenda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Logger LOGGER = LogManager.getRootLogger();
    private static File PARTIDA = new File("src/EjercicioFinalLeyenda/Ficheros/partida.dat");
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Leyenda ly = new Leyenda();

        boolean exit;
        boolean repeat;
        do {
            exit = false;
            System.out.println("\nLa leyenda\n" +
                    "\t1: Jugar\n" +
                    "\t2: Cargar partida\n" +
                    "\t3: Mostrar armas\n" +
                    "\t4: Mostrar roles\n" +
                    "\t5: Mostrar intrucciones\n" +
                    "\t6: Salir\n");
            do {
                repeat = false;
                String opcion = sc.nextLine();

                switch (opcion) {
                    case "1":
                        System.out.println("Has seleccionado jugar.");
                        ly.jugar(Boolean.FALSE);
                        break;
                    case "2":
                        System.out.println("Has seleccionado cargar partida.");
                        recuperarEstado();
                        break;
                    case "3":
                        System.out.println("Has seleccionado mostrar armas.");
                        mostrarArmas(ly);
                        System.out.println("Introduce cualquier tecla para continuar:");
                        sc.next();
                        break;
                    case "4":
                        System.out.println("Has seleccionado mostrar roles.");
                        ly.mostrarRoles();
                        System.out.println("Introduce cualquier tecla para continuar:");
                        sc.next();
                        break;
                    case "5":
                        System.out.println("Has seleccionado mostrar intrucciones.");
                        ly.mostrarIntrucciones();
                        System.out.println("Introduce cualquier tecla para continuar:");
                        sc.next();
                        break;
                    case "6":
                        System.out.println("Has seleccionado Salir. Introduce cualquier tecla para continuar:");
                        sc.next();
                        exit = true;
                        break;
                    default:
                        System.out.println("Valor incorrecto introduce otra vez la opcion para continuar: ");
                        repeat = true;
                }
            } while (repeat);
            System.out.println("¿Quieres volverlo a intentar? (s/n)");
            do {
                repeat = false;

                String opcion = sc.nextLine();
                switch (opcion) {
                    case "s":
                        System.out.println("Mostrando menú de inicio");
                        break;
                    case "n":
                        System.out.println("Saliendo...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Valor incorrecto. Vuelve a introducirlo porfavor:");
                        repeat = true;
                }
            } while (repeat);
        } while (!exit);
        sc.close();
    }

    public static void mostrarArmas(Leyenda ly) {
        System.out.println("Hay 4 tipos de armas:\n" +
                "\t1: ARCOS\n" +
                "\t2: MELE\n" +
                "\t3: HECHIZOS\n" +
                "\t4: FUSILES\n" +
                "Introduce el numero correspondiente para mostrarlas, si quieres verlas todas introduce cualquier otro caracter:");
        String opcion = sc.nextLine();
        switch (opcion) {
            case "1":
                System.out.println("Mostrando ARCOS:");
                ly.mostrarArmas("ARCO");
                break;
            case "2":
                System.out.println("Mostrando armas a MELE:");
                ly.mostrarArmas("MELE");
                break;
            case "3":
                System.out.println("Mostrando los HECHIZOS:");
                ly.mostrarArmas("HECHIZO");
                break;
            case "4":
                System.out.println("Mostrando los FUSILES:");
                ly.mostrarArmas("FUSIL");
                break;
            default:
                System.out.println("Mostrando todas las armas:");
                ly.mostrarArmas("a");
        }
    }

    public static Leyenda recuperarEstado() {

        Leyenda checkPoint;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PARTIDA))) {

            checkPoint = (Leyenda) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar partida");
            LOGGER.error(e.getMessage() + e.getStackTrace());
            return null;
        }
        return checkPoint;
    }

    //TODO arreglar metodo sobreescribe el fichero del guardado de la partida.
    public static boolean guardarEstado(Leyenda ly) {

        try {
            if (!PARTIDA.exists()) {
                PARTIDA.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(PARTIDA));
            objectOutputStream.writeObject(ly);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println("Error al guardar partida");
            LOGGER.error(e.getMessage() + e.getStackTrace());
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}