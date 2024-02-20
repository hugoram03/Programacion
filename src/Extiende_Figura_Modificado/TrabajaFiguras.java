package Extiende_Figura_Modificado;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TrabajaFiguras implements Comparator {

    public static final StringBuilder SALTO_LINEA = new StringBuilder("\n");
 static Scanner lector = new Scanner(System.in);
    public static void main (String [] args ) {

        Rectangulo r1 = new Rectangulo(12.5, 23.7);
        imprimirArea(r1);

        Rectangulo r2 = new Rectangulo(8.6, 33.1);
        imprimirArea(r2);

        cualEsMayor(r1,r2);

        Triangulo triangulo = new Triangulo(20.1, 20.1);

        cualEsMayor(triangulo,r1);


        Caja caja1 = new Caja(6,4,10);
        caja1.print();

        arbolDeNavidad();

        ArrayList<String> figuras = new ArrayList<>(10);
        for (String figura : figuras) {
            System.out.println("Introduce figura:");
            String elemento = lector.nextLine();
            figuras.add(elemento);
        }
        Collections.sort(figuras);
    }


    private static void arbolDeNavidad() {
        Triangulo triangulo = new Triangulo(3,3 );
        Triangulo triangulo2 = new Triangulo(5, 5);
        Triangulo triangulo3 = new Triangulo(7, 7);
        Rectangulo rectangulo = new Rectangulo(3,3);
        triangulo.print();
        triangulo2.print();
        triangulo3.print();
        rectangulo.print();

    }

    private static void cualEsMayor(Rectangulo figura1, Rectangulo figura2) {
        if (FiguraAbstracta.mayorQue(figura1,figura2)) {
            System.out.println("El " + figura1.getNombre() + "1 es mayor que el " + figura2.getNombre() + "2" + SALTO_LINEA);
        } else {
            System.out.println("El " + figura2.getNombre() + "2 es mayor que el " + figura1.getNombre() + "1" + SALTO_LINEA);
        }
    }
    private static void cualEsMayor(Triangulo figura1, Rectangulo figura2) {
        if (FiguraAbstracta.mayorQue(figura2,figura1)) {
            System.out.println("El " + figura1.getNombre() + " es mayor que el " + figura2.getNombre() + SALTO_LINEA);
        } else {
            System.out.println("El " + figura2.getNombre() + " es mayor que el " + figura1.getNombre() + SALTO_LINEA);
        }
    }

    private static void imprimirArea(Rectangulo rectangulo) {
        System.out.println(rectangulo.area() + "\n");
    }


    //buscando en internet no consigo saber usarlo
    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
