package SIstema_Encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        Scanner lector = new Scanner(System.in);
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
                        Sistema.encriptar(lector);
                        break;
                    case "2":
                        Sistema.desencriptar(lector);
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
}
