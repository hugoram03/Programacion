package Ejercicios_Set.Parte3;

import Ejercicios_Set.Parte2.Estudiante;

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
    static Set<Estudiante> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        System.out.println("TREESET");
        System.out.println(treeSet);
    }
}
