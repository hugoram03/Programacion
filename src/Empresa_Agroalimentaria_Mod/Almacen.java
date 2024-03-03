package Empresa_Agroalimentaria_Mod;

import java.util.ArrayList;
import java.util.Scanner;

public class Almacen {
    static Scanner lector = new Scanner(System.in);
    public static ArrayList<Producto> productosAlamcenados = new ArrayList<Producto>();
    private static final int STOCK_MAX = 1000;
    private static int stockTotal;

    static int stockFresco;
    static int stockRefrigerado;
    static int stockCongelado;
    public static int getStockTotal() {
        return stockTotal;
    }

    public static void insertar(Producto producto) {

        int stock;
        switch (producto.obtenerTipo()) {
            case "Fresco":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockFresco = lector.nextInt();
                break;
            case "Refrigerado":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockRefrigerado = lector.nextInt();
                break;
            case "Congelado":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockCongelado = lector.nextInt();
                break;
        }
        if (((stockFresco + stockRefrigerado + stockCongelado) + stockTotal) > STOCK_MAX) {
            System.out.println("El producto no se puede almacenar por que no hay suficiente espacio");
        } else {
            stockTotal = stockFresco + stockRefrigerado + stockCongelado;
            productosAlamcenados.add(producto);
        }
    }

    public static String verStock() {
        String frase = "";
        if (productosAlamcenados.isEmpty()) {
            return "0";
        } else {
            for (int i = 0; i < productosAlamcenados.size(); i++) {
                if (productosAlamcenados.get(i).obtenerTipo().equals("Fresco")){
                    frase += productosAlamcenados.get(i) + " Stock: " + stockFresco + "\n";
                } else if (productosAlamcenados.get(i).obtenerTipo().equals("Refrigerado")){
                    frase += productosAlamcenados.get(i) + " Stock: " + stockRefrigerado + "\n";
                } else {
                    frase += productosAlamcenados.get(i) + " Stock: " + stockCongelado + "\n";
                }
            }
            frase += "Stock Total: " + getStockTotal();
            return frase;
        }
    }

    public static String retirar() {
        System.out.println("Cantidad a retirar: ");
        int cantidad = lector.nextInt();

        if (cantidad > stockTotal) {
            cantidad = stockTotal;
            stockTotal -= cantidad;
            return "Stock disponible superado, stock retirado: " + cantidad;
        } else {
            stockTotal -= cantidad;
            return "Stock retirado: " + cantidad;
        }
    }
}