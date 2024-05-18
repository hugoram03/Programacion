package Prueba_Serializacion;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Alumno alumno = new Alumno("Hugo", 20, "1234568790");
        guardarFichero(alumno);
        System.out.println("Clase Alumno guardada en el fichero");
        cargarFichero();
        System.out.println(alumno);
    }

    public static void guardarFichero(Alumno alumno) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Prueba_Serializacion/prueba.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(alumno);
            out.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void cargarFichero(){
        Alumno alumno = null;
        try {
            FileInputStream fis= new FileInputStream("src/Prueba_Serializacion/prueba.dat");
            ObjectInputStream in = new ObjectInputStream(fis);
            alumno = (Alumno) in.readObject();
            in.close();
        } catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
