package EjercicioFinalMensajeria.Comparators;

import EjercicioFinalMensajeria.Clases.Mensaje;

import java.util.Comparator;

public class ComparatorEmisorA_Z implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o1.getUsuarioEmisor().compareTo(o2.getUsuarioEmisor());
    }
}