package QUEUEyDEQUE.p1;

import ComparadorPersonas.Comparadores.NombreComparator;
import ComparadorPersonas.Estudiante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Main {
    static final String RUTAFICHERO = "src/ComparadorPersonas/baseDatos";
    static LinkedList<Estudiante> estudiantes = new LinkedList<>();
    static PriorityQueue<Estudiante> priorityQueue = new PriorityQueue();

    public static void main(String[] args) {
        anadeUsuarios();
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue);
            priorityQueue.poll();
            priorityQueue.comparator();
        }

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
                Estudiante estudiante = new Estudiante(nombre, apellidos, fechaNaciemiento, notaMedia);
                priorityQueue.add(estudiante);

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
