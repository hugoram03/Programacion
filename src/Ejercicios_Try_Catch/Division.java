package Ejercicios_Try_Catch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        //division();
        division1();
    }

    public static void division() {

        try {
            System.out.println("DIVISION");
            System.out.print("Introduce operador 1: ");
            int op1 = lector.nextInt();
            System.out.print("Introduce operador 2: ");
            int op2 = lector.nextInt();
            System.out.println(dividir(op1, op2));
        } catch (InputMismatchException e) {
            System.out.println("Operador no valido");
        } catch (ArithmeticException ex) {
            System.out.println("No es posible dividir por 0");
        } finally {
            lector.close();
        }
    }

    public static void division1() {
        try {
            System.out.println("DIVISION");
            System.out.print("Introduce operador 1: ");
            int op1 = lector.nextInt();
            System.out.print("Introduce operador 2: ");
            int op2 = lector.nextInt();
            System.out.println(dividir(op1, op2));
        } catch (InputMismatchException e) {
            System.out.println("Operador no valido");
        } catch (ArithmeticException ex) {
            System.out.println("No es posible dividir por 0");
        } finally {
            lector.close();
        }
    }

    private static int dividir(int op1, int op2) {
        int division = op1 / op2;
        return division;
    }
}
