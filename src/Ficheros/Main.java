package Ficheros;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) throws IOException {
        ArrayList<File> ficheros = new ArrayList<>();
        StringBuilder cadena = new StringBuilder();
        File fichero1 = new File("src\\Ficheros\\ficheroprueba2.txt");
        //File fichero2 = new File("C:\\Users\\adri1\\Programacion\\Tema 6 - POO\\Programacion\\src\\Ficheros\\ficheroPrueba.txt");
        File fichero3 = new File("D:\\fichero3.txt");
        File fichero4 = new File("D:\\Programacion\\Programacion\\src\\Ficheros\\fichero4.txt", "D:\\Programacion\\Programacion\\src\\Ficheros\\fichero3.txt");
        File directorio1 = new File("src\\Ficheros\\directorio1");
        File listaFicheros = new File("src\\Ficheros\\directorio1\\listaFicheros");
        File fichero5 = new File("src\\Ficheros\\ficheroPrueba2.txt");
        File listaFichero1 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero1.txt");
        File listaFichero2 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero2.txt");
        File listaFichero3 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero3.txt");
        File listaFichero4 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero4.txt");
        File listaFichero5 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero5.txt");
        File listaFichero6 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero6.txt");
        File listaFichero7 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero7.txt");
        File listaFichero8 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero8.txt");
        File listaFichero9 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero9.txt");
        File listaFichero10 = new File("src\\Ficheros\\directorio1\\listaFicheros\\listaFichero10.txt");

        try {
            fichero1.createNewFile();
            //fichero2.createNewFile();
            fichero3.createNewFile();
            fichero5.createNewFile();
            listaFichero1.createNewFile();
            listaFichero2.createNewFile();
            listaFichero3.createNewFile();
            listaFichero4.createNewFile();
            listaFichero5.createNewFile();
            listaFichero6.createNewFile();
            listaFichero7.createNewFile();
            listaFichero8.createNewFile();
            listaFichero9.createNewFile();
            listaFichero10.createNewFile();
        } catch (IOException e) {
            LOGGER.error("Error el algun fichero");
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

        System.out.println(cadena);
    }
}