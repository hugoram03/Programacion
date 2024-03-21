package Ejercicios_Try_Catch.SistemaAcceso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner lector = new Scanner(System.in);
    static Usuario hugo = new Usuario("hugo", "1234");
    static Usuario adrian = new Usuario("adrian", "4321");
    static File nuevosUsuarios = new File("src\\Ejercicios_Try_Catch\\SistemaAcceso\\nuevosUsuarios.txt");

    public static void main(String[] args) throws MaEx, IOException {

        System.out.println("|Sistema de acceso|");
        System.out.println("Estas registrado en el sistema de acceso? (si/no)");
        String opcion = lector.nextLine();
        if (opcion.equalsIgnoreCase("si")) {
            try {
                verificarAcceso(hugo);
                menu(lector);
            } catch (MaEx e) {
                System.out.println(e.getMessage());
            }
        } else {
            añadirUsuarioNuevo();
        }
    }

    private static void menu(Scanner lector) throws MaEx {
        int opcion = 0;
        do {
            System.out.println("Que desea hacer? (0 - salir | 1 - cambiar contraseña)");
            opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    cambiarContraseña(hugo);
                    break;
                default:
                    throw new MaEx("Opcion incorrecta el valor tiene que ser 0 o 1");
            }
        } while (opcion != 0);
    }

    private static void cambiarContraseña(Usuario usuario) throws MaEx {
        System.out.print("Introduzca la nueva contraseña: ");
        String nuevaContraseña = lector.next();
        if (nuevaContraseña.equals(usuario.getContraseña())) {
            throw new MaEx("La contraseña a cambiar no puede ser la misma que ya tenia");
        }
        usuario.setContraseña(nuevaContraseña);
        System.out.println("Contraseña cambiada con exito!");
    }

    private static void verificarAcceso(Usuario u1) throws MaEx {
        System.out.println();
        System.out.print("Introduce el usuario: ");
        String usuario = lector.next();
        System.out.print("Introduce la contraseña: ");
        String contraseña = lector.next();
        if (!usuario.equals(u1.getUsuario()) || !contraseña.equals(u1.getContraseña())) {
            throw new MaEx("Usuario o contraseña incorrecto");
        }
        System.out.println("Bienvenido " + u1.getUsuario());
    }

    public static void añadirUsuarioNuevo() throws IOException {
        FileWriter fileWriter = new FileWriter(nuevosUsuarios, true);
        System.out.println("Rellena estos datos para registrarte.");
        System.out.print("Usuario: ");
        String usuario = lector.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = lector.nextLine();
        fileWriter.write("Usuario: " + usuario + " Contraseña: " + contraseña + "\n");
        fileWriter.close();
    }
}