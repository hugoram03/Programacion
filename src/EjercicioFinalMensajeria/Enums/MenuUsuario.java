package EjercicioFinalMensajeria.Enums;

public enum MenuUsuario implements iEnum{
    ENVIAR_MENSAJE(1),
    VER_MENSAJES_ENVIADOS(2),
    VER_MENSAJES_RECIBIDOS(3),
    VER_MENSAJES_POR_FECHA(4),
    CERRAR_SESION(5);
    private final int opcion;
    MenuUsuario(int opcion){
        this.opcion = opcion;
    }
    public int getOpcion(){
        return opcion;
    }
    @Override
    public String toString() {
        String name = name().toLowerCase().replace("_", " ");
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        return "("+opcion+")."+name;
    }
}