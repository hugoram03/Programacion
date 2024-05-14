package Ejercicios_Map.Gestion_Empleados;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Empresa {
    private Map<Integer, String> empleados = new TreeMap<>();

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
                return;
            } else {
                System.out.println("EMPLEADO NO ENCONTRADO");
                return;
            }
        }
    }

    public void eliminarEmpleado(int id) {
        if (empleados.containsKey(id)){
            System.out.println("Eliminando el empleado con el id: " + id);
            empleados.remove(id);
        } else {
            System.out.println("Empleado no encontrado");
        }
    }
}
