package EjercicioGuiado;

import java.util.Collection;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Collection<MiClase> hashSet = new HashSet<>();

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

        MiClase m8 = new MiClase(3, "Granada");

        for (MiClase e : hashSet) {
            if (hashSet.contains(m8)) {
                m2.setNum(33);
            }
        }

        System.out.println(hashSet);
        MiClase m9 = new MiClase(33, "Granada");
        System.out.println(hashSet.contains(m9));
        System.out.println("----------");

        for (MiClase e : hashSet) {
            if (e.equals(m9)) {
                System.out.println(Boolean.TRUE);
            } else {
                System.out.println(Boolean.FALSE);
            }
        }
        System.out.println(hashSet);
    }
}