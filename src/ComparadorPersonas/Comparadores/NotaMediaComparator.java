package ComparadorPersonas.Comparadores;

import ComparadorPersonas.Estudiante;

import java.text.Collator;
import java.util.Comparator;

public class NotaMediaComparator implements Comparator<Estudiante> {
    Collator miCollator = Collator.getInstance();
    @Override
    public int compare(Estudiante e1, Estudiante e2) {
        double resultado = Double.compare(e2.getNotaMedia(), e1.getNotaMedia());
        if (resultado == 0){
            resultado = miCollator.compare(e1.getEdad(), e2.getEdad());
        }
        return (int)resultado;
    }
}
