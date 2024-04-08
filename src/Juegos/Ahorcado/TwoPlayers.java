package Juegos.Ahorcado;

import java.util.ArrayList;

public class TwoPlayers extends Player {

    private Player player1 = new Player("jugador 1");
    private Player player2= new Player("jugador 2");

    public TwoPlayers(String nombre, Player player1, Player player2) {
        super(nombre);
        this.player1 = player1;
        this.player2 = player2;
    }

    public TwoPlayers() {

    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> listaJugadores = new ArrayList<>();
        listaJugadores.add(player1);
        listaJugadores.add(player2);
        return listaJugadores;
    }
}
