package Juegos.Bingo;

import java.util.ArrayList;

public class BingoGame {
    private ArrayList<JugadorBingo> jugadores = new ArrayList<>();

    public void anadirjugador(JugadorBingo j1){
        jugadores.add(j1);
    }
}
