package Sistema_Encriptacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
                        Sistema.encriptar(preguntaFichero(), obtenerPalabraSecreta());
                        Sistema.encriptarBase64(preguntaFichero());
                        Sistema.encriptarCipher(preguntaFichero(), obtenerPalabraSecreta());
                        break;
                    case "2":
                        Sistema.desencriptar(preguntaFichero(), obtenerPalabraSecreta());
                        Sistema.desencritarBase64(preguntaFichero());
                        Sistema.desencriptarCipher(preguntaFichero(), obtenerPalabraSecreta());
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!opcion.equals("0"));
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e){
            LOGGER.info("Error al encriptar/desencriptar un fichero");
            LOGGER.error(e.getStackTrace());
        }
    }
//TODO arreglar problema, no lee el fichero correctamente
    private static File preguntaFichero() throws IOException {
        String fichero;
        File ficheroAEncriptar;
        boolean existe = false;
        do {
            System.out.println("Introduce un fichero que se encuentre disponible en el sistema de encriptacion?");
            fichero = lector.nextLine();
            ficheroAEncriptar = new File("src\\Sistema_Encriptacion\\" + fichero + ".txt");
            if (!ficheroAEncriptar.canRead()){
                System.out.println("Fichero no encontrado quieres crearlo? (s/n)");
                String opcion = lector.nextLine();
                if (opcion.equalsIgnoreCase("s")){
                    File ficheroNuevo = new File("src\\Sistema_Encriptacion\\" + fichero + ".txt");
                    ficheroNuevo.createNewFile();
                    existe = true;
                }
            }
        } while (!existe);
        return ficheroAEncriptar;
    }
    private static String obtenerPalabraSecreta() {
        System.out.println("Palabra de encriptacion:");
        String palabraSecreta = lector.nextLine();
        return palabraSecreta;
    }
}
