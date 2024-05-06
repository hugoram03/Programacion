package Juegos.Ahorcado;

public class Jugador {
    //TODO porque no lo unes todo y asi los jugadores son todos iguales?
    private String nombre;
    private Boolean haFallado;

    private int intentos = 12;
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador() {

    }

    public String getNombre() {
        return nombre;
    }

    public Boolean getHaFallado() {
        return haFallado;
    }

    public void setHaFallado(Boolean haFallado) {
        this.haFallado = haFallado;
    }
}
