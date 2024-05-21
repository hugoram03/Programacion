package EjercicioFinalMensajeria.Enums;

public enum RolesUsuario {
    ADMIN(1),
    USUARIO(2);
    private final int opcion;
    RolesUsuario(int opcion){
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