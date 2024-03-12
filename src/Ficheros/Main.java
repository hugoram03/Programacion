package Ficheros;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fichero = new File("Fichero/fichero.txt");
        File fichero2 = new File("D:\\Programacion\\Programacion\src\\Ficheros\fichero.txt");

        System.out.println(fichero.canRead());
        System.out.println(fichero2.canRead());

    }
}
