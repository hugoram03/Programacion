package Juegos.Bingo;

import java.util.Objects;

public class JugadorBingo {
    private String nombre;
    private int edad;
    private String ciudad;
    private Carton cartonJugador;

    public JugadorBingo(String nombre, int edad, String ciudad, Carton cartonJugador) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.cartonJugador = cartonJugador;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Carton getCartonJugador() {
        return cartonJugador;
    }

    public void setCartonJugador(Carton cartonJugador) {
        this.cartonJugador = cartonJugador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorBingo that = (JugadorBingo) o;
        return edad == that.edad && Objects.equals(nombre, that.nombre) && Objects.equals(ciudad, that.ciudad) && Objects.equals(cartonJugador, that.cartonJugador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, edad, ciudad, cartonJugador);
    }

    @Override
    public String toString() {
        return "JugadorBingo{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", ciudad='" + ciudad + '\'' +
                ", cartonJugador=" + cartonJugador +
                '}';
    }
}
