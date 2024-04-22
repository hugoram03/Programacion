package ProgramaMe;

public class Main {

    static java.util.Scanner in;

    public static void casoDePrueba() {
        boolean esCorrecto = false;
        int numNumeros = in.nextInt();
        in.nextLine();
        String numero = in.nextLine();
        String[] numerosSeparados = numero.split(" ");
        if (numNumeros == numerosSeparados.length) {
            for (int i = 0; i < numerosSeparados.length - 1; i++) {
                int numAnterior = Integer.parseInt(numerosSeparados[i]);
                int numeroSiguiente = Integer.parseInt(numerosSeparados[i + 1]);
                if (((Math.abs(numAnterior) < Math.abs(numeroSiguiente)) || (numAnterior == numeroSiguiente)) &&
                        !(Math.abs(numAnterior) >= Math.abs(numeroSiguiente) && (Math.signum(numAnterior) != Math.signum(numeroSiguiente)))) {
                    esCorrecto = true;
                } else {
                    esCorrecto = false;
                }
            }
        }
        if (esCorrecto) {
            System.out.println("CORRECTA");
        } else {
            System.out.println("INCORRECTA");
        }
    }

    public static void main(String[] args) {
        int numCasos;
        do {
            in = new java.util.Scanner(System.in);
            numCasos = in.nextInt();
        } while (numCasos < 0 || numCasos > 100000);
        for (int i = 0; i < numCasos; i++)
            casoDePrueba();
    }
}