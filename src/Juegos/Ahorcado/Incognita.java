package Juegos.Ahorcado;

import java.util.Objects;

public class Incognita {

    private Incognita[] incognitas;
    private String texto;
    private String tipo;

    public Incognita(String tipo, String texto) {
        this.texto = texto;
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public String getTipo() {
        return tipo;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incognita incognita = (Incognita) o;
        return Objects.equals(texto, incognita.texto) && Objects.equals(tipo, incognita.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, tipo);
    }



    @Override
    public String toString() {
        return "Tipo y texto de la incognita: " + getTipo() + getTexto();
    }



}
