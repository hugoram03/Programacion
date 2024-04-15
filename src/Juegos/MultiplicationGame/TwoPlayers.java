package Juegos.MultiplicationGame;

import Juegos.Ahorcado.Jugador;

import java.util.ArrayList;

public class TwoPlayers extends Jugador {

    private Jugador jugador1 = new Jugador("jugador 1");
    private Jugador jugador2 = new Jugador("jugador 2");

    public TwoPlayers(String nombre, Jugador jugador1, Jugador jugador2) {
        super(nombre);
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public TwoPlayers() {

    }

    public Jugador getPlayer1() {
        return jugador1;
    }

    public Jugador getPlayer2() {
        return jugador2;
    }

    public ArrayList<Jugador> getAllPlayers() {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();
        listaJugadores.add(jugador1);
        listaJugadores.add(jugador2);
        return listaJugadores;
    }
}
