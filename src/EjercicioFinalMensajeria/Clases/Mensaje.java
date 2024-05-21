package EjercicioFinalMensajeria.Clases;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class Mensaje implements Serializable, Comparable<Mensaje>, iFecha{
    @Serial
    private static final long serialVersionUID = 42L;
    private final LocalDateTime fechaHoraMensaje;
    private final String mensaje;
    private final String usuarioEmisor;
    private final String usuarioReceptor;
    public Mensaje(String mensaje, String usuarioEmisor, String usuarioReceptor){
        this.fechaHoraMensaje = LocalDateTime.now();
        this.mensaje = mensaje;
        this.usuarioEmisor = usuarioEmisor;
        this.usuarioReceptor = usuarioReceptor;
    }

    private String getFechaString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return fechaHoraMensaje.format(formatter);
    }
    public LocalDateTime getFechaHora(){
        return this.fechaHoraMensaje;
    }
    public String getUsuarioEmisor(){
        return usuarioEmisor;
    }
    public String getUsuarioReceptor(){
        return usuarioReceptor;
    }
    @Override
    public String toString(){
        return "Mensaje enviado por: " + usuarioEmisor +
                ".\n" + "Enviado a: " + usuarioReceptor +
                ".\n" + "Fecha de envio: " + getFechaString() +
                ".\n" + "Mensaje: \n" + mensaje;
    }

    @Override
    public int compareTo(Mensaje otro) {
        return otro.fechaHoraMensaje.compareTo(this.getFechaHora());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaHoraMensaje, usuarioEmisor, usuarioReceptor);
    }
}