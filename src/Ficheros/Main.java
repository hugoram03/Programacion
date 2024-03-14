package Ficheros;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File fichero1 = new File("fichero.txt");
        File fichero2 = new File("C:\\Users\\adri1\\Programacion\\Tema 6 - POO\\Programacion\\src\\Ficheros\\ficheroPrueba.txt");
        fichero1.createNewFile();
        fichero2.createNewFile();

        System.out.println("Existe el fichero 1: " + fichero1.exists());
        System.out.println("Existe el fichero 2: " + fichero2.exists());

    }
}
