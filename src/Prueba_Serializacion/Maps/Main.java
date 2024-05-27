package Prueba_Serializacion.Maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //HashMap: No ordena especificamente, permite claves y valores nulos, muy eficiente en cuano a busqueda y necesita que esten implementados los metodos equals y hashCode.
        //LinkedHasMap: Permite claves y valores nulos, se ordenan conforme los insertas y necesita que esten implementados los metodos equals y hashCode.
        //TreeMap: Las claves las ordena de forma ascendente, no permite claves nulas pero si valores nulos, mas eficiente y necesita la implementacion de la clase Comparable o proporcionar un Comparator.
        System.out.println("HASHMAP");
        Map<Integer, String> diccionarioHash = new HashMap<>();
        diccionarioHash.put(1, "Hola");
        diccionarioHash.put(2, "Mundo");
        diccionarioHash.put(3, "Adios");
        diccionarioHash.put(4, "Adios");

        //iterar de esta forma es muy sencillo
        for (Map.Entry<Integer, String> entry : diccionarioHash.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
        }

        System.out.println("TREEMAP");
        Map<Integer, String> diccionarioTree = new TreeMap<>();
        diccionarioTree.put(1, "Hola");
        diccionarioTree.put(2, "Mundo");
        diccionarioTree.put(4, "Adios");
        diccionarioTree.put(3, null);

        for (Map.Entry<Integer, String> entry : diccionarioTree.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
        }

        System.out.println("LINKEDHASHMAP");
        Map<Integer, String> diccionarioLinked = new LinkedHashMap<>();
        diccionarioLinked.put(1, "Hola");
        diccionarioLinked.put(2, "Mundo");
        diccionarioLinked.put(4, "Adios");
        diccionarioLinked.put(3, null);

        for (Map.Entry<Integer, String> entry : diccionarioLinked.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " - Valor: " + entry.getValue());
        }
    }
}
