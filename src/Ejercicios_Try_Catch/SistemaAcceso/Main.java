package Ejercicios_Try_Catch.SistemaAcceso;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Usuario hugo = new Usuario("hugo", "1234");
        Usuario adrian = new Usuario("adrian", "4321");

        System.out.println("|Sistema de acceso|");
        System.out.print("Introduce el usuario: ");
        String usuario = lector.nextLine();
        System.out.print("Introduce la contraseña: ");
        String contraseña = lector.nextLine();

    }
}
