package Ejercicios_Try_Catch.UsaCasa.oovv;

public class Qutil {
    public static Boolean esVocal(char letra) {
        if ("aeiouAEIOU".indexOf(letra) != -1) {
            return true;
        } else {
            return false;
        }
    }
}
