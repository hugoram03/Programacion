package Empresa_Agroalimentaria_Mod;

import java.util.ArrayList;
import java.util.Scanner;

public class Almacen {
    private static Scanner lector = new Scanner(System.in);
    private static final int STOCK_MAX = 1000;
    public ArrayList<Producto> productosAlamcenados = new ArrayList<>();
    private int stockTotal;
    private int stockTotalFresco;
    private int stockFresco;
    private int stockTotalRefrigerado;
    private int stockRefrigerado;
    private int stockTotalCongelado;
    private int stockCongelado;

    public int getStockTotal() {
        return stockTotal;
    }

    public void insertar(Producto producto) {

        int stock;
        switch (producto.obtenerTipo()) {
            case "Fresco":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockFresco = lector.nextInt();
                stockTotalFresco += stockFresco;
                break;
            case "Refrigerado":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockRefrigerado = lector.nextInt();
                stockTotalRefrigerado += stockRefrigerado;
                break;
            case "Congelado":
                System.out.println("Stock del producto: " + producto.getClass().getSimpleName());
                stockCongelado = lector.nextInt();
                stockTotalCongelado += stockCongelado;
                break;
            default:
                System.out.println("Producto no valido");
                break;
        }
        if (((stockFresco + stockRefrigerado + stockCongelado) + stockTotal) > STOCK_MAX) {
            System.out.println("El producto no se puede almacenar por que no hay suficiente espacio");
        } else {
            stockTotal = stockTotalFresco + stockTotalRefrigerado + stockTotalCongelado;
            productosAlamcenados.add(producto);
        }



    }

    public String verStock() {
        String frase = "";
        if (productosAlamcenados.isEmpty()) {
            return "0";
        } else {
            for (int i = 0; i < productosAlamcenados.size(); i++) {
                if (productosAlamcenados.get(i).obtenerTipo().equals("Fresco")) {
                    frase += productosAlamcenados.get(i) + " Stock: " + stockFresco + "\n";
                } else if (productosAlamcenados.get(i).obtenerTipo().equals("Refrigerado")) {
                    frase += productosAlamcenados.get(i) + " Stock: " + stockRefrigerado + "\n";
                } else {
                    frase += productosAlamcenados.get(i) + " Stock: " + stockCongelado + "\n";
                }
            }
            frase += "Stock Total: " + getStockTotal();
            return frase;
        }
    }

    public String retirar() {
        int cantidad = 0;
        System.out.println("¿Que tipo de producto quieres retirar? (Fresco: " + stockTotalFresco + " /Refrigerado: " + stockTotalRefrigerado + " /Congelado: " + stockTotalCongelado + ")");
        String opcion = lector.next();
        switch (opcion) {
            case "Fresco":
                System.out.println("Cantidad a retirar: ");
                cantidad = lector.nextInt();
                return retirarProductoFresco(cantidad);
            case "Refrigerado":
                System.out.println("Cantidad a retirar: ");
                cantidad = lector.nextInt();
                return retirarProductoRefrigerado(cantidad);

            case "Congelado":
                System.out.println("Cantidad a retirar: ");
                cantidad = lector.nextInt();
                return retirarProductoCongelado(cantidad);
            default:
                return "Producto no valido";
        }
    }

    private String retirarProductoFresco(int cantidad) {
        if (cantidad > stockTotalFresco) {
            cantidad = stockTotalFresco;
            stockTotalFresco -= cantidad;
            return "Stock disponible superado, stock retirado: " + cantidad;
        } else {
            stockTotalFresco -= cantidad;
            stockTotal -= cantidad;
            return "Stock retirado: " + cantidad;
        }
    }

    private String retirarProductoRefrigerado(int cantidad) {
        if (cantidad > stockTotalRefrigerado) {
            cantidad = stockTotalRefrigerado;
            stockTotalRefrigerado -= cantidad;
            return "Stock disponible superado, stock retirado: " + cantidad;
        } else {
            stockTotalRefrigerado -= cantidad;
            stockTotal -= cantidad;
            return "Stock retirado: " + cantidad;
        }
    }

    private String retirarProductoCongelado(int cantidad) {
        if (cantidad > stockTotalCongelado) {
            cantidad = stockTotalCongelado;
            stockTotalCongelado -= cantidad;
            return "Stock disponible superado, stock retirado: " + cantidad;
        } else {
            stockTotalCongelado -= cantidad;
            stockTotal -= cantidad;
            return "Stock retirado: " + cantidad;
        }

    }

    public void setStockTotal(int stockTotal) {
        this.stockTotal = stockTotal;
    }

    public int getStockTotalFresco() {
        return stockTotalFresco;
    }

    public void setStockTotalFresco(int stockTotalFresco) {
        this.stockTotalFresco = stockTotalFresco;
    }

    public int getStockFresco() {
        return stockFresco;
    }

    public void setStockFresco(int stockFresco) {
        this.stockFresco = stockFresco;
    }

    public int getStockTotalRefrigerado() {
        return stockTotalRefrigerado;
    }

    public void setStockTotalRefrigerado(int stockTotalRefrigerado) {
        this.stockTotalRefrigerado = stockTotalRefrigerado;
    }

    public int getStockRefrigerado() {
        return stockRefrigerado;
    }

    public void setStockRefrigerado(int stockRefrigerado) {
        this.stockRefrigerado = stockRefrigerado;
    }

    public int getStockTotalCongelado() {
        return stockTotalCongelado;
    }

    public void setStockTotalCongelado(int stockTotalCongelado) {
        this.stockTotalCongelado = stockTotalCongelado;
    }

    public int getStockCongelado() {
        return stockCongelado;
    }

    public void setStockCongelado(int stockCongelado) {
        this.stockCongelado = stockCongelado;
    }

}