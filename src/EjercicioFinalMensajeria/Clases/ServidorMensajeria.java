package EjercicioFinalMensajeria.Clases;


import EjercicioFinalMensajeria.Enums.OpcionesMensajeEnum;
import EjercicioFinalMensajeria.Enums.RolesUsuario;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServidorMensajeria {
    private final Map<String, Usuario> usuarios;
    private final Map<Integer, Mensaje> mensajes;
    private final Map<Integer, Sesion> sesiones;
    private final File archivoUsuarios;
    private final File archivoMensajes;
    private final File archivoSesiones;
    public ServidorMensajeria(String rutaUsuarios, String rutaMensajes, String rutaSesiones) throws IOException, ClassNotFoundException {
        if (rutaUsuarios == null){
            throw new NullPointerException("La ruta del archivo de usuarios no puede ser nula");
        }
        if (rutaMensajes == null){
            throw new NullPointerException("La ruta del archivo de mensajes no puede ser nula");
        }
        if (rutaSesiones == null){
            throw new NullPointerException("La ruta del archivo de sesiones no puede ser nula");
        }
        this.archivoUsuarios = new File(rutaUsuarios);
        this.archivoMensajes = new File(rutaMensajes);
        this.archivoSesiones = new File(rutaSesiones);
        this.usuarios = new HashMap<>();
        if (archivoUsuarios.exists()){
            cargarUsuarios();
        }
        this.mensajes = new HashMap<>();
        if (archivoMensajes.exists()){
            cargarMensajes();
        }
        this.sesiones = new HashMap<>();
        if (archivoSesiones.exists()){
            cargarSesiones();
        }
        if (!usuarios.containsKey("ADMIN")){
            usuarios.put("ADMIN", new Usuario("ADMIN", "P@ssw0rd", RolesUsuario.ADMIN));
        }
    }
    private void cargarUsuarios() throws FileNotFoundException {
        Scanner usuariosScanner = new Scanner(archivoUsuarios);
        while (usuariosScanner.hasNextLine()) {
            String[] datosUsuario = usuariosScanner.nextLine().split(";");
            List<Integer> mensajesEnviados = obtenerMensajes(datosUsuario[2]);
            List<Integer> mensajesRecibidos = obtenerMensajes(datosUsuario[3]);
            List<Integer> sesiones = obtenerSesiones(datosUsuario[4]);
            RolesUsuario rolUsuario = obtenerRol(datosUsuario[5]);
            Usuario userAux = new Usuario(datosUsuario[0], datosUsuario[1],mensajesEnviados, mensajesRecibidos, sesiones, rolUsuario);
            usuarios.put(userAux.getNombreUsuario(), userAux);
        }
    }
    private RolesUsuario obtenerRol(String rolUsuario){
        for (RolesUsuario rol : RolesUsuario.values()){
            if (rol.name().equalsIgnoreCase(rolUsuario)){
                return rol;
            }
        }
        return null;
    }
    private void cargarMensajes() throws IOException, ClassNotFoundException {
        Map<Integer, Mensaje> mensajesCargados;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoMensajes))){
            Object ob = ois.readObject();
            if (mensajes.getClass() == ob.getClass()){
                mensajesCargados = (Map<Integer, Mensaje>) ob;
                mensajes.putAll(mensajesCargados);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    private void cargarSesiones() throws IOException, ClassNotFoundException {
        Map<Integer, Sesion> sesionesCargadas;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSesiones))){
            Object ob = ois.readObject();
            if (sesiones.getClass() == ob.getClass()){
                sesionesCargadas = (Map<Integer, Sesion>) ob;
                sesiones.putAll(sesionesCargadas);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
    private List<Integer> obtenerMensajes(String mensajes){
        String[] hashString = mensajes.split(":mensaje:");
        List<Integer> hashInteger = new ArrayList<>();
        for (String hash : hashString){
            hashInteger.add(Integer.parseInt(hash));
        }
        return hashInteger;
    }
    private List<Integer> obtenerSesiones(String sesiones){
        String[] hashString = sesiones.split(":sesion:");
        List<Integer> hashInteger = new ArrayList<>();
        for (String hash : hashString){
            hashInteger.add(Integer.parseInt(hash));
        }
        return hashInteger;
    }
    public List<Mensaje> obtenerMensajesUsuario(String nombreUsuario, OpcionesMensajeEnum queMensajes){
        List<Mensaje> mensajesUsuario = new ArrayList<>();
        if (nombreUsuario != null){
            List<Integer> hashesMensajes;
            Usuario usuario = usuarios.get(nombreUsuario);
            if (queMensajes == OpcionesMensajeEnum.ENVIADOS){
                hashesMensajes = usuario.getMensajesEnviados();
            }else {
                hashesMensajes = usuario.getMensajesRecibidos();
            }
            for (Integer hashMensaje : hashesMensajes){
                mensajesUsuario.add(mensajes.get(hashMensaje));
            }
        }
        return mensajesUsuario;
    }
    public List<Sesion> obtenerSesionesUsuario(String nombreUsuario){
        List<Sesion> sesionesUsuario = new ArrayList<>();
        if (nombreUsuario != null){
            List<Integer> hashesSesiones = usuarios.get(nombreUsuario).getSesiones();
            for (Integer hashSesion : hashesSesiones){
                if (sesiones.containsKey(hashSesion)){
                    sesionesUsuario.add(sesiones.get(hashSesion));
                }
            }
        }
        return sesionesUsuario;
    }
    public boolean enviarMensaje(Mensaje mensaje){
        String usuarioEmisor = mensaje.getUsuarioEmisor();
        String usuarioReceptor = mensaje.getUsuarioReceptor();
        Integer hashCode = mensaje.hashCode();
        if (asignarMensajeEnviado(hashCode,usuarioEmisor) && asignarMensajeRecibido(hashCode,usuarioReceptor)){
            return mensajes.put(mensaje.hashCode(), mensaje) == null;
        }
        return Boolean.FALSE;
    }
    private boolean asignarMensajeEnviado(Integer hashCode, String nombreUsuario){
        if (hashCode != null && nombreUsuario != null && usuarios.containsKey(nombreUsuario)){
            return usuarios.get(nombreUsuario).addMensajeEnviado(hashCode);
        }
        return Boolean.FALSE;
    }
    private boolean asignarMensajeRecibido(Integer hashCode, String nombreUsuario){
        if (hashCode!=null && nombreUsuario!=null && usuarios.containsKey(nombreUsuario)){
            return usuarios.get(nombreUsuario).addMensajeRecibido(hashCode);
        }
        return Boolean.FALSE;
    }
    public void serializarServidor() throws IOException {
        if (archivoUsuarios.exists()){
            archivoUsuarios.delete();
        }
        if (archivoMensajes.exists()){
            archivoMensajes.delete();
        }
        if (archivoSesiones.exists()){
            archivoSesiones.delete();
        }
        if (!usuarios.isEmpty()){
            try (FileWriter fw = new FileWriter(archivoUsuarios)){
                for (Map.Entry<String, Usuario> elemento: usuarios.entrySet()){
                    Usuario usuario = elemento.getValue();
                    fw.write(usuario.getUsuarioSerializado() + "\n");
                }
            }
        }
        if (!mensajes.isEmpty()){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoMensajes))){
                oos.writeObject(mensajes);
            }
        }
        if (!sesiones.isEmpty()){
            try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoSesiones))){
                oos.writeObject(sesiones);
            }
        }
    }
    public List<Mensaje> obtenerMensajesPorHash(List<Integer> hashes){
        if (hashes != null && !hashes.isEmpty()){
            List<Mensaje> mensajesRecuperados = new ArrayList<>();
            for (Integer hash : hashes){
                if (mensajes.containsKey(hash)){
                    mensajesRecuperados.add(mensajes.get(hash));
                }
            }
            return mensajesRecuperados;
        }
        return null;
    }
    public List<Mensaje> obtenerMensajesRangoFechas(String nombreUsuario, String fechaInicio, String fechaFin, OpcionesMensajeEnum queMensajes){
        List<Mensaje> mensajesUsuario = obtenerMensajesUsuario(nombreUsuario, queMensajes);
        return filtrarPorFecha(mensajesUsuario, fechaInicio, fechaFin);
    }
    public<T extends iFecha> List<T> filtrarPorFecha(List<T> lista, String fechaInicio, String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate inicio = LocalDate.parse(fechaInicio, formatter);
        LocalDate fin = LocalDate.parse(fechaFin, formatter);
        List<T> listaFiltrada = new ArrayList<>();
        for (T elemento : lista){
            LocalDate fechaElemento = elemento.getFechaHora().toLocalDate();
            if ((fechaElemento.isAfter(inicio) || fechaElemento.isEqual(inicio) ) && (fechaElemento.isBefore(fin) || fechaElemento.isEqual(fin))){
                listaFiltrada.add(elemento);
            }
        }
        return listaFiltrada;
    }
    public Usuario obtenerUsuario(String nombreUsuario){
        if (nombreUsuario != null && !nombreUsuario.isBlank()){
            return usuarios.get(nombreUsuario);
        }
        return null;
    }
    public boolean addUsuario(Usuario usuario){
        if (usuario != null){
            return usuarios.put(usuario.getNombreUsuario(), usuario) == null;
        }
        return false;
    }
    public boolean guardarSesion(Sesion sesion){
        if (sesion != null){
            Sesion sesionCerrada = sesion.cierraSesion();
            Usuario usuario = usuarios.get(sesion.getNombreUsuario());
            return usuario.addSesion(sesionCerrada.hashCode()) && sesiones.put(sesionCerrada.hashCode(),sesionCerrada) == null;
        }
        return Boolean.FALSE;
    }
    public Sesion comprobarCredenciales(String nombreUsuario, String password){
        if (nombreUsuario != null && password != null){
            Usuario usuario = obtenerUsuario(nombreUsuario);
            if (usuario != null && usuario.comprobarPassword(password)){
                return new Sesion(nombreUsuario, usuario.getRolUsuario());
            }
        }
        return null;
    }
    public boolean comprobarPatronFecha(String fecha){
        String patronFecha = "^([0-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/\\d{4}$";
        Pattern pattern = Pattern.compile(patronFecha);
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }
}