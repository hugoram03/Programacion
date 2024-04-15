package Juegos.MultiplicationGame;

import Juegos.Ahorcado.Jugador;

import java.util.ArrayList;

public class ThreePlayers extends TwoPlayers {

    private Jugador jugador3 = new Jugador("jugador 3");

    public ThreePlayers(String nombre, Jugador jugador1, Jugador jugador2, Jugador jugador3) {
        super(nombre, jugador1, jugador2);
        this.jugador3 = jugador3;
    }

    public ThreePlayers() {
    }

    public Jugador getPlayer3() {
        return jugador3;
    }

    public ArrayList<Jugador> getAllPlayers() {
        ArrayList<Jugador> listaJugadores = super.getAllPlayers();
        listaJugadores.add(jugador3);
        return listaJugadores;
    }
}
