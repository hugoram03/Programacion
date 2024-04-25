package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.util.Comparator;

public class NotaMediaComparator implements Comparator<Estudiante> {

    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        double resultado = Double.compare(e2.getNotaMedia(), e1.getNotaMedia());
        if (resultado == 0){
            resultado = e1.getEdad().compareTo(e2.getEdad());
        }
        return (int)resultado;
    }
}
