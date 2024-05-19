package Ejercicios_Try_Catch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Division {
    static Scanner lector = new Scanner(System.in);
    static Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {
        division();
        //division1();
        //division2();
    }

    public static void division() {

        try {
            System.out.println("DIVISION DE NUMEROS ENTEROS");
            System.out.print("Introduce operador 1: ");
            int op1 = lector.nextInt();
            System.out.print("Introduce operador 2: ");
            int op2 = lector.nextInt();
            System.out.println(dividir(op1, op2));
        } catch (InputMismatchException e) {
            System.out.println("Operador no valido");
        } catch (ArithmeticException ex) {
            LOGGER.error("Error aritmetico no se puede dividir por 0");
        } finally {
            lector.close();
        }
    }

    public static void division1() {
        try {
            System.out.println("DIVISION DE NUMEROS ENTEROS");
            System.out.print("Introduce operador 1: ");
            int op1 = lector.nextInt();
            System.out.print("Introduce operador 2: ");
            int op2 = lector.nextInt();
            System.out.println(dividir(op1, op2));
        } catch (InputMismatchException e) {
            System.out.println("Operador no valido");
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } finally {
            lector.close();
        }
    }

    public static void division2() {
        try {
            System.out.print("Ingrese el numerador: ");
            int numerador = lector.nextInt();
            System.out.print("Ingrese el denominador: ");
            int denominador = lector.nextInt();

            int resultado = dividir(numerador, denominador);
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
            //LOGGER.error("¡Error aritmético! No se puede dividir por cero.");
            //LOGGER.debug("prueba");
            //System.out.println("¡Error aritmético! No se puede dividir por cero.");
        } finally {
            System.out.println("Se ha ejecutado el bloque finally.");
            lector.close(); // Cerramos el Scanner para liberar recursos
        }
    }

    private static int dividir(int op1, int op2) throws IllegalArgumentException {
        if (op2 == 0) {
            throw new IllegalArgumentException("El denomindador debe ser distinto a 0");
        }
        int resultado = op1 / op2;
        return resultado;
    }
}
