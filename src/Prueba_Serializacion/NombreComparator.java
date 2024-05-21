package Prueba_Serializacion;

import java.util.Comparator;

public class NombreComparator implements Comparator<Alumno> {
    @Override
    public int compare(Alumno o1, Alumno o2) {
        int resultado = o1.getNombre().compareTo(o2.getNombre());
        if (resultado == 0){
            resultado = Integer.compare(o2.getEdad(), o1.getEdad());
        }
        return resultado;
    }
}
