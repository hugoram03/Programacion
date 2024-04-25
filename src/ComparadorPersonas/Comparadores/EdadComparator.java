package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.time.LocalDate;
import java.util.Comparator;

public class EdadComparator implements Comparator<Estudiante> {
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        int resultado = e1.getEdad().compareTo(e2.getEdad());
        if (resultado == 0){
            resultado = e1.getNombre().compareTo(e2.getNombre());
        }
        return resultado;
    }
}
