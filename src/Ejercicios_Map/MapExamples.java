package Ejercicios_Map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {
    public static void main(String[] args) {
        Map<String, Integer> hashmap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        hashmap.put("Hugo", 20);
        hashmap.put("Raul", 22);
        hashmap.put("Jose", 15);
        hashmap.put("Pepe", 2);
        hashmap.put("Francisco", 48);

        treeMap.put("Maria", 12);
        treeMap.put("Carmen", 78);
        treeMap.put("Paco", 56);
        treeMap.put("Hugo", 2);
        treeMap.put("Pedro", 1);

        linkedHashMap.put("Jose", 45);
        linkedHashMap.put("Pepe", 89);
        linkedHashMap.put("Santiago", 13);
        linkedHashMap.put("Juan", 46);
        linkedHashMap.put("Vicente", 5);

        System.out.println("HASHMAP -> " + hashmap);
        System.out.println("TREEMAP -> " + treeMap);
        System.out.println("LINKEDHASHMAP -> " + linkedHashMap);

        System.out.println("---------------------------");
        System.out.println("HASHMAP");
        System.out.println(hashmap.get("Hugo"));
        hashmap.remove("Raul");
        System.out.println("HASHMAP -> " + hashmap);
        System.out.println(hashmap.size());

        System.out.println("---------------------------");
        System.out.println("TREEMAP");
        System.out.println(treeMap.get("Hugo"));
        treeMap.remove("Paco");
        System.out.println("TREEMAP -> " + treeMap);
        System.out.println(treeMap.size());

        System.out.println("---------------------------");
        System.out.println("LINKEDHASHMAP");
        System.out.println(linkedHashMap.get("Vicente"));
        linkedHashMap.remove("Juan");
        System.out.println("LINKEDHASHMAP -> " + linkedHashMap);
        System.out.println(linkedHashMap.size());

        encuentraEdad(hashmap, "Hugo");
    }

    private static void encuentraEdad(Map<String, Integer> mapa, String nombre) {
        boolean encontrado = false;
        for (String clave : mapa.keySet()) {
            if (nombre.contains(clave)) {
                encontrado = true;
            }
        }
        if (encontrado) {
            System.out.println("La edad de " + nombre + " es " + mapa.get(nombre));
        } else {
            System.out.println("Nombre no encontrado en este mapa");
        }
    }
}
