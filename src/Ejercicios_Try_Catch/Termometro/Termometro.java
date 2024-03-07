package Ejercicios_Try_Catch.Termometro;

public class Termometro {
    private double temperatura;

    public Termometro(double temperatura) {
        try {
            if (temperatura > -192 && temperatura < 100){
                this.temperatura = temperatura;
            } else {
                throw new IllegalArgumentException("La temperatura no puede estar por debajo de -192 ni por encima de 100");
            }
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
