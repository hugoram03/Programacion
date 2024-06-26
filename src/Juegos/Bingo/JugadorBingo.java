package Juegos.Bingo;

import java.util.ArrayList;
import java.util.Objects;

public class JugadorBingo {
    //TODO porque no lo unes todo y asi los jugadores son todos iguales? El hecho de distinguir entre jugadores bingo o jugadores normales es un poco confuso
    private BingoGame bingoGame = new BingoGame();
    private String nombre;
    private int edad;
    private String ciudad;
    private int[][] cartonJugador;
    private int contadorNums;


    public JugadorBingo(String nombre, int edad, String ciudad, int[][] cartonJugador) {
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

    public int[][] getCartonJugador() {
        return cartonJugador;
    }

    public int getContadorNums() {
        return contadorNums;
    }

    //TODO Nombre del metodo poco claro
    public void setContadorNums() {
        this.contadorNums++;
    }

    public Boolean compararNumero(int numero) {
        if (!bingoGame.numerosExtraidos.contains(numero)) {
            bingoGame.numerosExtraidos.add(numero);
        }
        boolean encuentraNumero = false;
        for (int i = 0; i < cartonJugador.length; i++) {
            for (int j = 0; j < cartonJugador[i].length; j++) {
                if (bingoGame.numerosExtraidos.contains(cartonJugador[i][j])) {
                    System.out.print("(" + cartonJugador[i][j] + ")");
                } else if (cartonJugador[i][j] == -1) {
                    System.out.print("  ");
                } else {
                    System.out.print(cartonJugador[i][j] + " ");
                }
                if (cartonJugador[i][j] == numero){
                    encuentraNumero = true;
                }
            }
            System.out.println();
        }
        return encuentraNumero;
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
