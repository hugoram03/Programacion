package Ejercicios_Map.Contador_Palabras;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> contadorPalabras = new TreeMap<>();
        List<String> palabras = new ArrayList<>();

        palabras.add("Hola");
        palabras.add("adios");
        palabras.add("Mundo");
        palabras.add("Mundo");
        palabras.add("Mundo");
        palabras.add("Hola");

        int contador = 0;
        for (int i = 0; i < palabras.size(); i++) {
            if (contadorPalabras.containsKey(palabras.get(i))) {
                contadorPalabras.put(palabras.get(i), contador++);
            } else {
                contador = 1;
                contadorPalabras.put(palabras.get(i), contador);
            }
        }
        System.out.println("CONTADOR DE PALABRAS REPETIDAS");
        System.out.println(contadorPalabras);
    }
}