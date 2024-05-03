package Ejercicios_Try_Catch.SistemaAcceso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static Boolean verificarAcceso(String usuarioBuscado, String contrasenaBuscada) throws MaEx {
        boolean esta = Boolean.FALSE;
        for (Usuario usuario1 : usuarios){
            if (usuario1.getUsuario().equals(usuarioBuscado) && usuario1.getContrasena().equals(contrasenaBuscada)){
                esta = Boolean.TRUE;
                System.out.println("Bienvenido al sistema");
            }
        }

        return esta;
    }

    public static void cambiarContraseña(String usuario, String nuevaContrasena) {
        for (Usuario usuario1 : usuarios){
            if (usuario1.getUsuario().equals(usuario)){
                usuario1.setContrasena(nuevaContrasena);
            }
        }
    }

    public static void cargarUsuarios(File archivo) {
        try (Scanner lector = new Scanner(archivo)) {
            lector.nextLine();
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                String[] partes = linea.split(";");
                if (partes.length == 7) {
                    String nombre = partes[0];
                    String apellidos = partes[1];
                    String correoElectronico = partes[2];
                    String direccionIP = partes[3];
                    String telefono = partes[4];
                    String nick = partes[5];
                    String contraseña = partes[6];

                    Usuario usuario = new Usuario(nombre, apellidos, correoElectronico, direccionIP, telefono, nick, contraseña);
                    usuarios.add(usuario);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en el archivo de usuarios.");
        }
    }
}
