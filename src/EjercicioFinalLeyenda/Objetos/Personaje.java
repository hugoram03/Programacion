package EjercicioFinalLeyenda.Objetos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Personaje implements Serializable {
    @Serial
    private static final long serialVersionUID = -68779914928840053L;
    private String nombre;
    private Arma arma;
    private Rol rol;
    private int oro;
    public Personaje(String nombre,Arma arma, Rol rol, int oro) {
        this.nombre = nombre;
        this.rol = rol;
        this.arma = arma;
        this.oro = oro;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Arma getArma() {
        return arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }
    public int getOro() {
        return oro;
    }
    public void setOro(int oro) {
        this.oro = oro;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    public void mostrarInfo() {
        System.out.println("El " + rol + " "+ nombre + " con el arma " + arma.getNom() + " con la cantidad de oro " + oro);
    }
    @Override
    public String toString() {
        return nombre + ":" + arma + ":" + rol + ":" + oro;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return oro == personaje.oro && Objects.equals(nombre, personaje.nombre) && Objects.equals(arma, personaje.arma) && rol == personaje.rol;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nombre, arma, rol, oro);
    }
}