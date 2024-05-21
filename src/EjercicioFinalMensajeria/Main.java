package EjercicioFinalMensajeria;


import EjercicioFinalMensajeria.Clases.Mensaje;
import EjercicioFinalMensajeria.Clases.ServidorMensajeria;
import EjercicioFinalMensajeria.Clases.Sesion;
import EjercicioFinalMensajeria.Clases.Usuario;
import EjercicioFinalMensajeria.Comparators.*;
import EjercicioFinalMensajeria.Enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main{
    static final Logger LOGGER = LogManager.getLogger("LOGGER_UD9");
    static ServidorMensajeria SERVER;
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean salir = Boolean.FALSE;
        final String rutaUsuarios = "src/EjercicioFinalMensajeria/usuarios.csv";
        final String rutaMensajes = "src/EjercicioFinalMensajeria/mensajes.dat";
        final String rutaSesiones = "src/EjercicioFinalMensajeria/sesiones.dat";
        try{
            SERVER = new ServidorMensajeria(rutaUsuarios,rutaMensajes,rutaSesiones);
        }catch (Exception e){
            System.out.println("Ha habido un error iniciando el servidor, se cerrará el programa. Consulte log.");
            logger("Error al crear instancia de ServidorMensajeria", e);
            salir = Boolean.TRUE;
        }
        while (!salir){
            System.out.println("Menu principal de la app de Mensajeria");
            System.out.println("¿Qué deseas hacer?");
            imprimirMenu(MenuPrincipal.values());
            MenuPrincipal opcion = (MenuPrincipal)obtenerEnum(obtenerInt(), MenuPrincipal.values());
            if (opcion != null){
                salir = gestionarOpcionMenuPrincipal(opcion);
            }
        }
        sc.close();
    }
    public static boolean gestionarOpcionMenuPrincipal(MenuPrincipal opcion){
        switch (opcion){
            case REGISTRARSE:
                iniciarRegistro();
                break;
            case INICIAR_SESION:
                iniciarSesion();
                break;
            case SALIR:
                System.out.println("Guardando mensajes y usuarios, cerrando servidor...");
                try{
                    SERVER.serializarServidor();
                }catch (Exception e){
                    System.out.println("Ha habido un error al guardar el estado del servidor, consulte log.");
                    logger("Error al guardar mensajes y usuarios", e);
                }
                System.out.println("Gracias por usar nuestro programa, ¡hasta pronto!");
                return Boolean.TRUE;
            default:
                System.out.println("La opción elegida no es valida.");
        }
        return Boolean.FALSE;
    }
    public static void iniciarRegistro(){
        Usuario nuevoUsuario = pedirDatos(RolesUsuario.USUARIO);
        if (nuevoUsuario == null || !SERVER.addUsuario(nuevoUsuario)){
            System.out.println("No se ha podido completar el registro.");
        }else{
            System.out.println("Se ha completado el registro exitosamente.");
            menuUsuario(new Sesion(nuevoUsuario.getNombreUsuario(), nuevoUsuario.getRolUsuario()));
        }
    }
    public static Usuario pedirDatos(RolesUsuario rolUsuario){
        Usuario userAux = null;
        System.out.println("Introduce nombre de usuario:");
        String nombreUsuario = obtenerString();
        while (!Usuario.comprobarNombreUsuario(nombreUsuario) || SERVER.obtenerUsuario(nombreUsuario) != null){
            System.out.println("Ese nombre de usuario ya esta en uso o no es valido, por favor, introduce otro distinto:");
            nombreUsuario = obtenerString();
        }
        System.out.println("Introduce contraseña:");
        String password = obtenerString();
        while (!Usuario.comprobarFuerzaPassword(password)){
            System.out.println("La contraseña no cumple con los requisitos de seguridad (8 caracteres, minusculas, mayúsculas, números y símbolos, no se permite ';'), intentalo de nuevo:");
            password = obtenerString();
        }
        try{
            userAux = new Usuario(nombreUsuario,password, rolUsuario);
        }catch (Exception e){
            System.out.println("Ha habido un problema creando al usuario.");
            logger("Error al crear al nuevo usuario", e);
        }
        return userAux;
    }
    public static void iniciarSesion(){
        System.out.println("Introduce tu nombre de usuario:");
        String nombreUsuario = obtenerString();
        System.out.println("Introduce tu contraseña:");
        String password = obtenerString();
        Sesion sesionValidada = SERVER.comprobarCredenciales(nombreUsuario, password);
        if (sesionValidada != null){
            if (sesionValidada.getNivelAcceso() != RolesUsuario.ADMIN){
                System.out.println("Bienvenido " + nombreUsuario);
                menuUsuario(sesionValidada);
            }else {
                System.out.println("Has iniciado sesión como administrador del sistema.");
                menuAdmin(sesionValidada);
            }
        }else {
            System.out.println("Las credenciales no son correctas.");
        }
    }
    public static void menuUsuario(Sesion sesionActual){
        boolean cerrarSesion = Boolean.FALSE;
        while (!cerrarSesion){
            System.out.println("¿Que deseas hacer, " + sesionActual.getNombreUsuario() + "?");
            imprimirMenu(MenuUsuario.values());
            MenuUsuario opcion = (MenuUsuario) obtenerEnum(obtenerInt(), MenuUsuario.values());
            if (opcion != null){
                cerrarSesion = gestionarOpcionMenuUsuario(opcion, sesionActual);
            }
        }
    }
    public static boolean gestionarOpcionMenuUsuario(MenuUsuario opcion, Sesion sesionActual){
        switch (opcion){
            case ENVIAR_MENSAJE:
                enviarMensaje(sesionActual);
                break;
            case VER_MENSAJES_ENVIADOS:
                verMensajes(sesionActual.getNombreUsuario(), OpcionesMensajeEnum.ENVIADOS);
                break;
            case VER_MENSAJES_RECIBIDOS:
                verMensajes(sesionActual.getNombreUsuario(), OpcionesMensajeEnum.RECIBIDOS);
                break;
            case VER_MENSAJES_POR_FECHA:
                verMensajesPorRangoFecha(sesionActual.getNombreUsuario());
                break;
            case CERRAR_SESION:
                if (!esAdmin(sesionActual)){
                    System.out.println("Cerrando sesión...");
                    if (SERVER.guardarSesion(sesionActual)){
                        System.out.println("¡Sesión cerrada correctamente!");
                    }else {
                        System.out.println("Ha habido algún problema al guardar la sesión.");
                    }
                }
                return Boolean.TRUE;
            default:
                System.out.println("La opción elegida no es valida.");
        }
        return false;
    }
    public static void menuAdmin(Sesion sesionActual){
        boolean cerrarSesion = Boolean.FALSE;
        while (!cerrarSesion){
            System.out.println("¿Que deseas hacer, " + sesionActual.getNombreUsuario() + "?");
            imprimirMenu(MenuAdmin.values());
            MenuAdmin opcion = (MenuAdmin) obtenerEnum(obtenerInt(), MenuAdmin.values());
            if (opcion != null){
                cerrarSesion = gestionarOpcionMenuAdmin(opcion, sesionActual);
            }
        }
    }
    public static boolean gestionarOpcionMenuAdmin(MenuAdmin opcion, Sesion sesionActual){
        switch (opcion){
            case VER_ACTIVIDAD_DE_UN_USUARIO:
                verActividadUsuario(sesionActual);
                break;
            case REGISTRAR_UN_USUARIO:
                registrarUsuario(sesionActual);
                break;
            case VISTA_DE_USUARIO:
                menuUsuario(sesionActual);
                break;
            case SALIR:
                System.out.println("Cerrando sesión...");
                if (SERVER.guardarSesion(sesionActual)){
                    System.out.println("¡Sesión cerrada correctamente!");
                }else {
                    System.out.println("Ha habido algún problema al guardar la sesión.");
                }
                return Boolean.TRUE;
            default:
                System.out.println("La opcion elegida no es valida.");
        }
        return Boolean.FALSE;
    }
    public static void verActividadUsuario(Sesion sesionAtual){
        if (!esAdmin(sesionAtual)){
            System.out.println("No tienes permisos para esta tarea.");
            return;
        }
        System.out.println("Introduce el nombre del usuario:");
        String nombreUsuario = obtenerString();
        if (nombreUsuario == null || SERVER.obtenerUsuario(nombreUsuario) == null){
            System.out.println("Ese usuario no existe.");
        }else {
            List<Sesion> sesionesUsuario = SERVER.obtenerSesionesUsuario(nombreUsuario);
            System.out.println("Este es el resumen de las sesiones del usuario " + nombreUsuario + ":");
            imprimirSesiones(sesionesUsuario);
        }
    }
    public static void imprimirSesiones(List<Sesion> sesiones){
        for (Sesion sesion : sesiones){
            System.out.println(sesion);
            List<Integer> hashesMensajesEnviados = sesion.getMensajesEnviadosDuranteSesion();
            if (!hashesMensajesEnviados.isEmpty()){
                List<Mensaje> mensajesEnviadosSesion = SERVER.obtenerMensajesPorHash(hashesMensajesEnviados);
                boolean singular = mensajesEnviadosSesion.size() == 1;
                StringBuilder mensaje = new StringBuilder();
                mensaje.append(singular ? "Este " : "Estos ");
                mensaje.append(singular ? "fue " : "fueron ");
                mensaje.append(singular ? "el " : "los ");
                mensaje.append(singular ? "mensaje " : "mensajes ");
                mensaje.append(singular ? "enviado:" : "enviados:");
                System.out.println(mensaje);
                imprimirMensajes(mensajesEnviadosSesion);
            }else {
                System.out.println("No hay mensajes que ver, introduce cualquier cosa para continuar:");
                sc.nextLine();
            }
        }
    }
    public static void registrarUsuario(Sesion sesionActual){
        if (!esAdmin(sesionActual)){
            System.out.println("No tienes permisos para esta tarea.");
            return;
        }
        RolesUsuario rolUsuario = preguntarRol();
        if (rolUsuario == null){
            System.out.println("Ha habido un error, no se continuara con el registro.");
            return;
        }
        Usuario nuevoUsuario = pedirDatos(rolUsuario);
        if (nuevoUsuario != null){
            System.out.println(SERVER.addUsuario(nuevoUsuario) ? "Se ha registrado al usuario correctamente" : "No se ha podido registrar al usuario");
        }
    }
    public static RolesUsuario preguntarRol(){
        System.out.println("¿Qué rol va a tener el nuevo usuario?");
        for (RolesUsuario rol : RolesUsuario.values()){
            System.out.println(rol);
        }
        Integer rolElegido = obtenerInt();
        while (rolElegido == null || rolElegido < 1 || rolElegido > RolesUsuario.values().length){
            System.out.println("El rol elegido no es valido. Intentalo de nuevo...");
            rolElegido = obtenerInt();
        }
        for (RolesUsuario rol : RolesUsuario.values()){
            if (rol.getOpcion() == rolElegido){
                return rol;
            }
        }
        return null;
    }
    public static boolean esAdmin(Sesion sesionActual){
        if (sesionActual != null){
            return sesionActual.getNivelAcceso() == RolesUsuario.ADMIN;
        }
        return Boolean.FALSE;
    }
    public static void enviarMensaje(Sesion sesionActual){
        System.out.println("Introduce nombre de usuario del destinatario:");
        String usuarioDestino = obtenerString();
        if (SERVER.obtenerUsuario(usuarioDestino) == null){
            System.out.println("No existe ese usuario.");
        }else {
            System.out.println("Introduce el mensaje que deseas enviar:");
            String mensaje = obtenerString();
            if (mensaje == null || mensaje.isBlank()){
                System.out.println("No se puede enviar un mensaje vacio.");
            }else {
                Mensaje mensajeEnviar = new Mensaje(mensaje, sesionActual.getNombreUsuario(), usuarioDestino);
                if (SERVER.enviarMensaje(mensajeEnviar)){
                    sesionActual.addMensajeEnviado(mensajeEnviar.hashCode());
                    System.out.println("El mensaje se ha enviado correctamente.");
                }else {
                    System.out.println("El mensaje no se ha podido enviar.");
                }
            }
        }
    }
    public static void verMensajesPorRangoFecha(String nombreUsuario){
        System.out.println("¿Que mensajes deseas ver?");
        System.out.println("(1).Enviados");
        System.out.println("(2).Recibidos");
        Integer opcionElegida = obtenerInt();
        if (opcionElegida == null || opcionElegida < 1 || opcionElegida > 2){
            System.out.println("La opción elegida no es valida.");
        }else {
            OpcionesMensajeEnum queMensajes = opcionElegida == 1 ? OpcionesMensajeEnum.ENVIADOS : OpcionesMensajeEnum.RECIBIDOS;
            String fechaInicio = obtenerFecha("inicio");
            String fechaFin = obtenerFecha("fin");
            if (fechaInicio != null && fechaFin != null){
                List<Mensaje> mensajes = SERVER.obtenerMensajesRangoFechas(nombreUsuario, fechaInicio, fechaFin, queMensajes);
                imprimirMensajes(mensajes);
            }
        }
    }
    public static String obtenerFecha(String queFecha){
        System.out.println("Introduce fecha de " + queFecha + " del periodo (DD/MM/YYYY):");
        String fecha = obtenerString();
        if (fecha == null || !SERVER.comprobarPatronFecha(fecha)) {
            System.out.println("La fecha introducida no coincide con el formato solicitado.");
            return null;
        }
        return fecha;
    }
    public static void verMensajes(String usuarioActual, OpcionesMensajeEnum queMensajes){
        List<Mensaje> mensajes = SERVER.obtenerMensajesUsuario(usuarioActual, queMensajes);
        System.out.println("¿Como deseas ver los mensajes?");
        System.out.println("(1). De mas nuevos a mas antiguos.");
        System.out.println("(2). De mas antiguos a mas nuevos.");
        if (queMensajes == OpcionesMensajeEnum.ENVIADOS){
            System.out.println("(3). Por destinatario (A-Z).");
            System.out.println("(4). Por destinatario (Z-A).");
        }else{
            System.out.println("(3). Por emisor (A-Z).");
            System.out.println("(4). Por emisor (Z-A).");
        }
        Integer opcion = obtenerInt();
        if (opcion != null){
            ordenarMensajes(mensajes, opcion, queMensajes);
            imprimirMensajes(mensajes);
        }
    }
    public static void ordenarMensajes(List<Mensaje> mensajes, int opcion, OpcionesMensajeEnum queMensajes){
        switch (opcion){
            case 1:
                Collections.sort(mensajes);
                break;
            case 2:
                mensajes.sort(new ComparatorFecha());
                break;
            case 3:
                if (queMensajes == OpcionesMensajeEnum.ENVIADOS){
                    mensajes.sort(new ComparatorDestinatarioA_Z());
                }else {
                    mensajes.sort(new ComparatorEmisorA_Z());
                }
                break;
            case 4:
                if (queMensajes == OpcionesMensajeEnum.ENVIADOS){
                    mensajes.sort(new ComparatorDestinatarioZ_A());
                }else {
                    mensajes.sort(new ComparatorEmisorZ_A());
                }
                break;
            default:
                System.out.println("No se ha proporcionado una opcion valida, ordenando por defecto...");
                Collections.sort(mensajes);
        }
    }
    public static void imprimirMensajes(List<Mensaje> mensajes){
        if (mensajes.isEmpty()){
            System.out.println("No hay mensajes que mostrar");
        }else {
            for (Mensaje mensaje : mensajes){
                System.out.println("- ".repeat(35));
                System.out.println(mensaje);
                System.out.println("Introduce cualquier cosa para continuar...");
                sc.nextLine();
            }
        }
    }
    public static void imprimirMenu(iEnum[] menuMostrar){
        for (iEnum valor : menuMostrar){
            System.out.println(valor);
        }
    }
    public static iEnum obtenerEnum(Integer opcionElegida, iEnum[] opcionesEnum) {
        if (opcionElegida != null){
            for (iEnum opcionEnum : opcionesEnum) {
                if (opcionElegida == opcionEnum.getOpcion()) {
                    return opcionEnum;
                }
            }
        }
        return null;
    }
    public static Integer obtenerInt(){
        try{
            return sc.nextInt();
        }catch (Exception e){
            System.out.println("Ha habido un error capturando la entrada de teclado, recuerda que debías introducir un NUMERO.");
            logger("Error al capturar integer por Scanner", e);
        }finally {
            sc.nextLine();
        }
        return null;
    }
    public static String obtenerString(){
        try{
            return sc.nextLine();
        }catch (Exception e){
            System.out.println("Ha habido un error capturando la entrada de teclado, recuerda que debías introducir un NUMERO.");
            logger("Error al capturar integer por Scanner", e);
            sc.nextLine();
        }
        return null;
    }
    public static void logger(String mensaje, Exception e){
        LOGGER.error(mensaje + ":\n" + e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()));
    }
}