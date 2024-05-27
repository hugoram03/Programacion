package Prueba_Serializacion.Sets;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        //HashSet: El conjunto de datos no se almacena en un orden especifico, si bien se garantiza que no hayan duplicados.
        //LinkedHashSet: Los elementos del conjunto se ordenan en cuanto a la insercion, similar a una lista pero sin dejar duplicados.
        //TreeSet: Los elementos del conjunto se almacenan de menor a mayor.
        System.out.println("HASHSET");
        Set<String> conjuntoHash = new HashSet<>();
        conjuntoHash.add("Hola");
        conjuntoHash.add("Mundo");
        conjuntoHash.add("Adios");
        for (String valor : conjuntoHash) {
            System.out.println("Valor: " + valor);
        }
        System.out.println("TREEMAP");
        Set<String> conjuntoTree = new TreeSet<>();
        conjuntoTree.add("Hola");
        conjuntoTree.add("Mundo");
        conjuntoTree.add("Adios");

        for (String valor:conjuntoTree) {
            System.out.println("Valor: " + valor);
        }
        System.out.println("LINKEDHASHSET");
        Set<Character> conjuntoLinked = new LinkedHashSet<>();
        conjuntoLinked.add('B');
        conjuntoLinked.add('A');
        conjuntoLinked.add('C');
        conjuntoLinked.add('N');
        conjuntoLinked.add('W');

        for (Character valor:conjuntoLinked) {
            System.out.println("Valor: " + valor);
        }
    }
}
