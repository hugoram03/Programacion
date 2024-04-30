package Juegos.Bingo;

import java.util.ArrayList;

public class BingoGame {
    private ArrayList<Integer> bombo = new ArrayList<>();

    public BingoGame() {

    }

    public ArrayList<Integer> llenarBombo() {
        for (int i = 1; i <= 90; i++) {
            bombo.add(i);
        }
        return bombo;
    }

    public int sacarBola() {
        int bola;
        bola = generarNumeroAleatorio(bombo.get(0), bombo.get(bombo.size() -1));
        return bola;
    }
    public void borrarBola(int indice){
        bombo.remove(indice);
    }

    public int generarNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }
}
