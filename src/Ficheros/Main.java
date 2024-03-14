package Ficheros;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fichero1 = new File("fichero.txt");
        File fichero2 = new File("C:\\Users\\huram\\IdeaProjects\\Programacion\\Fichero\\fichero.txt");
        System.out.println(fichero1.getAbsolutePath());
        System.out.println(fichero1.exists());
        System.out.println(fichero1.canRead());
        System.out.println(fichero2.canRead());

    }
}
