package Ejercicios_Map.Contador_Palabras;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> contadorPalabras = new TreeMap<>();
        List<String> palabras = new ArrayList<>();

        palabras.add("Hola");
        palabras.add("adios");
        palabras.add("Hola");
        palabras.add("Mundo");
        palabras.add("Mundo");
        palabras.add("Mundo");


        for (int i = 0; i < palabras.size(); i++) {
            if (!contadorPalabras.containsKey(palabras.get(i))) {
                contadorPalabras.put(palabras.get(i), 1);
            } else {
                int contador = contadorPalabras.get(palabras.get(i));
                contador++;
                contadorPalabras.put(palabras.get(i), contador);
            }

            //TODO TAMBIEN SE PUEDE HACER MAS FACIL CON ESTE METODO.
            //contadorPalabras.put(palabras.get(i), contadorPalabras.getOrDefault(palabras.get(i), 0) + 1);
        }
        System.out.println("CONTADOR DE PALABRAS REPETIDAS");
        System.out.println(contadorPalabras);
    }
}