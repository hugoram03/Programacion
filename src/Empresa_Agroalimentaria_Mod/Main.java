package Empresa_Agroalimentaria_Mod;


public class Main {
    public static void main(String[] args) {
        Refrigerado r = new Refrigerado(null, 1, "12");
        Fresco f = new Fresco(null, 2, null, "España");
        Congelado c = new Congelado(null, 3, 30);
        Almacen a = new Almacen();
        a.insertar(r);
        a.insertar(f);
        a.insertar(c);
        System.out.println(a.verStock());
        System.out.println(a.retirar());
        System.out.println("Stock restante Total: " + a.getStockTotal());
        System.out.println("Stock restante Frescos: " + a.getStockTotalFresco());
        System.out.println("Stock restante Refrigerados: " + a.getStockTotalRefrigerado());
        System.out.println("Stock restante Congelados: " + a.getStockTotalCongelado());
    }
}
