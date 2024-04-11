package Sistema_Encriptacion.src;

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
    //TODO (mejora resaltable) vaga gestión de las excepciones en todo el documento
    //TODO (ERROR) main no debe lanzar una IOException, la debe controlar
    public static void main(String[] args) throws IOException {
        String opcion;
        try {
            //TODO (error) Logica confusa en el bucle, si se contesta un cero te saldrá OPCION INCORRECTA aunque no debería de serlo
            do {
                System.out.print("Bienvenido al Sistema de encriptacion.\n" +
                        "1- Encriptar\n" +
                        "2- Desencriptar\n" +
                        "0- Salir\n" +
                        "opcion: ");
                //TODO (mejora) Pregunta un int y lee una String
                //TODO (mejora) también se debe controlar el InputMissMatchException al preguntar int
                opcion = lector.nextLine();
                switch (opcion) {
                    case "1":
                        //TODO (error) Se encripta 3 veces? El usuario debería de poder elegir o almenos el administrador.
                        Sistema.encriptar(preguntaFichero(), obtenerPalabraSecreta());
                        Sistema.encriptarBase64(preguntaFichero());
                        Sistema.encriptarCipher(preguntaFichero(), obtenerPalabraSecreta());
                        break;
                    case "2":
                        //TODO (error) Se desencripta 3 veces? El usuario debería de poder elegir o almenos el administrador.
                        Sistema.desencriptar(preguntaFichero(), obtenerPalabraSecreta());
                        Sistema.desencriptarBase64(preguntaFichero());
                        Sistema.desencriptarCipher(preguntaFichero(), obtenerPalabraSecreta());
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!opcion.equals("0"));
            //se podría añadir mensaje despedida si selecciona opción 0
            if(opcion.equals("0")){
                System.out.println("Hasta pronto ...");
            }
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e){
            LOGGER.info("Error al encriptar/desencriptar un fichero");
            LOGGER.error(e.getStackTrace());
        }
    }
//arreglar problema, no lee el fichero correctamente
    //TODO (mejora) Metodo que debería de estar ubicado a Sistema de Encriptación
    private static File preguntaFichero() throws IOException {
        String fichero;
        File ficheroAEncriptar;
        boolean existe = false;
        do {
            //TODO (error) Solo se contempla la opción de fichero para encriptar, por tanto, siempre será .txt. Cuando al desencriptar el fichero recogido debería de ser .crip
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
    //se podría mejorar salida ocion n
    //TODO (mejora) Metodo que debería de estar ubicado a Sistema de Encriptación
    private static String obtenerPalabraSecreta() {
        System.out.println("Palabra de encriptacion:");
        String palabraSecreta = lector.nextLine();
        return palabraSecreta;
    }
}
