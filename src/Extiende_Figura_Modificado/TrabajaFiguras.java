package Extiende_Figura_Modificado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TrabajaFiguras {

    public static final StringBuilder SALTO_LINEA = new StringBuilder("\n");
    static ArrayList<Figura> figuras = new ArrayList<>();
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Punto p1 = new Punto(2.5, 5.6);
        Triangulo t1 = new Triangulo(28.5, 5.1);
        Circulo c1 = new Circulo(2.14, p1);
        Triangulo t2 = new Triangulo(102.5, 84.1);
        Circulo c2 = new Circulo(16.4, p1);
        Triangulo t3 = new Triangulo(1.5, 5.1);
        Circulo c3 = new Circulo(25.14, p1);
        Triangulo t4 = new Triangulo(10.5, 84.1);
        Circulo c4 = new Circulo(15.4, p1);

        Rectangulo r1 = new Rectangulo(12.5, 23.7);
        imprimirArea(r1);

        Rectangulo r2 = new Rectangulo(8.6, 33.1);
        imprimirArea(r2);

        cualEsMayor(r1, r2);

        Triangulo triangulo = new Triangulo(20.1, 20.1);

        cualEsMayor(triangulo, r1);


        Caja caja1 = new Caja(6, 4, 10);
        caja1.print();

        arbolDeNavidad();

        figuras.add(t1);
        figuras.add(r1);
        figuras.add(t2);
        figuras.add(r2);
        figuras.add(c1);
        figuras.add(c2);
        figuras.add(t3);
        figuras.add(t4);
        figuras.add(c3);
        figuras.add(c4);

        Collections.sort(figuras, new Comparator<Figura>() {
            @Override
            public int compare(Figura o1, Figura o2) {
                return Double.compare(o1.area(), o2.area());
            }
        });

        for (int i = 0; i < figuras.size(); i++) {
            System.out.println(figuras.get(i));
        }
    }

    private static void arbolDeNavidad() {
        Triangulo triangulo = new Triangulo(3, 3);
        Triangulo triangulo2 = new Triangulo(5, 5);
        Triangulo triangulo3 = new Triangulo(7, 7);
        Rectangulo rectangulo = new Rectangulo(3, 3);
        triangulo.print();
        triangulo2.print();
        triangulo3.print();
        rectangulo.print();

    }

    private static void cualEsMayor(Rectangulo figura1, Rectangulo figura2) {
        if (FiguraAbstracta.mayorQue(figura1, figura2)) {
            System.out.println("El " + figura1.getNombre() + "1 es mayor que el " + figura2.getNombre() + "2" + SALTO_LINEA);
        } else {
            System.out.println("El " + figura2.getNombre() + "2 es mayor que el " + figura1.getNombre() + "1" + SALTO_LINEA);
        }
    }

    private static void cualEsMayor(Triangulo figura1, Rectangulo figura2) {
        if (FiguraAbstracta.mayorQue(figura2, figura1)) {
            System.out.println("El " + figura1.getNombre() + " es mayor que el " + figura2.getNombre() + SALTO_LINEA);
        } else {
            System.out.println("El " + figura2.getNombre() + " es mayor que el " + figura1.getNombre() + SALTO_LINEA);
        }
    }

    private static void imprimirArea(Rectangulo rectangulo) {
        System.out.println(rectangulo.area() + "\n");
    }
}
