package Prueba_Serializacion;

import java.io.Serializable;
import java.util.*;

public class Grupo implements Serializable {

    private ArrayList<Alumno> grupo = new ArrayList();

    public Grupo() {
    }
    public void agregarAlumno(Alumno alumno){
        grupo.add(alumno);
    }
    public void mostrarAlumnos(){
        for (Alumno a : grupo) {
            System.out.println(a);
        }
    }

    public ArrayList<Alumno> getGrupo() {
        return grupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grupo grupo1 = (Grupo) o;
        return Objects.equals(grupo, grupo1.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(grupo);
    }
}
