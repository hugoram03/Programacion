package EjercicioFinalMensajeria.Comparators;

import EjercicioFinalMensajeria.Clases.Mensaje;

import java.util.Comparator;

public class ComparatorDestinatarioA_Z implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o1.getUsuarioReceptor().compareTo(o2.getUsuarioReceptor());
    }
}