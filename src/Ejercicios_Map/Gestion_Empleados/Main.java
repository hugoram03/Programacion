package Ejercicios_Map.Gestion_Empleados;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Rango rangoBasico = Rango.BASICO;
        Empleado e1 = new Empleado(1, "Hugo", rangoBasico);
        Empleado e2 = new Empleado(2, "Hugo", rangoBasico);
        Empleado e3 = new Empleado(3, "Hugo", rangoBasico);
        empresa.agregarEmpleados(e1);
        empresa.agregarEmpleados(e2);
        empresa.agregarEmpleados(e3);
        empresa.buscarEmpleado(e1);
        empresa.eliminarEmpleado(e1);
        empresa.buscarEmpleado(e1);
    }
}
