package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.text.Collator;
import java.util.Comparator;

public class NombreComparator implements Comparator<Estudiante> {
    Collator miCollator = Collator.getInstance();
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        miCollator.setStrength(Collator.TERTIARY);
        int resultado = miCollator.compare(e1.getNombre(), e2.getNombre());
        if (resultado == 0){
            resultado = miCollator.compare(e1.getApellidos(), e2.getApellidos());
        }
        return resultado;
    }
}
