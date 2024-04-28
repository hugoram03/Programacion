package ComparadorPersonas;

import ComparadorPersonas.Comparadores.EdadComparator;
import ComparadorPersonas.Comparadores.NombreComparator;
import ComparadorPersonas.Comparadores.NotaMediaComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Main {
    static final String RUTAFICHERO = "src/ComparadorPersonas/baseDatos";
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static Collator miCollator = Collator.getInstance(new Locale("es", "ES"));

    public static void main(String[] args) {

        miCollator.setStrength(Collator.TERTIARY);
        anadeUsuarios();
        System.out.println("--Mostrando lista de usuarios sin ordenar--");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));
        }
        mostrarListaOrdenacionNombre();
        mostrarListaOrdenacionEdad();
        mostrarListaOrdenacionNotaMedia();
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
                estudiantes.add(estudiante);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void mostrarListaOrdenacionNombre() {
        System.out.println("\n--Mostrando lista de usuarios con ordenacion por defecto--");
        Collections.sort(estudiantes, miCollator);
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));
        }
    }

    public static void mostrarListaOrdenacionEdad() {
        System.out.println("\n--Mostrando lista de usuarios con ordenacion por edad--");
        Collections.sort(estudiantes, miCollator);
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));
        }
    }
    public static void mostrarListaOrdenacionNotaMedia(){
        System.out.println("\n--Mostrando lista de usuarios con ordenacion por nota media--");
        Collections.sort(estudiantes, miCollator);
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i));
        }
    }
}