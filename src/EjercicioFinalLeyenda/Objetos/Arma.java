package EjercicioFinalLeyenda.Objetos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Arma implements Comparable<Arma>, Serializable {
    @Serial
    private static final long serialVersionUID = -6794591492884005033L;
    private String nom;
    private int ataque;
    private Tipo tipo;
    private int valor;
    private String descrip;

    public Arma(String nom, int ataque, Tipo tipo, int valor, String descrip) {
        this.nom = nom;
        this.ataque = ataque;
        this.tipo = tipo;
        this.valor = valor;
        this.descrip = descrip;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public String getDescrip() {
        return descrip;
    }
    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    public void mostrarInfo() {
        System.out.println("El " + tipo + " " +  nom + " con un ataque de " + ataque + " y un valor de " + valor + " y su descripción es " + descrip);
    }
    @Override
    public String toString() {
        return nom + ";" + ataque + ";" + tipo + ";" + valor + ";" + descrip;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arma arma = (Arma) o;
        return ataque == arma.ataque && valor == arma.valor && Objects.equals(nom, arma.nom) && tipo == arma.tipo;
    }
    @Override
    public int hashCode() {
        return Objects.hash(nom, ataque, tipo, valor);
    }

    @Override
    public int compareTo(Arma o) {
        int resultado = this.getTipo().compareTo(o.getTipo());
        if (resultado == 0) {
            resultado = Integer.compare(this.ataque, o.getAtaque());
        }
        return resultado;
    }
}
