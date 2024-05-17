package EjercicioFinal;

import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        System.out.println("---Bienvenido a tu banco de confianza---");
        System.out.println("¿Tienes ya cuenta en este banco? (s/n)");
        String txt = lector.nextLine();
        if (){

        }
        int opcion = 0;
        do {
            System.out.println("1- Crear Cuenta\n" +
                    "2- Realizar Deposito\n" +
                    "3- Realizar Retiro\n" +
                    "4- Consultar saldo\n" +
                    "0- Salir");
            opcion = lector.nextInt();
            lector.nextLine();
            switch (opcion){
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 0);
    }

    public static void crearCuenta() {
        System.out.println("---Creacion de Cuenta---");
        System.out.print("Numero de cuenta: ");
        String numCuenta = lector.nextLine();
        System.out.print("Saldo actual de la cuenta");
        int saldo = lector.nextInt();
        lector.nextLine();
        System.out.print("Titular de la cuenta: ");
        lector.nextLine();

    }
}
