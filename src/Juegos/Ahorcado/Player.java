package Juegos.Ahorcado;

public class Player {
    private String nombre;
    private Boolean haFallado;

    private int intentos = 12;
    public Player(String nombre) {
        this.nombre = nombre;
    }

    public Player() {

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
