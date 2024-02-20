package Pruebas;


public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Hugo", "Ramirez", 20, 1500);
        Empleado emp1 = new Empleado("Virginia", "Ramirez", 20, 1500);
        Comercial c = new Comercial("Adrian", "Ramirez", 20, 1500, 100);
        Comercial c1 = new Comercial("Francisco", "Ramirez", 20, 1500, 10);
        Repartidor r = new Repartidor("Daniel", "Ramirez", 20, 1500, 1);
        Empleado[] empleados = {emp, emp1, c, c1, r};

        for (Empleado e: empleados) {
            if (e instanceof Comercial){
                System.out.println(e.getNombre() + " pertenece a la clase Comercial");
            }else if (e instanceof Repartidor){
                System.out.println(e.getNombre() + " pertenece a la clase Repartidor");
            } else {
                System.out.println(e.getNombre() + " pertenece a la clase Empleado");
            }
        }
        //System.out.println(c);

        //System.out.println(emp.equals(emp1));
        //System.out.println(c.equals(c1));
    }
}
