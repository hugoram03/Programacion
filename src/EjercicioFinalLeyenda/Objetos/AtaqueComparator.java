package EjercicioFinalLeyenda.Objetos;

import java.util.Comparator;

public class AtaqueComparator implements Comparator<Arma>{
    @Override
    public int compare(Arma o1, Arma o2) {
        return Integer.compare(o1.getAtaque(), o2.getAtaque());
    }
}