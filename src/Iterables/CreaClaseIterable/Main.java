package Iterables.CreaClaseIterable;

import java.util.Iterator;

public class Main {
    static ListaIterable listaIterable = new ListaIterable();

    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Hugo", "1234", 20, "DAW", 8);
        Alumno alumno2 = new Alumno("Sergio", "1232", 22, "DAW", 1);
        Alumno alumno3 = new Alumno("Raul", "1233", 21, "DAW", 4);
        listaIterable.anadir(alumno1);
        listaIterable.anadir(alumno2);
        listaIterable.anadir(alumno3);
        Iterator<Alumno> iterator = listaIterable.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }
}