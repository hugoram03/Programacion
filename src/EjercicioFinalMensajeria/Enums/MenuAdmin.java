package EjercicioFinalMensajeria.Enums;

public enum MenuAdmin implements iEnum{
    VER_ACTIVIDAD_DE_UN_USUARIO(1),
    REGISTRAR_UN_USUARIO(2),
    VISTA_DE_USUARIO(3),
    SALIR(4);
    private final int opcion;
    MenuAdmin(int opcion){
        this.opcion = opcion;
    }
    public int getOpcion() {
        return opcion;
    }
    @Override
    public String toString() {
        String name = name().toLowerCase().replace("_", " ");
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        return "("+opcion+")."+name;
    }

}