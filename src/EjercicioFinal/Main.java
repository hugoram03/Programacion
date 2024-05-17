package EjercicioFinal;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    static Scanner lector = new Scanner(System.in);

    public static void main(String[] args) {
        menu();

    }

    public static void menu() {
        System.out.println("---Bienvenido a tu banco de confianza---");
        System.out.println("¿Tienes ya eres cliente de este banco? (s/n)");
        String txt = lector.nextLine();
        Cliente c = null;
        if (txt.equalsIgnoreCase("n")) {
            c = crearCliente();
        } else {
        }
        int opcion = 0;
        do {
            try {
                System.out.println("1- Crear Cuenta\n" +
                        "2- Realizar Deposito\n" +
                        "3- Realizar Retiro\n" +
                        "4- Consultar saldo\n" +
                        "0- Salir");
                opcion = lector.nextInt();
                lector.nextLine();
            } catch (NumberFormatException e) {

            }
            switch (opcion) {
                case 1:
                    crearCuenta(c);
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

    public static Cliente crearCliente() {
        System.out.println("---Creacion de Cliente---");
        System.out.println("Nombre: ");
        String nombre = lector.nextLine();
        System.out.println("Direccion: ");
        String direccion = lector.nextLine();
        return new Cliente(nombre, direccion);
    }

    public static void crearCuenta(Cliente cliente) {
        System.out.println("---Creacion de Cuenta---");
        System.out.print("Numero de cuenta: ");
        String numCuenta = lector.nextLine();
        System.out.print("Saldo actual de la cuenta");
        double saldo = lector.nextDouble();
        lector.nextLine();
        System.out.print("Titular de la cuenta: ");
        String titular = lector.nextLine();
        cliente.agregarCuenta(new Cuenta(numCuenta, saldo, titular));
    }
}
