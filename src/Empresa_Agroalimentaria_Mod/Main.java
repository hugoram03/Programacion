package Empresa_Agroalimentaria_Mod;


public class Main {
    public static void main(String[] args) {
        Refrigerado r = new Refrigerado(null, 1, "12");
        Fresco f = new Fresco(null, 2, null, "España");
        Congelado c = new Congelado(null, 3, 30);
        Almacen.insertar(r);
        Almacen.insertar(f);
        Almacen.insertar(c);
        System.out.println(Almacen.verStock());
        System.out.println(Almacen.retirar());
        System.out.println("Stock restante Total: " + Almacen.getStockTotal());
        System.out.println("Stock restante Frescos: " + Almacen.getStockTotalFresco());
        System.out.println("Stock restante Refrigerados: " + Almacen.getStockTotalRefrigerado());
        System.out.println("Stock restante Congelados: " + Almacen.getStockTotalCongelado());
    }
}
