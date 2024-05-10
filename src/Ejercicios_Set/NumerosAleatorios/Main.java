package Ejercicios_Set.NumerosAleatorios;

import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Collection<Integer> numerosAleatorios = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            numerosAleatorios.add(random.nextInt(10) + 1);
        }
        System.out.println(numerosAleatorios);
        for (Integer i : numerosAleatorios){
            if (i.equals(5)){
                System.out.println("Contiene el numero 5:" + Boolean.TRUE);
            }
        }
        numerosAleatorios.add(0);
        numerosAleatorios.add(15);
        numerosAleatorios.add(25);
        System.out.println(numerosAleatorios);

    }
}
