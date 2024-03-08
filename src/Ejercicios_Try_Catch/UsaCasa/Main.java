package Ejercicios_Try_Catch.UsaCasa;

import Ejercicios_Try_Catch.UsaCasa.oovv.Casa;

import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        Casa casa1 = new Casa();
        Casa casa2 = new Casa("Mayor", "12", "Lliria", 98, false, 30);
        Casa casa3 = new Casa("Serrano", "48", "Olocau", 130, true, 40);
        Casa n = null;
        System.out.println(casa2.getInfo());
        System.out.println(casa3.getInfo());
        System.out.println(casa2.toString());
        System.out.println("Desea meter una casa? (si/no):");
        String respuesta = lector.next();
        if (respuesta.equalsIgnoreCase("si")) {
            try {
                n = introduceCasa();
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
            System.out.println("La informacion de la casa introducida es:");
            System.out.println(n.getInfo());
        }
    }

    public static Casa introduceCasa() {
        int superficie = 0;
        Casa n = null;
        System.out.print("Calle: ");
        String calle = lector.next();
        System.out.print("Numero: ");
        String numero = lector.next();
        System.out.print("Poblacion: ");
        String poblacion = lector.next();
        System.out.print("Superficie: (> 43.5): ");
        superficie = lector.nextInt();
        System.out.print("Tiene garaje?(true/false): ");
        Boolean garaje = lector.nextBoolean();
        System.out.print("Edad de la casa: ");
        int edad = lector.nextInt();
        System.out.println("Desea guardar la casa? (si/no):");
        String respuesta = lector.next();
        if (respuesta.equalsIgnoreCase("no")) {
            System.out.println("No has guardado la cas aanterior");
        } else {
            n = new Casa(calle, numero, poblacion, superficie, garaje, edad);
        }
        return n;
    }


}