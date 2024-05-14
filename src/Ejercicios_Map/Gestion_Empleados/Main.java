package Ejercicios_Map.Gestion_Empleados;

public class Main {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Rango rangoBasico = Rango.BASICO;
        Rango rangoIntermedio = Rango.INTERMEDIO;
        Rango rangoExperto = Rango.EXPERTO;
        Empleado e1 = new Empleado(1, "Hugo", rangoBasico);
        Empleado e2 = new Empleado(2, "Raul", rangoIntermedio);
        Empleado e3 = new Empleado(56, "Adrian", rangoExperto);
        Empleado e4 = new Empleado(8, "Adrian", rangoExperto);
        Empleado e5 = new Empleado(3, "Adrian", rangoExperto);

        empresa.agregarEmpleados(e1);
        empresa.agregarEmpleados(e2);
        empresa.agregarEmpleados(e3);
        empresa.agregarEmpleados(e4);
        empresa.agregarEmpleados(e5);
        empresa.buscarEmpleado(e1);
        empresa.eliminarEmpleado(e2.getId());
        empresa.buscarEmpleado(e2);
        System.out.println(empresa.getEmpleados());
    }
}
