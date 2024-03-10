package Ejercicios_Try_Catch.SistemaAcceso;

import java.util.Objects;
import java.util.Scanner;

public class Usuario {
    private String usuario;
    private String contraseña;

    public Usuario(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(usuario, usuario1.usuario) && Objects.equals(contraseña, usuario1.contraseña);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, contraseña);
    }

    @Override
    public String toString() {
        return "Usuario= " + usuario + ", contraseña= " + contraseña;
    }
}
