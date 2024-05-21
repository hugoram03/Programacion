package Prueba_Serializacion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        File fichero = new File("src/Prueba_Serializacion/fichero.txt");
        /*Grupo daw = new Grupo();
        daw.agregarAlumno(new Alumno("Hugo", 20, "1234568790"));
        guardarFichero(daw);
        System.out.println("Clase Alumno guardada en el fichero");
        cargarFichero();*/

        guardarFicheroBuffered(fichero);
        cargarFicheroBuffered(fichero);

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
        }
    }
    public static void guardarFicheroBuffered(File fichero) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        for (int i = 1; i <= 10; i++) {
            bw.write("Esta es la linea: " + i);
            bw.newLine();
        }
        bw.close();
    }

    public static void cargarFicheroBuffered(File fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null){
            System.out.println(linea);
        }
        br.close();
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
