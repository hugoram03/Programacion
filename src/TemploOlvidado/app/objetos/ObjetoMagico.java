package app.objetos;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

/**
 * Clase que representa un objeto mágico
 */
public final class ObjetoMagico implements Serializable{

    //TODO completar manteniendo el nombre de las variables propuestas
    private final int id = 0;
    private final Atributo atributo;
    private final String nombre;
    private final int poder;

    /**
     * Crea una instancia de ObjetoMagico a partir de una línea de un fichero CSV
     * @param linea con el formato id;nombre;atributo;poder
     * @return una instancia de ObjetoMagico o null si la línea no tiene el formato correcto
     */

    /*public static ObjetoMagico crearInstanciaDeCSV(String linea){
        //TODO completar
    }*/

    /**
     * Obtiene los datos del personaje en el formato necesario para mostrarlos en pantalla de Versus
     * @return String con el nombre del personaje, su clase y su atributo
     */
    public String getDatosParaVS(){
        return this.id + " -> " + this.nombre + ", " + this.atributo + ", " + this.poder;
    }

    public ObjetoMagico(String nombre, Atributo atributo, int poder) {
        this.atributo = atributo;
        this.nombre = nombre;
        this.poder = poder;
    }

    public int getId() {
        return id;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoder() {
        return poder;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ObjetoMagico{");
        sb.append("id=").append(getId());
        sb.append(", atributo=").append(getAtributo());
        sb.append(", nombre='").append(getNombre()).append('\'');
        sb.append(", poder=").append(getPoder());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ObjetoMagico that = (ObjetoMagico) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
