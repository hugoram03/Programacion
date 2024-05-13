package Ejercicios_Map.Gestion_Empleados;

import java.util.LinkedHashMap;
import java.util.Map;

public class Empresa {
    private Map<Integer, String> empleados = new LinkedHashMap<>();

    public Map<Integer, String> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Map<Integer, String> empleados) {
        this.empleados = empleados;
    }

    public Map agregarEmpleados(Empleado empleado) {
        empleados.put(empleado.getId(), empleado.getNombre());
        return empleados;
    }

    public void buscarEmpleado(Empleado empleado) {
        for (Integer i : empleados.keySet()) {
            if (i == empleado.getId()) {
                System.out.println("EMPLEADO EMCONTRADO");
                System.out.println(empleado.getNombre() + " con id " + empleado.getId() + " que tiene rango " + empleado.getRango());

            } else {
                System.out.println("EMPLEADO NO ENCONTRADO");

            }
        }
    }

    public Map eliminarEmpleado(Empleado empleado) {
        for (Integer i : empleados.keySet()) {
            if (i == empleado.getId()){
                empleados.remove(i);
            }
        }
        return empleados;
    }
}
