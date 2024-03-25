package SIstema_Encriptacion;

import java.io.*;
import java.util.Scanner;

public class Sistema {
    public static void encriptar(Scanner lector) throws IOException {
        String fichero;
        File ficheroAEncriptar;
        do {
            System.out.println("Introduce un fichero que se encuentre disponible en el sistema de encriptacion?");
            fichero = lector.nextLine();
            ficheroAEncriptar = new File("src\\Sistema_Encriptacion\\" + fichero + ".txt");
        } while (!ficheroAEncriptar.canRead());
        System.out.println("Palabra de encriptacion:");
        String palabraEncriptacion = lector.nextLine();

        FileInputStream input = new FileInputStream(ficheroAEncriptar);
        File ficheroEncriptado = new File("src\\Sistema_Encriptacion\\" + fichero + ".crip");
        FileOutputStream output = new FileOutputStream(ficheroEncriptado);

        int caracter;
        int indice = 0;
        while ((caracter = input.read()) != -1) {
            int nuevoCaracter = caracter + palabraEncriptacion.charAt(indice);
            output.write(nuevoCaracter);
            indice = (indice + 1) % palabraEncriptacion.length();

        }
        output.close();
    }

    public static void desencriptar(Scanner lector) throws IOException {
        String fichero;
        File ficheroAEncriptar;
        do {
            System.out.println("Introduce un fichero que se encuentre disponible en el sistema de encriptacion?");
            fichero = lector.nextLine();
            ficheroAEncriptar = new File("src\\Sistema_Encriptacion\\" + fichero + ".txt");
        } while (!ficheroAEncriptar.canRead());
        System.out.println("Palabra de encriptacion:");
        String palabraEncriptacion = lector.nextLine();
        FileInputStream input = new FileInputStream(ficheroAEncriptar);
        File ficheroEncriptado = new File("src\\Sistema_Encriptacion\\" + fichero + ".crip");
        FileOutputStream output = new FileOutputStream(ficheroEncriptado);

        int caracter;
        int indice = 0;
        while ((caracter = input.read()) != -1) {
            int nuevoCaracter = caracter - palabraEncriptacion.charAt(indice);
            output.write(nuevoCaracter);
            indice = (indice + 1) % palabraEncriptacion.length();

        }
        output.close();
    }
}
