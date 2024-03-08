package Ejercicios_Try_Catch.Termometro;

public class Main {
    public static void main(String[] args) {
        try {
            Termometro t = new Termometro(10);
            System.out.println(t);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}