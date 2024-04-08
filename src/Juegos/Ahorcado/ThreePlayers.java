package Juegos.Ahorcado;

import java.util.ArrayList;

public class ThreePlayers extends TwoPlayers {

    private Player player3 = new Player("jugador 3");

    public ThreePlayers(String nombre, Player player1, Player player2, Player player3) {
        super(nombre, player1, player2);
        this.player3 = player3;
    }

    public ThreePlayers() {
    }

    public Player getPlayer3() {
        return player3;
    }

    public ArrayList<Player> getAllPlayers() {
        ArrayList<Player> listaJugadores = super.getAllPlayers();
        listaJugadores.add(player3);
        return listaJugadores;
    }
}
