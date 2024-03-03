package EmpresaAgroalimentaria;

import java.util.Scanner;

public interface IUtilidades {
    abstract Object completarDatos(Scanner lector, Object o);
    default  int sumaStock(int stock){
        int stockTotal = 0;
        stockTotal += stock;
        return stockTotal;
    }
}
