package Ejercicios_Try_Catch.SistemaAcceso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    static Scanner lector = new Scanner(System.in);
    static File nuevosUsuarios = new File("src\\Ejercicios_Try_Catch\\SistemaAcceso\\nuevosUsuarios.txt");

    public static void main(String[] args) throws MaEx, IOException {
        Sistema.cargarUsuarios(nuevosUsuarios);
        String opcion;
        do {
            System.out.println("|Sistema de acceso|");
            System.out.println("Estas registrado en el sistema de acceso? (si/no) ('fin' para salir)");
            opcion = lector.next();
            if (opcion.equalsIgnoreCase("si")) {
                System.out.print("Usuario: ");
                String usuario = lector.next();
                System.out.print("Contraseña: ");
                String contraseña = lector.next();
                try {
                    if (Sistema.verificarAcceso(usuario, contraseña)) {
                        menu(usuario, contraseña);
                    } else {
                        System.out.println("Credenciales incorrectas vuelva a iniciar sesion");
                    }
                } catch (MaEx e) {
                    System.out.println(e.getMessage());
                }
            } else if (opcion.equalsIgnoreCase("no")) {
                añadirUsuarioNuevo();
            }
        } while (!opcion.equalsIgnoreCase("fin"));
    }

    private static void menu(String usuario, String contrasena) throws MaEx {
        int opcion = 0;
        do {
            System.out.println("Que desea hacer? (0 - salir | 1 - cambiar contraseña)");
            opcion = lector.nextInt();
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    String nuevaContraseña;
                    do {
                        System.out.println("Introduce la nueva Contraseña: ");
                        nuevaContraseña = lector.next();
                        if (nuevaContraseña.equals(contrasena)) {
                            System.out.println("La nueva contraseña no puede ser la misma que la que ya tenias, vuelve a introducir la contraseña otra vez");
                        }
                    } while (contrasena.equals(nuevaContraseña));
                    Sistema.cambiarContraseña(usuario, nuevaContraseña);
                    break;
                default:
                    throw new MaEx("Opcion incorrecta el valor tiene que ser 0 o 1");
            }
        } while (opcion != 0);
    }

    public static void añadirUsuarioNuevo() throws IOException {
        System.out.println("Rellena estos datos para registrarte.");
        System.out.println("Nombre: ");
        String nombre = lector.next();
        System.out.println("Apellido:");
        String apellido = lector.next();
        System.out.println("Correo electrónico: ");
        String correoElectronico = validarCorreoElectronico();
        System.out.println("Dirección IP: ");
        String direccionIP = validarDireccionIP();
        System.out.println("Teléfono: ");
        String telefono = lector.next();
        System.out.println("Usuario: ");
        String usuario = validarUsuario();
        System.out.println("Contraseña: ");
        String contrasena = validarContrasena();
        System.out.println("Confirmar contraseña: ");
        String confirmacionContraseña = lector.next();
        while (!contrasena.equals(confirmacionContraseña)) {
            System.out.println("Las contraseñas no coinciden. Inténtalo de nuevo.");
            System.out.println("Confirmar contraseña: ");
            confirmacionContraseña = lector.next();
        }
        System.out.println("Quiere ser registrado en nuestro sistema?: (si/no)");
        String opcion = lector.next();
        if (opcion.equalsIgnoreCase("si")){
            Usuario nuevoUsuario = new Usuario(nombre,apellido,correoElectronico, direccionIP,telefono,usuario,contrasena);
            Sistema.usuarios.add(nuevoUsuario);
            guardarUsuario(nuevoUsuario);
        } else {
            System.out.println("De acuerdo que tenga buen dia. Adios");
        }
    }

    public static String validarCorreoElectronico() {
        String correoElectronico = lector.next();
        while (!Pattern.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", correoElectronico)) {
            System.out.println("El correo electrónico no es válido. Inténtalo de nuevo.");
            System.out.print("Correo electrónico: ");
            correoElectronico = lector.next();
        }
        return correoElectronico;
    }

    public static String validarDireccionIP() {
        String direccionIP = lector.next();
        while (!Pattern.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b", direccionIP)) {
            System.out.println("La dirección IP no es válida. Inténtalo de nuevo.");
            System.out.print("Dirección IP: ");
            direccionIP = lector.next();
        }
        return direccionIP;
    }


    public static String validarUsuario() {
        String nick = lector.next();
        while (!Pattern.matches("[a-z_]+", nick)) {
            System.out.println("El nick solo puede contener letras minúsculas y el guion bajo (_). Inténtalo de nuevo.");
            System.out.print("Nick: ");
            nick = lector.next();
        }
        return nick;
    }

    public static String validarContrasena() {
        String contraseña = lector.next();
        while (!Pattern.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})", contraseña)) {
            System.out.println("La contraseña no cumple con los requisitos. Debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.");
            System.out.print("Contraseña: ");
            contraseña = lector.next();
        }
        return contraseña;
    }
    public static void guardarUsuario(Usuario usuario) throws IOException {
        FileWriter fileWriter = new FileWriter(nuevosUsuarios, true);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(formatoUsuario(usuario));
        printWriter.close();
    }
    public static String formatoUsuario(Usuario usuario) {
        return usuario.getNombre() + ";" +
                usuario.getApellidos() + ";" +
                usuario.getCorreoElectronico() + ";" +
                usuario.getDireccionIP() + ";" +
                usuario.getTelefono() + ";" +
                usuario.getUsuario() + ";" +
                usuario.getContrasena();
    }
}