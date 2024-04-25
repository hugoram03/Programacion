package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.util.Comparator;

public class NombreComparator implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        int resultado = e1.getNombre().compareTo(e2.getNombre());
        if (resultado == 0){
            resultado = e1.getApellidos().compareTo(e2.getApellidos());
        }
        return resultado;
    }
}
