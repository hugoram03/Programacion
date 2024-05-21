package EjercicioFinalMensajeria.Clases;

import EjercicioFinalMensajeria.Enums.RolesUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private final List<Integer> mensajesEnviados;
    private final List<Integer> mensajesRecibidos;
    private final List<Integer> sesiones;
    private final RolesUsuario rolUsuario;
    public Usuario(String nombreUsuario, String password, RolesUsuario rolUsuario) throws IllegalArgumentException{
        setNombreUsuario(nombreUsuario);
        this.password = password;
        mensajesEnviados = new ArrayList<>();
        mensajesRecibidos = new ArrayList<>();
        sesiones = new ArrayList<>();
        this.rolUsuario = rolUsuario;
    }
    public Usuario(String nombreUsuario, String password, List<Integer> mensajesEnviados, List<Integer> mensajesRecibidos, List<Integer> sesiones, RolesUsuario rolUsuario) throws IllegalArgumentException{
        setNombreUsuario(nombreUsuario);
        this.password = password;
        this.mensajesEnviados = mensajesEnviados;
        this.mensajesRecibidos = mensajesRecibidos;
        this.sesiones = sesiones;
        this.rolUsuario = rolUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) throws IllegalArgumentException{
        if (nombreUsuario == null || nombreUsuario.isBlank()){
            throw new IllegalArgumentException();
        }
        this.nombreUsuario = nombreUsuario;
    }
    public RolesUsuario getRolUsuario(){
        return rolUsuario;
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public boolean addMensajeEnviado(Integer hashCode){
        if (hashCode != null && !mensajesEnviados.contains(hashCode)){
            return mensajesEnviados.add(hashCode);
        }
        return Boolean.FALSE;
    }
    public boolean addMensajeRecibido(Integer hashCode){
        if (hashCode != null && !mensajesRecibidos.contains(hashCode)){
            return mensajesRecibidos.add(hashCode);
        }
        return Boolean.FALSE;
    }
    public boolean addSesion(Integer hashCode){
        if (hashCode != null){
            return sesiones.add(hashCode);
        }
        return Boolean.FALSE;
    }

    public List<Integer> getMensajesEnviados(){
        return mensajesEnviados;
    }
    public List<Integer> getMensajesRecibidos(){
        return mensajesRecibidos;
    }
    public List<Integer> getSesiones(){
        return sesiones;
    }
    public String getUsuarioSerializado(){
        return  nombreUsuario + ";" +
                password + ";" +
                getMensajesSerializados(mensajesEnviados) + ";" +
                getMensajesSerializados(mensajesRecibidos) + ";" +
                getSesionesSerializadas(sesiones) + ";" +
                rolUsuario.name();
    }
    private String getMensajesSerializados(List<Integer> mensajes){
        String mensajesString = "";
        if (!mensajes.isEmpty()){
            for (Integer mensajeHashInteger : mensajes){
                mensajesString += mensajeHashInteger.toString() + ":mensaje:";
            }
        }else {
            mensajesString = ":mensaje:";
        }
        return mensajesString;
    }
    private String getSesionesSerializadas(List<Integer> sesiones){
        String sesionesString = "";
        if (!sesiones.isEmpty()){
            for (Integer sesionHashInteger : sesiones){
                sesionesString += sesionHashInteger.toString() + ":sesion:";
            }
        }else {
            sesionesString = ":sesion:";
        }
        return sesionesString;
    }
    public static boolean comprobarFuerzaPassword(String password){
        if (password == null || password.isBlank()){
            return Boolean.FALSE;
        }
        String patron = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.compile(patron).matcher(password).matches() && !password.contains(";");
    }
    public static boolean comprobarNombreUsuario(String nombreUsuario){
        if (nombreUsuario == null || nombreUsuario.isBlank()){
            return Boolean.FALSE;
        }
        return nombreUsuario.length() > 5 && !nombreUsuario.contains(";");
    }
    public boolean comprobarPassword(String password){
        return this.password.equals(password);
    }
}