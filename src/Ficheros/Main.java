package Ficheros;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();
    static StringBuilder cadena = new StringBuilder();

    public static void main(String[] args) throws IOException {

        File fichero1 = new File("src\\Ficheros\\ficheroprueba2.txt");
        //File fichero2 = new File("C:\\Users\\adri1\\Programacion\\Tema 6 - POO\\Programacion\\src\\Ficheros\\ficheroPrueba.txt");
        File fichero3 = new File("D:\\fichero3.txt");
        File fichero4 = new File("D:\\Programacion\\Programacion\\src\\Ficheros\\fichero4.txt", "D:\\Programacion\\Programacion\\src\\Ficheros\\fichero3.txt");
        File directorio1 = new File("src\\Ficheros\\directorio1");
        File listaFicheros = new File("src\\Ficheros\\directorio1\\listaFicheros");
        File fichero5 = new File("src\\Ficheros\\ficheroPrueba2.txt");



        try {
            fichero1.createNewFile();
            //fichero2.createNewFile();
            fichero3.createNewFile();
            fichero5.createNewFile();
        } catch (IOException e) {
            LOGGER.error("Error en algun fichero");
        }

        directorio1.mkdir();
        listaFicheros.mkdir();

        cadena.append("\nExiste el fichero 3: " + fichero3.exists());

        cadena.append("\nSe crea un directorio con nombre directorio1");
        cadena.append("\ndirectorio1 existe?: " + directorio1.exists());

        cadena.append("\n\nUSANDO 10 METODOS DE LA CLASE FILE");

        cadena.append("\nExiste el fichero 1: " + fichero1.exists());
        cadena.append("\nBorrando el fichero 1: " + fichero1.delete());
        cadena.append("\nSe puede leer el fichero: " + fichero3.canRead());
        cadena.append("\nLa ruta del fichero3 es:" + fichero3.getAbsolutePath());
        cadena.append("\nEl fichero3 se puede ejecutar: " + fichero3.canExecute());
        cadena.append("\nEl nombre del fichero3 es " + fichero3.getName());
        cadena.append("\nSe puede escribir en el fichero3: " + fichero3.canWrite());
        cadena.append("\nEl fichero3 es un fichero?: " + fichero3.isFile());
        cadena.append("\nUltima modificacion en milisegundos: " + fichero3.lastModified());

        if (fichero5.exists()) {
            fichero5.delete();
        }
        cadena.append("\nficheroPrueba2 creado :" + fichero5.createNewFile());

        cadena.append("\nCreando los 10 ficheros");
        String ruta = "src\\Ficheros\\directorio1\\listaFicheros";
        for (int i = 1; i <= 10; i++) {
            String nombreFichero = ruta + "\\fichero" + i + ".txt";
            File fichero = new File(nombreFichero);
            fichero.createNewFile();
        }
        cadena.append("\nUso de FileWriter");
        File creaFichero = new File("src\\Ficheros\\creaFichero.txt");
        creaFichero.createNewFile();
        escribeFichero("Ramirez", creaFichero);
        escribeFichero("Hugo", creaFichero);
        escribeFichero2("Ramirez", creaFichero);
        cadena.append("\nUso de FileReader");
        leeFichero(creaFichero);
        cadena.append("\nEscribiendo en fichero inexistente");
        escribeFicheroSinExistencia();
        cadena.append("\nUso de PrintWriter");
        usaPrintWriter();
        cadena.append("\nUso de InputStream");
        usaInputStream();
        cadena.append("\nUso de OutputStream");
        usaOutputStream();

        System.out.println(cadena);

        leeYEscribe();
    }

    public static void escribeFichero(String texto, File fichero) throws IOException {
        FileWriter fileWriter = new FileWriter(fichero);
        fileWriter.write(texto);
        fileWriter.close();
    }
    public static void escribeFichero2(String texto, File fichero) throws IOException {
        FileWriter fileWriter = new FileWriter(fichero, true);
        fileWriter.write(texto);
        fileWriter.close();
    }
    public static void leeFichero(File fichero) throws IOException {
        FileReader fileReader = new FileReader(fichero);
        int caracter;
        cadena.append("\nContenido del fichero" + fichero + ":");
        while ((caracter = fileReader.read()) != -1) {
            cadena.append((char) caracter);
        }
        fileReader.close();
    }
    public static void escribeFicheroSinExistencia() throws IOException {
        File ficheroNoExiste = new File("src\\Ficheros\\ficheroNoExiste.txt");
        FileWriter fileWriter = new FileWriter(ficheroNoExiste);
        fileWriter.write("Hola Mundo");
        fileWriter.close();
    }
    public static void usaPrintWriter() throws IOException {
        int caracter = 10;
        File ficheroPrint = new File("src\\Ficheros\\ficheroPrint.txt");
        PrintWriter printWriter = new PrintWriter(ficheroPrint);
        printWriter.println("Hola");
        printWriter.print("mundo");
        printWriter.format(" dia $d", caracter);
        printWriter.close();
    }
    public static void usaInputStream() throws IOException {
        File ficheroPrint = new File("src\\Ficheros\\ficheroStream.txt");
        DataOutputStream out = new DataOutputStream(new FileOutputStream(ficheroPrint));
        for (int i = 1; i <= 50; i++) {
            out.writeUTF("\n" + i);
        }
        out.close();
    }
    public static void usaOutputStream() throws IOException {
        File ficheroPrint = new File("src\\Ficheros\\ficheroStream.txt");
        DataInputStream in = new DataInputStream(new FileInputStream(ficheroPrint));
        for (int i = 1; i <= 50; i++) {
            cadena.append(in.readUTF());
        }
    }
    public static void leeYEscribe() throws IOException {
        Scanner lector = new Scanner(System.in);
        String texto = "";
        File fichero = new File("src\\Ficheros\\directorio1\\escritura.txt");
        FileWriter fileWriter = new FileWriter(fichero, true);
        while (!texto.equalsIgnoreCase("fin")) {
            fileWriter.write(texto + " ");
            System.out.println("Escribe el texto que quieras para añadirlo a el fichero 'escritura' ('fin' para acabar el programa) :");
            texto = lector.nextLine();
        }
        fileWriter.close();
    }
}