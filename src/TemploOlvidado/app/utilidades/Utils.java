package app.utilidades;

import java.util.Random;

public class Utils {

    private static Random random = new Random();

    /**
     * Genera un 1 o -1 de forma aleatoria para ayudar en el desempate
     * @return 1 o -1
     */
    public static int generaNumeroDesempate() {
        return random.nextBoolean() ? 1 : -1;
    }
}
