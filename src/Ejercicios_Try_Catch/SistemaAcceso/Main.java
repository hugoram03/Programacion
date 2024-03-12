package Ejercicios_Try_Catch.SistemaAcceso;

import java.util.Scanner;

public class Main {

    static Scanner lector = new Scanner(System.in);
    static Usuario hugo = new Usuario("hugo", "1234");
    static Usuario adrian = new Usuario("adrian", "4321");

    public static void main(String[] args) throws MaEx {
        System.out.println("|Sistema de acceso|");
        try {
            verificarAcceso(hugo);
            menu(lector);
        } catch (MaEx e) {
            System.out.println(e.getMessage());
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
}