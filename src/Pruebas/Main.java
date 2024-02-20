package Pruebas;


public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
       //Empleado emp = new Empleado("Hugo", "Ramirez", 20, 1500);
        //Empleado emp1 = new Empleado("Virginia", "Ramirez", 20, 1500);
        Coche coche1 = new Coche("Audi", "Gris");
        Coche coche2 = new Coche("BMW", "Azul");
        Comercial c = new Comercial("Adrian", "Ramirez", 20, 1500, 100, coche1);
        Comercial c1 = new Comercial("Francisco", "Ramirez", 20, 1500, 10, coche2);
        //Repartidor r = new Repartidor("Daniel", "Ramirez", 20, 1500, 1);
        //mpleado[] empleados = {emp, emp1, c, c1, r};
/*
        for (Empleado e: empleados) {
            if (e instanceof Comercial){
                System.out.println(e.getNombre() + " pertenece a la clase Comercial");
            }else if (e instanceof Repartidor){
                System.out.println(e.getNombre() + " pertenece a la clase Repartidor");
            } else {
                System.out.println(e.getNombre() + " pertenece a la clase Empleado");
            }
        }*/
        //System.out.println(c);
        Comercial cClone = (Comercial) c1.clone();
        System.out.println(cClone);
        //System.out.println(emp.equals(emp1));
        //System.out.println(c.equals(c1));
    }
}
