package Sistema_Encriptacion;

import javax.crypto.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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
        while ((linea = reader.readLine()) != null) {
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
        while ((linea = reader.readLine()) != null) {
            byte[] decodedBytes = Base64.getDecoder().decode(linea);
            String lineaDesencriptada = new String(decodedBytes);
            writer.write(lineaDesencriptada);
            writer.newLine();
        }
        reader.close();
        writer.close();
    }

    public static void encriptarCipher(File fichero, String palabraSecreta) throws NoSuchAlgorithmException, IOException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = obtenerPalabraSecreta(palabraSecreta);
        FileInputStream inputStream = new FileInputStream(fichero);
        FileOutputStream outputStream = new FileOutputStream("src\\Sistema_Encriptacion\\" + fichero + "Cipher.crip");
        Cipher cipher = Cipher.getInstance(palabraSecreta);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] inpuBytes = new byte[64];
        int bytesRead;
        while ((bytesRead = inputStream.read(inpuBytes)) != -1) {
            byte[] encryptedBytes = cipher.update(inpuBytes, 0, bytesRead);
            outputStream.write(encryptedBytes);
        }
        byte[] encryptedBytes = cipher.doFinal();
        outputStream.write(encryptedBytes);

        inputStream.close();
        outputStream.close();
    }

    private static SecretKey obtenerPalabraSecreta(String palabraSecreta) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(palabraSecreta);
        keyGenerator.init(128);
        return keyGenerator.generateKey();
    }

    public static void desencriptarCipher(File fichero, String palabraSecreta) throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKey secretKey = obtenerPalabraSecreta(palabraSecreta);
        FileInputStream inputStream = new FileInputStream("src\\Sistema_Encriptacion\\" + fichero + "Cipher.crip");
        FileOutputStream outputStream = new FileOutputStream(fichero);
        Cipher cipher = Cipher.getInstance(palabraSecreta);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] inputBytes = new byte[64];
        int bytesRead;
        while ((bytesRead = inputStream.read(inputBytes)) != -1) {
            byte[] decryptedBytes = cipher.update(inputBytes, 0, bytesRead);
            outputStream.write(decryptedBytes);
        }
        byte[] decryptedBytes = cipher.doFinal();
        outputStream.write(decryptedBytes);
        inputStream.close();
        outputStream.close();
    }
}
