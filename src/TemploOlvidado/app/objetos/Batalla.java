package app.objetos;

import app.utilidades.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase que representa una batalla entre guardianes y ladrones
 */
public class Batalla implements Cloneable, Serializable {

    //TODO completar decidiendo el mejor tipo de colección para ambas variables, mantener el nombre de los atributos

    /**
     * guardianes;
     * ladrones;
     **/
    private boolean ganadaPorGuardianes;

    //Variable auxiliar que se utiliza para imprimir la razón por la que un personaje ha ganado o perdido
    private String motivo;

    //TODO completar en el código siguiente falta decidir el tipo de colección más apropiado
    private List<Personaje> guardianes;
    private List<Personaje> ladrones;

    public Batalla(List<Personaje> guardianes, List<Personaje> ladrones) {
        this.guardianes = guardianes;
        this.ladrones = ladrones;
    }

    /**
     * Método que simula la lucha entre guardianes y ladrones
     */
    public boolean luchar() {
        //TODO Clono los guardianes y ladrones para poder gestionarlos sin eliminarlos de la batalla, eligiendo la
        // colección más adecuada
        List<Personaje> guardianesClone = this.guardianes;//.clone();
        List<Personaje> ladronesClone = this.ladrones;//.clone();

        int guardianesSize = guardianesClone.size();
        int numGanadas = 0; //Solo contamos las ganadas por los guardianes

        //He sacado la inicializacion de personajes fuera del for para poder usar las instancias guardian y ladron en el if de mas abajo
        Personaje guardian = null;
        Personaje ladron = null;
        for (int i = 0; i < guardianesSize; i++) {
            guardian = obtenerContrincante(ladron, guardianesClone);
            ladron = obtenerContrincante(guardian, ladronesClone);

            boolean guardianVencedor = esGuardianVencedor(guardian, ladron);
            if (guardianVencedor) {
                numGanadas++;
            }
            imprimirResultado(guardian, ladron, guardianVencedor);
        }

        //TODO completar el if
        if (esGuardianVencedor(guardian, ladron)) {
            ganadaPorGuardianes = Boolean.TRUE;
        } else {
            ganadaPorGuardianes = Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    private Personaje obtenerContrincante(Personaje guardian, List<Personaje> ladronesClone) {

        return guardian;
    }

    /**
     * Método que imprime por pantalla el resultado de un cuerpo a cuerpo entre un guardián y un ladrón. Se debe
     * indicar cual ha sido el vencedor. Será conveniente que esté rellenada la variable auxiliar motivo, con el
     * motivo por el cual ha ganado.
     *
     * @param guardian
     * @param ladron
     * @param guardianVencedor
     */
    private void imprimirResultado(Personaje guardian, Personaje ladron, boolean guardianVencedor) {
        StringBuilder cadena = new StringBuilder();
        cadena.append("Guardián: " + guardian.getDatosParaVS()).append("\n");
        for (ObjetoMagico objeto : guardian.getObjetosMagicos()) {
            cadena.append("\t" + objeto.getDatosParaVS()).append("\n");
        }
        cadena.append("vs ");
        cadena.append("\nLadrón: " + ladron.getDatosParaVS()).append("\n");
        for (ObjetoMagico objeto : ladron.getObjetosMagicos()) {
            cadena.append("\t" + objeto.getDatosParaVS()).append("\n");
        }
        cadena.append(guardianVencedor ? "GUARDIÁN GANA" : "LADRÓN GANA ");
        cadena.append(" --> ").append(motivo).append("\n");
        System.out.println(cadena);
    }

    private boolean esGuardianVencedor(Personaje guardian, Personaje ladron) {
        if ((guardian.getObjetosMagicos() == null) || (ladron.getObjetosMagicos() == null)){
            return Boolean.TRUE;
        }
        if (guardian.getValentia() > ladron.getValentia()){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public boolean isGanadaPorGuardianes() {
        return ganadaPorGuardianes;
    }

    public void setGanadaPorGuardianes(boolean ganadaPorGuardianes) {
        this.ganadaPorGuardianes = ganadaPorGuardianes;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
