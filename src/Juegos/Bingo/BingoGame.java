package Juegos.Bingo;

import java.util.ArrayList;

public class BingoGame {
    public ArrayList<Integer> bombo = new ArrayList<>();
    public ArrayList<Integer> numerosExtraidos = new ArrayList<>();

    public BingoGame() {

    }

    public ArrayList<Integer> llenarBombo() {
        for (int i = 1; i <= 90; i++) {
            bombo.add(i);
        }
        return bombo;
    }

    public int sacarBola() {
        if (bombo.size() > 0) {
            int numeroAleatorio = generarNumeroAleatorio(0, bombo.size() - 1);
            return bombo.remove(numeroAleatorio);
        } else {
            return -1;
        }
    }

    public void borrarBola(int numero) {
        int indice = bombo.indexOf(numero);
        if (indice != -1) {
            bombo.remove(indice);
        }
    }

    public int generarNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }

}
