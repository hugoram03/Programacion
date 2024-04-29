package Juegos.Bingo;

import java.util.Random;

public class Carton {
    public String[][] getCarton() {
        Random random = new Random();
        String[][] carton = new String[3][9];
        for (int fila = 0; fila < carton.length; fila++) {
            for (int col = 0; col < carton[fila].length; col++) {
                int min = col * 10 + 1;
                int max = (col + 1) * 10;
                int cont = 0;
                if (cont < 5) {
                    int numero = random.nextInt(1 - 0 + 1);
                    if (numero == 0) {
                        int num = random.nextInt(max - min + 1) - min;
                        carton[fila][col] = num + "";
                        cont++;
                    } else {
                        carton[fila][col] = "-1";
                    }
                } else {
                    carton[fila][col] = "  ";
                }
                System.out.print(carton[fila][col]);
            }
            System.out.println();
        }


        return carton;
    }
}