package Sistema_Encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        String opcion;
        try {
            do {
                System.out.print("Bienvenido al Sistema de encriptacion.\n" +
                        "1- Encriptar\n" +
                        "2- Desencriptar\n" +
                        "0- Salir\n" +
                        "opcion: ");
                opcion = lector.nextLine();
                switch (opcion) {
                    case "1":
                        Sistema.encriptar(preguntaFichero(), ObtenerPalabraSecreta());
                        break;
                    case "2":
                        Sistema.desencriptar(preguntaFichero(), ObtenerPalabraSecreta());
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!opcion.equals("0"));
        } catch (IOException e){
            LOGGER.info("Error al encriptar/desencriptar un fichero");
            LOGGER.error(e.getStackTrace());
        }
    }

    private static File preguntaFichero() {
        String fichero;
        File ficheroAEncriptar;
        do {
            System.out.println("Introduce un fichero que se encuentre disponible en el sistema de encriptacion?");
            fichero = lector.nextLine();
            ficheroAEncriptar = new File("src\\Sistema_Encriptacion\\" + fichero + ".txt");
        } while (!ficheroAEncriptar.canRead());
        return ficheroAEncriptar;
    }
    private static String ObtenerPalabraSecreta() {
        System.out.println("Palabra de encriptacion:");
        String palabraSecreta = lector.nextLine();
        return palabraSecreta;
    }
}
