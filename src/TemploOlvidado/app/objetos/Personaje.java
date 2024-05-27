package app.objetos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Personaje implements Cloneable, Serializable {

    //TODO completar manteniendo el nombre de las variables propuestas
    private String nombre;
    private Clase clase;
    private Atributo atributo;
    private int penalizacion;
    private int puntosExperiencia;
    private Boolean esGanador;
    private List<ObjetoMagico> objetosMagicos = new ArrayList<>();

    public Personaje(String nombre, Clase clase, int penalizacion, int puntosExperiencia, Atributo atributo) {
        this.nombre = nombre;
        this.clase = clase;
        this.penalizacion = penalizacion;
        this.puntosExperiencia = puntosExperiencia;
        this.atributo = atributo;
    }

    public Personaje() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public int getPenalizacion() {
        return penalizacion;
    }

    public void setPenalizacion(int penalizacion) {
        this.penalizacion = penalizacion;
    }

    public int getPuntosExperiencia() {
        return puntosExperiencia;
    }

    public void setPuntosExperiencia(int puntosExperiencia) {
        this.puntosExperiencia = puntosExperiencia;
    }

    public Boolean getEsGanador() {
        return esGanador;
    }

    public void setEsGanador(Boolean esGanador) {
        this.esGanador = esGanador;
    }

    public List<ObjetoMagico> getObjetosMagicos() {
        return objetosMagicos;
    }

    public int getValentia(){
        return clase.getPuntuacion() - getPenalizacion() + getPuntosExperiencia();
    }

    /**
     * Obtiene los datos del personaje en el formato necesario para mostrarlos en pantalla de Versus
     * @return String con el nombre del personaje, su clase y su atributo
     */
    public String getDatosParaVS(){
        return this.nombre + ", " + this.clase + ", " + this.atributo + ", " + this.getValentia();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", clase=" + clase +
                ", atributo=" + atributo +
                ", penalizacion=" + penalizacion +
                ", puntosExperiencia=" + puntosExperiencia +
                ", objetosMagicos=" + objetosMagicos +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
