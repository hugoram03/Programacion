package Enum.NivelesJuego;

public enum NivelJuego {
    PRINCIPIANTE,
    INTERMEDIO,
    AVANZADO;


    public boolean esAvanzado(){
        return this.equals(NivelJuego.AVANZADO);
        /*if (this.equals(NivelJuego.AVANZADO)){
            return true;
        }
        return false;*/
    }
}
