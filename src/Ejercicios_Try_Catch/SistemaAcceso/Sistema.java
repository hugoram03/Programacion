package Ejercicios_Try_Catch.SistemaAcceso;

import java.util.ArrayList;

public class Sistema {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static Boolean verificarAcceso(String usuarioBuscado, String contrasenaBuscada) throws MaEx {
        boolean esta = Boolean.FALSE;
        for (Usuario usuario1: usuarios){
            if (usuario1.getUsuario().equals(usuarioBuscado) && usuario1.getContraseña().equals(contrasenaBuscada)){
                esta = Boolean.TRUE;
                System.out.println("Bienvenido al sistema");
            }
        }

        return esta;
    }

    public static void cambiarContraseña(String usuario, String nuevaContrasena) {
        for (Usuario usuario1: usuarios){
            if (usuario1.getUsuario().equals(usuario)){
                usuario1.setContraseña(nuevaContrasena);
            }
        }
    }
}
