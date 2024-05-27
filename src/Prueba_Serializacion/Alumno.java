package Prueba_Serializacion;

import java.io.Serializable;

public class Alumno implements Serializable {
    private String nombre;
    private int edad;
    private String nia;

    public Alumno(String nombre, int edad, String nia) {
        this.nombre = nombre;
        this.edad = edad;
        this.nia = nia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNia() {
        return nia;
    }

    public void setNia(String nia) {
        this.nia = nia;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", nia='" + nia + '\'' +
                '}';
    }

}
