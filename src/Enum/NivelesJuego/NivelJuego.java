package Enum.NivelesJuego;

public enum NivelJuego {
    PRINCIPIANTE,
    INTERMEDIO,
    AVANZADO;


    public boolean esAvanzado(){
        if (this.equals(NivelJuego.AVANZADO)){
            return true;
        }
        return false;
    }
}
