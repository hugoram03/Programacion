package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Comparator;

public class EdadComparator implements Comparator<Estudiante> {
    Collator miCollator = Collator.getInstance();
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        int resultado = miCollator.compare(e1.getEdad(), e2.getEdad());
        if (resultado == 0){
            resultado = miCollator.compare(e1.getNombre(), e2.getNombre());
        }
        return resultado;
    }
}
