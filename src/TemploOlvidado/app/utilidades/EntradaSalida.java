package app.utilidades;

import app.objetos.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class EntradaSalida {

    private static final Logger LOGGER = LogManager.getRootLogger();
    //TODO Adaptar la ruta de los ficheros
    public static final String RUTA_BBDD = "bbdd";
    public static final String RUTA_DATOS = "datos";
    public static final String DATA_FILE = "app.TemploOlvidado.dat";

    /**
     * Carga un fichero CSV con los personajes y los convierte en un mapa de personajes, donde la clave es el nombre
     * en uppercase y el valor es el personaje
     *
     * @param nombreFichero nombre del fichero CSV
     * @return un mapa de personajes
     */
    public static Map<String, Personaje> cargarCSVPersonas(String nombreFichero) throws IOException {
        Map<String, Personaje> grupo = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        br.readLine();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos[1].equalsIgnoreCase("Maga")) {
                grupo.put(campos[0].toUpperCase(), new Personaje(campos[0],Clase.MAGA, Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Atributo.MAGIA));
            } else if (campos[1].equalsIgnoreCase("Guerrera")) {
                grupo.put(campos[0].toUpperCase(), new Personaje(campos[0],Clase.GUERRERA, Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Atributo.FUERZA));
            } else if (campos[1].equalsIgnoreCase("Cazadora")) {
                grupo.put(campos[0].toUpperCase(), new Personaje(campos[0],Clase.CAZADORA, Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Atributo.FUERZA));
            } else if (campos[1].equalsIgnoreCase("Estudiosa")) {
                grupo.put(campos[0].toUpperCase(), new Personaje(campos[0],Clase.ESTUDIOSA, Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Atributo.FUERZA));
            } else {
                grupo.put(campos[0].toUpperCase(), new Personaje(campos[0],Clase.INFORMATICA, Integer.parseInt(campos[2]), Integer.parseInt(campos[3]), Atributo.FUERZA));
            }
        }
        br.close();
        return grupo;
    }

    /**
     * Carga un fichero CSV con los objetos mágicos y los convierte en un mapa de objetos mágicos
     *
     * @param nombreFichero nombre del fichero CSV
     * @return un mapa de objetos mágicos
     */
    public static Map<Integer, ObjetoMagico> cargarCSVObjetos(String nombreFichero) throws IOException {
        Map<Integer, ObjetoMagico> grupo = new LinkedHashMap<>();
        BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
        br.readLine();
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            if (campos[2].equalsIgnoreCase("Magia")) {
                grupo.put(Integer.parseInt(campos[0]), new ObjetoMagico(campos[1], Atributo.MAGIA, Integer.parseInt(campos[3])));
            } else if (campos[2].equalsIgnoreCase("Fuerza")) {
                grupo.put(Integer.parseInt(campos[0]), new ObjetoMagico(campos[1], Atributo.FUERZA, Integer.parseInt(campos[3])));
            } else if (campos[2].equalsIgnoreCase("Inteligencia")) {
                grupo.put(Integer.parseInt(campos[0]), new ObjetoMagico(campos[1], Atributo.INTELIGENCIA, Integer.parseInt(campos[3])));
            }
        }
        br.close();
        return grupo;
    }

    /**
     * Almacena una batalla en un fichero que puede contener otras batallas
     *
     * @param batalla batalla a almacenar
     * @return true si se ha almacenado correctamente, false en caso contrario
     */
    public static boolean almacenarBatalla(Batalla batalla) {
        File fichero = new File(DATA_FILE);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fichero);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(batalla);
            objectOutputStream.close();
            if (fichero.canExecute()) {
                return true;
            }
        } catch (IOException e) {
            LOGGER.error("Error al almacenar la batalla");
        }
        return false;
    }


    /**
     * Recupera todas las batallas almacenadas en un fichero, son batallas que han sido épicas y han ganado los guardianes
     *
     * @return una lista con todas las batallas almacenadas
     */
    public static List<Batalla> recuperarBatallas() throws IOException, ClassNotFoundException {
        List<Batalla> batalla;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(DATA_FILE));
        batalla = (List<Batalla>) objectInputStream.readObject();
        objectInputStream.close();
        return batalla;
    }

    //Uso este metodo por que ya lo gestiono en el metodo correspondiente
    /*public static boolean existePartidaGuardada() {

    }*/
}
