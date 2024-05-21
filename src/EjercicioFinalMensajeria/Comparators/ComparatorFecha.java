package EjercicioFinalMensajeria.Comparators;

import EjercicioFinalMensajeria.Clases.Mensaje;

import java.util.Comparator;

public class ComparatorFecha implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o1.getFechaHora().compareTo(o2.getFechaHora());
    }
}