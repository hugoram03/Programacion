package Enum.NivelesJuego;

public enum EstadoJuego {
    INICIADO,
    EN_PROGRESO,
    PAUSADO,
    TERMINADO;

    public void mostrarEstado(){
       if (this.equals(EstadoJuego.INICIADO)){
           System.out.println("El juego esta iniciado");
       } else if (this.equals(EstadoJuego.EN_PROGRESO)){
           System.out.println("El juego esta en progreso");
       } else if (this.equals(EstadoJuego.PAUSADO)) {
           System.out.println("El juego esta pausado");
       } else {
           System.out.println("El juego a terminado");
       }
    }
}
