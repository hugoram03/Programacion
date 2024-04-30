package Lists.ConvierteArray;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Integer[] numeros = new Integer[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i + 1;
        }
        List<Integer> numerosList = Arrays.asList(numeros);
        System.out.println("Lista:" + numerosList);

        Integer[] numerosArray = new Integer[10];
        numerosList.toArray(numerosArray);
        for (int i = 0; i < numerosArray.length; i++) {
            System.out.println("Numero del array:: " + numerosArray[i]);
        }
    }
}