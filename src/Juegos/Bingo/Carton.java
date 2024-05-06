package Juegos.Bingo;

import java.util.Arrays;

public class Carton {
    public Carton() {

    }

    public  int[][] getCarton() {
        int[][] carton = new int[3][9];
        rellenarNumerosCarton(carton);
        ordenarColumnasCarton(carton);
        marcarHuecosCarton(carton);
        return carton;
    }

    public  void rellenarNumerosCarton(int[][] carton) {

        int numAleatorio;
        boolean repetido;

        for (int j = 0; j < carton[0].length; j++) {
            for (int i = 0; i < carton.length; i++) {
                do {
                    repetido = false;
                    switch (j) {
                        case 0:
                            numAleatorio = generarNumeroAleatorio(1, 9);
                            break;
                        case 8:
                            numAleatorio = generarNumeroAleatorio(80, 90);
                            break;
                        default:
                            numAleatorio = generarNumeroAleatorio(10 * j, (10 * j) + 9);
                            break;
                    }

                    if (i == 1 && carton[0][j] == numAleatorio) {
                        repetido = true;

                    } else if (i == 2 && (carton[0][j] == numAleatorio || carton[1][j] == numAleatorio)) {
                        repetido = true;
                    }

                } while (repetido);

                carton[i][j] = numAleatorio;
            }
        }
    }

    public  void ordenarColumnasCarton(int[][] carton) {

        int[] numeros = new int[3];
        for (int j = 0; j < carton[0].length; j++) {


            for (int i = 0; i < carton.length; i++) {
                numeros[i] = carton[i][j];
            }


            Arrays.sort(numeros);


            for (int i = 0; i < numeros.length; i++) {
                carton[i][j] = numeros[i];
            }

        }
    }

    public  void mostrarCarton(int[][] carton) {
        for (int i = 0; i < carton.length; i++) {
            for (int j = 0; j < carton[i].length; j++) {
                if (carton[i][j] == -1) {
                    if (j == 0) {
                        System.out.print("  ");
                    } else {
                        System.out.print("   ");
                    }
                } else {
                    System.out.print(carton[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //TODO metodo muy muy complejo, intentar diseccionarlo en metodos mas pequeños
    public int[][] marcarHuecosCarton(int[][] carton) {
        int[] arrayNumeros = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int posicion;

        for (int i = 0; i < 3; i++) {
            do {
                posicion = generarNumeroAleatorio(0, arrayNumeros.length - 1);
            } while (arrayNumeros[posicion] == 2);

            arrayNumeros[posicion] = 2;
        }

        int[] huecosPorFila = new int[3];
        boolean[] filaDisponible;
        int menorNumeroHuecos, filaSeleccionada, huecosEnColumna;
        boolean sonIguales;

        for (int columna = 0; columna < carton[0].length; columna++) {
            filaDisponible = new boolean[]{true, true, true};
            sonIguales = true;
            for (int fila = 0; fila < huecosPorFila.length - 1 && sonIguales; fila++) {
                if (huecosPorFila[fila] != huecosPorFila[fila + 1]) {
                    sonIguales = false;
                }
            }

            if (!sonIguales) {
                menorNumeroHuecos = huecosPorFila[0];
                for (int fila = 1; fila < huecosPorFila.length; fila++) {
                    if (huecosPorFila[fila] < menorNumeroHuecos) {
                        menorNumeroHuecos = huecosPorFila[fila];
                    }
                }

                for (int fila = 0; fila < filaDisponible.length; fila++) {
                    if (huecosPorFila[fila] != menorNumeroHuecos) {
                        filaDisponible[fila] = false;
                    }
                }
            }

            do {
                filaSeleccionada = generarNumeroAleatorio(0, carton.length - 1);
            } while (!filaDisponible[filaSeleccionada] || carton[filaSeleccionada][columna] == -1);
            carton[filaSeleccionada][columna] = -1;
            huecosPorFila[filaSeleccionada]++;

            if (arrayNumeros[columna] == 2) {
                huecosEnColumna = 0;
                for (int fila = 0; fila < carton.length; fila++) {
                    if (carton[fila][columna] == -1) {
                        huecosEnColumna++;
                    }
                }
                if (huecosEnColumna < arrayNumeros[columna]) {
                    columna--;
                }
            }
        }
        return carton;
    }

    public int generarNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }
}