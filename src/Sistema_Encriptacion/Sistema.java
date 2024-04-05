package Sistema_Encriptacion;

import java.io.*;
import java.util.Base64;

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

    public static void encriptarBase64(File fichero) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fichero));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src\\Sistema_Encriptacion\\" + fichero + "2.crip"));
        String linea;
        while ((linea = reader.readLine()) != null){
            String lineaEncriptada = Base64.getEncoder().encodeToString(linea.getBytes());
            writer.write(lineaEncriptada);
            writer.newLine();
        }
        writer.close();
        reader.close();
    }

    public static void desencritarBase64(File fichero) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\Sistema_Encriptacion\\" + fichero + "2.crip"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fichero));
        String linea;
        while ((linea = reader.readLine()) != null){
            byte[] decodedBytes = Base64.getDecoder().decode(linea);
            String lineaDesencriptada = new String(decodedBytes);
            writer.write(lineaDesencriptada);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }
}
