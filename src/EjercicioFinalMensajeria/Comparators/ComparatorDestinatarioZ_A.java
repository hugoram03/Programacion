package EjercicioFinalMensajeria.Comparators;

import EjercicioFinalMensajeria.Clases.Mensaje;

import java.util.Comparator;

public class ComparatorDestinatarioZ_A implements Comparator<Mensaje> {
    @Override
    public int compare(Mensaje o1, Mensaje o2) {
        return o2.getUsuarioReceptor().compareTo(o1.getUsuarioReceptor());
    }
}