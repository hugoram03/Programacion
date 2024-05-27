package EjercicioFinalMensajeria.Clases;


import EjercicioFinalMensajeria.Enums.RolesUsuario;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Sesion implements Serializable, iFecha{
    @Serial
    private static final long serialVersionUID = 42L;
    private final String nombreUsuario;
    private final LocalDateTime fechaHoraInicio;
    private final LocalDateTime fechaHoraFin;
    private final List<Integer> mensajesEnviadosDuranteSesion;
    private final RolesUsuario nivelAcceso;
    public Sesion(String nombreUsuario, RolesUsuario rol){
        this.nombreUsuario = nombreUsuario;
        this.fechaHoraInicio = LocalDateTime.now();
        this.fechaHoraFin = null;
        this.mensajesEnviadosDuranteSesion = new ArrayList<>();
        this.nivelAcceso = rol;
    }
    public Sesion(String nombreUsuario, RolesUsuario rol, LocalDateTime fechaHoraInicio, List<Integer> mensajesEnviadosDuranteSesion){
        this.nombreUsuario = nombreUsuario;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = LocalDateTime.now();
        this.mensajesEnviadosDuranteSesion = new ArrayList<>(mensajesEnviadosDuranteSesion);
        this.nivelAcceso = rol;
    }
    public boolean addMensajeEnviado(Integer hashCodeMensaje){
        return mensajesEnviadosDuranteSesion.add(hashCodeMensaje);
    }
    public List<Integer> getMensajesEnviadosDuranteSesion(){
        return new ArrayList<>(mensajesEnviadosDuranteSesion);
    }
    public String getNombreUsuario(){
        return nombreUsuario;
    }
    public RolesUsuario getNivelAcceso(){
        return nivelAcceso;
    }
    public Sesion cierraSesion(){
        return new Sesion(this.nombreUsuario,this.nivelAcceso, this.fechaHoraInicio, this.mensajesEnviadosDuranteSesion);
    }
    private String getFechaString(LocalDateTime fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fecha.format(formatter);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fechaHoraInicio, fechaHoraFin, nombreUsuario);
    }

    @Override
    public String toString() {
        return "Inicio de sesión: " + getFechaString(fechaHoraInicio) +
                "\nFin de sesión: " + getFechaString(fechaHoraFin) +
                "\nNumero de mensajes enviados durante la sesión: " + mensajesEnviadosDuranteSesion.size();
    }

    @Override
    public LocalDateTime getFechaHora() {
        return fechaHoraInicio;
    }
}