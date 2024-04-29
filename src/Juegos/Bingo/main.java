package Juegos.Bingo;

import java.util.*;

public class main {
    static int[][] carton = new int[3][9];

    public static void main(String[] args) {

        //getCarton();
        rellenarNumerosCarton();
        ordenarColumnasCarton();
        marcarHuecosCarton2();
        mostrarCarton();
    }

    public static String[][] getCarton() {
        Random random = new Random();
        String[][] carton = new String[3][9];
        for (int fila = 0; fila < carton.length; fila++) {
            int contNum = 0;
            int contBlancos = 0;
            for (int col = 0; col < carton[fila].length; col++) {
                int min = col * 10 + 1;
                int max = (col + 1) * 10 - 1;
                if (contNum < 5 && contBlancos < 5) {
                    int numero = random.nextInt(1 - 0 + 1);
                    if (numero == 0) {
                        int num = random.nextInt(max - min + 1) + min;
                        carton[fila][col] = " " + num + " ";
                        contNum++;
                    } else {
                        carton[fila][col] = " -1 ";
                        contBlancos++;
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

    public static void rellenarNumerosCarton() {

        // Declaramos las variables necesarias
        int numAleatorio;
        boolean repetido;

        // Recorre los números
        for (int j = 0; j < carton[0].length; j++) {
            for (int i = 0; i < carton.length; i++) {
                do {
                    repetido = false;
                    switch (j) {
                        case 0:
                            numAleatorio = generaNumeroAleatorio(1, 9);
                            break;
                        case 8:
                            numAleatorio = generaNumeroAleatorio(80, 90);
                            break;
                        default:
                            numAleatorio = generaNumeroAleatorio(10 * j, (10 * j) + 9);
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

    public static void ordenarColumnasCarton() {

        int[] numeros = new int[3];
        for (int j = 0; j < carton[0].length; j++) {

            // Obtengo los numeros de la columna x
            for (int i = 0; i < carton.length; i++) {
                numeros[i] = carton[i][j];
            }

            // Ordeno los numeros
            Arrays.sort(numeros);

            // Vuelvo a asignar los valores, ya ordenados
            for (int i = 0; i < numeros.length; i++) {
                carton[i][j] = numeros[i];
            }

        }
    }

    public static void mostrarCarton() {
        // Recorremos el carton
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

    public static void marcarHuecosCarton() {
        // generar un array de 9 posiciones con 6 unos y 3 doses
        int[] distribucion = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int posicionAleatoria;
        // Solo generamos 3 doses
        for (int i = 0; i < 3; i++) {
            do {
                posicionAleatoria = generaNumeroAleatorio(0, distribucion.length - 1);
            } while (distribucion[posicionAleatoria] == 2);
            // Colocamos un 2
            distribucion[posicionAleatoria] = 2;
        }
        // Recorrer array e ir llevando una cuenta del numero de huecos de cada fila, no puede superar 4
        int numHuecos[] = new int[3];
        boolean huecoDisponible[] = new boolean[3];
        int menor, filaAleatoria, posOcupadas;
        boolean iguales;

        for (int j = 0; j < carton[0].length; j++) {
            // Marco las posiciones como disponible
            Arrays.fill(huecoDisponible, true);
            // Compruebo si son iguales
            iguales = true;
            for (int i = 0; i < numHuecos.length - 1 && iguales; i++) {
                if (numHuecos[i] != numHuecos[i + 1]) {
                    iguales = false;
                }
            }
            // Sino son iguales, debo descartar aquellos que distintos al menor hueco
            if (!iguales) {
                // Busco el menor hueco
                menor = numHuecos[0];
                for (int i = 1; i < numHuecos.length; i++) {
                    if (numHuecos[i] < menor) {
                        menor = numHuecos[i];
                    }
                }
                // Marco como no disponible los huecos diferentes al menor
                for (int i = 0; i < huecoDisponible.length; i++) {
                    if (numHuecos[i] != menor) {
                        huecoDisponible[i] = false;
                    }
                }
            }
            // Compruebo donde colocar los huecos
            do {
                // Genero una fila aleatoria
                filaAleatoria = generaNumeroAleatorio(0, carton.length - 1);
                // Salgo si el hueco esta disponible y no esta repetido
            } while (!huecoDisponible[filaAleatoria] || carton[filaAleatoria][j] == -1);
            // Coloco el hueco
            carton[filaAleatoria][j] = -1;
            // Incremento en 1 el numero de huecos de esa fila
            numHuecos[filaAleatoria]++;
            // Solo compruebo las posiciones ocupadas si tengo que poner dos huecos
            if (distribucion[j] == 2) {
                // Compruebo cuantos huecos hay en la columna
                posOcupadas = 0;
                for (int i = 0; i < carton.length; i++) {
                    if (carton[i][j] == -1) {
                        posOcupadas++;
                    }
                }
                // Si hay menos posiciones ocupadas que el de la distribucion de la columna, repetimos
                if (posOcupadas < distribucion[j]) {
                    j--;
                }
            }
        }
    }

    public static void marcarHuecosCarton2() {
        // Este código genera un array con 9 posiciones, llenándolo con seis '1's y tres '2's en posiciones aleatorias.
        int[] arrayNumeros = {1, 1, 1, 1, 1, 1, 1, 1, 1}; // Inicializamos el array con todos '1's.
        int posicion; // Esta variable almacenará la posición aleatoria generada.

// Vamos a reemplazar tres '1's por '2's.
        for (int i = 0; i < 3; i++) {
            do {
                posicion = generaNumeroAleatorio(0, arrayNumeros.length - 1);
            } while (arrayNumeros[posicion] == 2); // Seguimos generando hasta que encontremos un '1'.

            arrayNumeros[posicion] = 2; // Reemplazamos el '1' por un '2'.
        }

// Ahora vamos a trabajar con un cartón de bingo, asegurándonos de que no haya más de cuatro huecos por fila.
        int[] huecosPorFila = new int[3]; // Contador de huecos por fila.
        boolean[] filaDisponible; // Indica si podemos poner un hueco en la fila.
        int menorNumeroHuecos, filaSeleccionada, huecosEnColumna;
        boolean sonIguales;

// Recorremos cada columna del cartón.
        for (int columna = 0; columna < carton[0].length; columna++) {
            filaDisponible = new boolean[]{true, true, true}; // Inicialmente todas las filas están disponibles.

            // Verificamos si todas las filas tienen el mismo número de huecos.
            sonIguales = true;
            for (int fila = 0; fila < huecosPorFila.length - 1 && sonIguales; fila++) {
                if (huecosPorFila[fila] != huecosPorFila[fila + 1]) {
                    sonIguales = false;
                }
            }

            // Si no son iguales, buscamos la fila con menos huecos y marcamos las demás como no disponibles.
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

            // Elegimos una fila aleatoria para colocar el hueco.
            do {
                filaSeleccionada = generaNumeroAleatorio(0, carton.length - 1);
            } while (!filaDisponible[filaSeleccionada] || carton[filaSeleccionada][columna] == -1);

            carton[filaSeleccionada][columna] = -1; // Colocamos el hueco.
            huecosPorFila[filaSeleccionada]++; // Incrementamos el contador de huecos para esa fila.

            // Si necesitamos colocar dos huecos en la misma columna, verificamos si ya se cumplió.
            if (arrayNumeros[columna] == 2) {
                huecosEnColumna = 0;
                for (int fila = 0; fila < carton.length; fila++) {
                    if (carton[fila][columna] == -1) {
                        huecosEnColumna++;
                    }
                }

                if (huecosEnColumna < arrayNumeros[columna]) {
                    columna--; // Si no hay suficientes huecos, repetimos el proceso para esta columna.
                }
            }
        }
    }
        public static int generaNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + (minimo));
    }
}