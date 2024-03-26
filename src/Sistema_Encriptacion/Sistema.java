package Sistema_Encriptacion;

import java.io.*;

public class Sistema {
    private static int caracter;
    private static int indice = 0;

    public static void encriptar(File fichero, String palabraSecreta) throws IOException {
        FileInputStream input = new FileInputStream(fichero);
        File ficheroEncriptado = new File("src\\Sistema_Encriptacion\\" + fichero + ".crip");
        FileOutputStream output = new FileOutputStream(ficheroEncriptado);
        while ((caracter = input.read()) != -1) {
            int nuevoCaracter = caracter + palabraSecreta.charAt(indice);
            output.write(nuevoCaracter);
            indice = (indice + 1) % palabraSecreta.length();
        }
        output.close();
    }

    public static void desencriptar(File fichero, String palabraSecreta) throws IOException {
        FileInputStream input = new FileInputStream(fichero);
        File ficheroEncriptado = new File("src\\Sistema_Encriptacion\\" + fichero + ".crip");
        FileOutputStream output = new FileOutputStream(ficheroEncriptado);
        while ((caracter = input.read()) != -1) {
            int nuevoCaracter = caracter - palabraSecreta.charAt(indice);
            output.write(nuevoCaracter);
            indice = (indice + 1) % palabraSecreta.length();
        }
        output.close();
    }
}
