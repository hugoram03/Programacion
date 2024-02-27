package EmpresaAgroalimentaria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static ArrayList<Producto> productosAlmacenados;
    public static Scanner lector = new Scanner(System.in);
    public static void main(String[] args) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Bienvendo al servicio de almacenamiento de productos\n Que tipo de productos desea almacenar\n1-Frescos\n2-Refrigerados\n3-Congelados\nOpcion:");
        System.out.print(cadena);
        int opcion = lector.nextInt();
        menu(lector, opcion);
    }
    private static void menu(Scanner lector, int opcion) {
        switch (opcion){
            case 1:
                Fresco fresco = new Fresco(null, 0, 0,null,0,null,null);
                fresco.completarDatos(lector, fresco);
                productosAlmacenados.add(fresco);
                break;
            case 2:
                Refrigerado refrigerado = new Refrigerado(null, 0,0,null,0,0);
                refrigerado.completarDatos(lector, refrigerado);
                productosAlmacenados.add(refrigerado);
                break;
            case 3:
                Congelado congelado = new Congelado(null, 0, 0, null, 0, 0);
                congelado.completarDatos(lector, congelado);
                productosAlmacenados.add(congelado);
                break;
            default:
                System.out.println("La opcion no esta disponible");
                break;
        }
    }
}