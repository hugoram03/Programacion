package EjercicioFinal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner lector = new Scanner(System.in);
    static Banco banco = new Banco();
    static Logger LOGGER = LogManager.getRootLogger();
    static final File FICHERO = new File("src/EjercicioFinal/CuentasClientes.txt");
    static final File FICHERO2 = new File("src/EjercicioFinal/Serializable2.dat");

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        cargarFicheroSerializable();
        Cliente c = null;
        try {
            banco.cargarFichero(FICHERO);
            c = preguntarCliente(c);
            menu(c);
        } catch (NullPointerException e) {
            LOGGER.error("El cliente es nulo");
        } catch (IOException e) {
            LOGGER.error("Error al cargar el archivo");
        }
        lector.close();
        guardarFicheroSerializable();
    }

    public static void menu(Cliente c) {
        int opcion = 0;
        try {
            do {
                System.out.println("1- Crear Cuenta\n" +
                        "2- Realizar Deposito\n" +
                        "3- Realizar Retiro\n" +
                        "4- Consultar saldo\n" +
                        "5- Eliminar Cuenta\n" +
                        "0- Salir");
                opcion = lector.nextInt();
                lector.nextLine();
                switch (opcion) {
                    case 1:
                        crearCuenta(c);
                        break;
                    case 2:
                        realizarDeposito(c);
                        break;
                    case 3:
                        realizarRetiro(c);
                        break;
                    case 4:
                        consultarSaldo(c);
                        break;
                    case 5:
                        eliminarCuenta(c);
                        break;
                    default:
                        System.out.println("Saliendo del programa...");
                        banco.guardarFichero(FICHERO);
                        break;
                }
            } while (opcion != 0);
        } catch (NumberFormatException e) {
            LOGGER.error("El valor introducido no es un numero");
        } catch (IOException e) {
            LOGGER.error("Error al guardar el fichero");
        }
    }

    private static void eliminarCuenta(Cliente c) {
        String numCuenta;
        System.out.print("Escribe el numero de cuenta de la cuenta que quieres eliminar");
        numCuenta = lector.nextLine();
        c.eliminarCuenta(numCuenta);
    }

    private static void consultarSaldo(Cliente c) {
        int indice;
        do {
            System.out.print("Numero de cuenta de la que quieres consultar el saldo: (0-" + (c.getCuentasCliente().size() - 1) + ") ");
            indice = lector.nextInt();
        } while (indice > c.getCuentasCliente().size());
        System.out.println("El saldo de la cuenta es: " + c.getCuentasCliente().get(indice).getSaldo() + "€");
    }

    private static void realizarRetiro(Cliente c) {
        int indice;
        do {
            System.out.print("Numero de cuenta de la que quieres retirar saldo (0-" + (c.getCuentasCliente().size() - 1) + ") ");
            indice = lector.nextInt();
        } while (indice > c.getCuentasCliente().size());
        System.out.println("Saldo actual: " + c.getCuentasCliente().get(indice).getSaldo() + "€");
        System.out.print("Cuanto saldo quieres retirar: ");
        double saldo = lector.nextDouble();
        if (saldo > c.getCuentasCliente().get(indice).getSaldo()) {
            System.out.println("Lo siento no se puede retirar " + saldo + "€ por que excede de la cantidad total de tu cuenta");
        } else {
            c.getCuentasCliente().get(indice).retirar(saldo);
            System.out.println("SALDO RETIRADO");
        }
    }

    private static void realizarDeposito(Cliente c) {
        int indice;
        do {
            System.out.print("Numero de cuenta a la que quieres añadir dinero: (0-" + (c.getCuentasCliente().size() - 1) + ") ");
            indice = lector.nextInt();
        } while (indice > c.getCuentasCliente().size());
        System.out.print("Cantidad de dinero a ingresar: ");
        int dinero = lector.nextInt();
        c.getCuentasCliente().get(indice).depositar(dinero);
        System.out.println("SALDO INGRESADO");
    }

    public static Cliente preguntarCliente(Cliente c) {

        System.out.println("---Bienvenido a tu banco de confianza---");
        System.out.println("¿Ya eres cliente de este banco? (s/n)");
        String txt = lector.nextLine();
        if (txt.equalsIgnoreCase("n")) {
            c = crearCliente();
            banco.agregarCliente(c);
            System.out.println("Cliente registrado correctamente");
        } else {
            System.out.println("Introduce tu nombre: ");
            String nombre = lector.nextLine();
            c = banco.comprobarCliente(nombre);
        }
        return c;
    }

    public static Cliente crearCliente() {
        Cliente cliente = null;
        System.out.println("---Creacion de Cliente---");
        System.out.println("Nombre: ");
        String nombre = lector.nextLine();
        System.out.println("Direccion: ");
        String direccion = lector.nextLine();
        cliente = new Cliente(nombre, direccion);
        crearCuenta(cliente);
        return cliente;
    }

    public static void crearCuenta(Cliente cliente) {
        System.out.println("---Creacion de Cuenta---");
        System.out.print("Numero de cuenta: ");
        String numCuenta = lector.nextLine();
        double saldo = 0;
        try {
            System.out.print("Saldo actual de la cuenta: ");
            saldo = lector.nextDouble();
            lector.nextLine();
        } catch (InputMismatchException e) {
            LOGGER.error("Valor erroneo ofrecido a Saldo");
        }
        System.out.print("Titular de la cuenta: ");
        String titular = lector.nextLine();
        cliente.agregarCuenta(new Cuenta(numCuenta, saldo, titular));
    }

    public static void guardarFicheroSerializable() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FICHERO2);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(banco);
        objectOutputStream.close();
    }

    public static void cargarFicheroSerializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FICHERO2));
        banco = (Banco) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(banco);
    }
}