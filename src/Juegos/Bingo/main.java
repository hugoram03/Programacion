package Juegos.Bingo;

import java.util.*;

public class main {
    public static void main(String[] args) {
        //int[][] bingoCard = generateBingoCard();
        //displayBingoCard(bingoCard);
        getCarton();
    }

    // Método para generar un cartón de bingo
    /*public static int[][] generateBingoCard() {
        int[][] card = new int[3][9]; // Cartón de 3 filas y 9 columnas

        Random random = new Random();

        // Generar números para cada columna
        for (int col = 0; col < 9; col++) {
            // Rango para esta columna (cada fila tiene un rango de 10 en 10)
            int min = col * 10 + 1;
            int max = (col + 1) * 10;

            int cont = 0;
            while (cont < 5) {
                int numero = random.nextInt(1 - 0 + 1);
                if (numero == 0) {
                    int num = random.nextInt(max - min + 1) + min;
                    if (!numbers.contains(num)) {
                        numbers.add(num);
                    }
                } else {

                }
            }
                numbers.add(0);




            // Colocar los números en las filas
            for (int i = 0; i < 3; i++) {
                card[i][col] = 0;
            }
        }
        return card;
    }

    // Método para mostrar el cartón de bingo
    public static void displayBingoCard(int[][] card) {
        System.out.println("B   I   N   G   O");
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                int num = card[i][j];
                System.out.print(String.format("%2d", num));

                System.out.print("  ");
            }
            System.out.println();
        }
    }*/
    public static String[][] getCarton() {
        Random random = new Random();
        String[][] carton = new String[3][9];
        for (int fila = 0; fila < carton.length; fila++) {
            int cont = 0;
            for (int col = 0; col < carton[fila].length; col++) {
                int min = col * 10 + 1;
                int max = (col + 1) * 10 - 1;
                if (cont < 5) {
                    int numero = random.nextInt(1 - 0 + 1);
                    if (numero == 0) {
                        int num = random.nextInt(max - min + 1) + min;
                        carton[fila][col] = " " + num + " ";
                        cont++;
                    } else {
                        carton[fila][col] = " -1 ";
                    }
                } else {
                    carton[fila][col] = "   ";
                }
                System.out.print(carton[fila][col]);
            }
            System.out.println();
        }


        return carton;
    }
}