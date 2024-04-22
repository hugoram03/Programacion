package Iterables.RecorreIterable;

import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> numeros = new ArrayList<>();
        numeros.add(r.nextInt(10) + 1);
        numeros.add(r.nextInt(10) + 1);
        numeros.add(r.nextInt(10) + 1);
        numeros.add(r.nextInt(10) + 1);
        numeros.add(r.nextInt(10) + 1);

        Iterator<Integer> iterator = numeros.iterator();
        for (Iterator<Integer> it = numeros.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
    }
}