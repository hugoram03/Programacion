package Ejercicios_Set.Parte1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;


public class Main {
    static final String RUTAFICHERO = "src/ComparadorPersonas/baseDatos";
    static Set<Estudiante> hashSet = new HashSet<>();
    static Set<Estudiante> linkedHashSet = new LinkedHashSet<>();
    static Set<Estudiante> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        anadeUsuarios();
        System.out.println(hashSet);
    }

    public static void anadeUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && hashSet.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                double notaMedia = Double.parseDouble(informacion[3]);
                Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                hashSet.add(estudiante);

            }
            hashSet.add(null);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void anadeUsuarios2() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && linkedHashSet.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                double notaMedia = Double.parseDouble(informacion[3]);
                Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                linkedHashSet.add(estudiante);

            }
            linkedHashSet.add(null);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void anadeUsuarios3() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && treeSet.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                double notaMedia = Double.parseDouble(informacion[3]);
                Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                treeSet.add(estudiante);

            }
            treeSet.add(null);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
