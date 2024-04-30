package Lists.Estudiantes;

import ComparadorPersonas.Comparadores.NombreComparator;
import ComparadorPersonas.Estudiante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static final String RUTAFICHERO = "src/ComparadorPersonas/baseDatos";
    static LinkedList<Estudiante> estudiantes = new LinkedList<>();

    public static void main(String[] args) {
        ComparadorPersonas.Estudiante estudiante= new ComparadorPersonas.Estudiante("Pedro", "Hernandez Gracia", LocalDate.now(), 5.5);
        //anadeUsuarios();
        estudiantes.addFirst(estudiante);
        estudiantes.add(estudiante);
        estudiantes.add(estudiante);
        estudiantes.addLast(estudiante);
        estudiantes.push(estudiante);
        estudiantes.add(3,estudiante);
        estudiantes.offerFirst(estudiante);
        estudiantes.offerLast(estudiante);

        /*anadeUsuarios2();
        estudiantes.set(0, estudiante);
        estudiantes.get(0);
        estudiantes.element();
        estudiantes.peekFirst();
        estudiantes.peekLast();*/

       /* anadeUsuarios3();
        estudiantes.remove();
        estudiantes.removeFirst();
        estudiantes.removeLast();
        estudiantes.pop();
        estudiantes.remove(0);
        estudiantes.pollFirst();
        estudiantes.pollLast();*/
        mostrarListaOrdenacionNombre();
    }

    public static void anadeUsuarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && estudiantes.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Double notaMedia = Double.parseDouble(informacion[3]);
                ComparadorPersonas.Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                estudiantes.add(estudiante);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void anadeUsuarios2() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && estudiantes.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Double notaMedia = Double.parseDouble(informacion[3]);
                ComparadorPersonas.Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                estudiantes.add(estudiante);

            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void anadeUsuarios3() {
        try (BufferedReader br = new BufferedReader(new FileReader(RUTAFICHERO))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null && estudiantes.size() < 10) {
                String[] informacion = linea.split(";");
                String nombre = informacion[0];
                String apellidos = informacion[1];
                LocalDate fechaNaciemiento = LocalDate.parse(informacion[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Double notaMedia = Double.parseDouble(informacion[3]);
                ComparadorPersonas.Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                estudiantes.add(estudiante);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void mostrarListaOrdenacionNombre() {
        System.out.println("\n--Mostrando lista de usuarios con ordenacion por defecto--");
        Collections.sort(estudiantes, new NombreComparator());
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));
        }
    }
}
