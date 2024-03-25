package Ejercicios_Try_Catch.SistemaAcceso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner lector = new Scanner(System.in);
    static File nuevosUsuarios = new File("src\\Ejercicios_Try_Catch\\SistemaAcceso\\nuevosUsuarios.txt");

    public static void main(String[] args) throws MaEx, IOException {
        String opcion;
        do {
            System.out.println("|Sistema de acceso|");
            System.out.println("Estas registrado en el sistema de acceso? (si/no) ('fin' para salir)");
            opcion = lector.next();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.print("Usuario: ");
                String usuario = lector.next();
                System.out.print("Contraseña: ");
                String contraseña = lector.next();
                try {
                    if (Sistema.verificarAcceso(usuario, contraseña)) {
                        menu(lector, usuario, contraseña);
                    }
                } catch (MaEx e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion.equalsIgnoreCase("no")) {
                añadirUsuarioNuevo();
            }
        } while (!opcion.equalsIgnoreCase("fin"));
    }

    private static void menu(Scanner lector, String usuario, String contrasena) throws MaEx {
        int opcion = 0;
        do {
            System.out.println("Que desea hacer? (0 - salir | 1 - cambiar contraseña)");
            opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    String nuevaContraseña;
                    do {
                        System.out.println("Intrpduce la nueva Contraseña: ");
                        nuevaContraseña = lector.next();
                        if (nuevaContraseña.equals(contrasena)) {
                            System.out.println("La nueva contraseña no puede ser la misma que la que ya tenias, vuelve a introducir la contraseña otra vez");
                        }
                    } while (contrasena.equals(nuevaContraseña));
                    Sistema.cambiarContraseña(usuario, nuevaContraseña);
                    break;
                default:
                    throw new MaEx("Opcion incorrecta el valor tiene que ser 0 o 1");
            }
        } while (opcion != 0);
    }

    public static void añadirUsuarioNuevo() throws IOException {
        System.out.println("Rellena estos datos para registrarte.");
        System.out.print("Usuario: ");
        String usuario = lector.next();
        System.out.print("Contraseña: ");
        String contraseña = lector.next();
        Sistema.usuarios.add(new Usuario(usuario, contraseña));

    }
}