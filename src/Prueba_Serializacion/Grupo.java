package Prueba_Serializacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Grupo implements Serializable {
    private Collection<Alumno> grupo = new ArrayList();

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
}
