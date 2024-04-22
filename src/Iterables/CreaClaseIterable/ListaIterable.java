package Iterables.CreaClaseIterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaIterable implements Iterable<Alumno> {
    private List<Alumno> alumnos = new ArrayList<>();

    public void anadir(Alumno alumno){
        alumnos.add(alumno);
    }

    @Override
    public Iterator<Alumno> iterator() {
        return alumnos.iterator();
    }
}
