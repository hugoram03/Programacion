package EjercicioGuiado;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Collection<MiClase> hashSet = new HashSet<>();
        Collection<MiClase> conjunto1 = Set.of(new MiClase(5, "Zamora"), new MiClase(4, "Castellon"), new MiClase(65, "Alicante"));
        Collection<MiClase> conjunto2 = Collections.unmodifiableSet((Set<? extends MiClase>) hashSet);

        MiClase m1 = new MiClase(1, "Murcia");
        MiClase m2 = new MiClase(3, "Granada");
        MiClase m3 = new MiClase(1, "Segovia");
        MiClase m4 = new MiClase(11, "Vigo");
        MiClase m5 = new MiClase(10, "Sevilla");
        MiClase m6 = new MiClase(1, "Murcia");
        MiClase m7 = new MiClase(12, "Valencia");

        hashSet.add(m1);
        hashSet.add(m2);
        hashSet.add(m3);
        hashSet.add(m4);
        hashSet.add(m5);
        hashSet.add(m6);
        hashSet.add(m7);
        System.out.println(hashSet);

        System.out.println(conjunto1);

        System.out.println(conjunto2);

        /*conjunto1.add(new MiClase(789, "Avila"));
        System.out.println(conjunto1);*/
        hashSet.add(new MiClase(456, "Lugo"));
        System.out.println(conjunto2);

        MiClase cordoba = new MiClase(54, "Cordoba");
        MiClase jaen = new MiClase(78, "Jaen");
        MiClase malaga = new MiClase(98, "Malaga");

        Collection<MiClase> grupo1 = new HashSet<>();
        grupo1.add(cordoba);
        grupo1.add(jaen);
        grupo1.add(malaga);

        Collection<MiClase> grupo2 = Set.of(cordoba, jaen, malaga);
        Collection<MiClase> grupo3 = Collections.unmodifiableSet((Set<? extends MiClase>) grupo1);

        System.out.println(grupo1);
        System.out.println(grupo2);
        System.out.println(grupo3);
        cordoba.setTexto("CR");
        System.out.println("-------------------");
        System.out.println(grupo2);
        System.out.println(grupo3);
    }
}