package Prueba_Serializacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();
    public static void main(String[] args) {
        Grupo daw = new Grupo();
        daw.agregarAlumno(new Alumno("Hugo", 20, "1234568790"));
        guardarFichero(daw);
        System.out.println("Clase Alumno guardada en el fichero");
        cargarFichero();
    }

    public static void guardarFichero(Grupo grupo) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("srcPrueba_Serializacion/prueba.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(grupo);
            out.close();
        } catch (IOException e) {
            LOGGER.error("Error al guardar el archivo");
        }
    }

    public static void cargarFichero() {

        try {
            Grupo daw = null;
            FileInputStream fis = new FileInputStream("srcPrueba_Serializacion/prueba.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            daw = (Grupo) in.readObject();
            daw.mostrarAlumnos();
            in.close();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error("Error al cargar el archivo");
        }
    }
}
