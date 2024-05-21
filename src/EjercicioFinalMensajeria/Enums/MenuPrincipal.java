package EjercicioFinalMensajeria.Enums;

public enum MenuPrincipal implements iEnum{
    REGISTRARSE(1),
    INICIAR_SESION(2),
    SALIR(3);
    private final int opcion;
    MenuPrincipal(int opcion) {
        this.opcion = opcion;
    }
    public int getOpcion() {
        return opcion;
    }
    @Override
    public String toString() {
        String name = name().toLowerCase().replace("_", " ");
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        return "(" + opcion + ")." + name;
    }
}