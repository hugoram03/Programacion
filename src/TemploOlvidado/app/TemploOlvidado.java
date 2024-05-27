package app;

import app.objetos.Batalla;
import app.objetos.ObjetoMagico;
import app.objetos.Personaje;
import app.utilidades.EntradaSalida;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class TemploOlvidado implements Serializable {

    private final String NOMBRE_ARCHIVO_PERSONAJES = "resources/bbdd/personajes.csv";
    private final String NOMBRE_ARCHIVO_OBJETOS = "resources/bbdd/objetos.csv";
    private final String NOMBRE_GUARDIANES = "guardianes";
    private final String NOMBRE_LADRONES = "ladrones";
    private final int NUM_OBJETOS_EQUIPADOS_PERMITIDOS = 3;
    private final int OPCION = 3;
    private final Logger LOGGER = LogManager.getRootLogger();

    private Scanner sc = new Scanner(System.in);

    private Batalla batallas;
    private Map<String, Personaje> personajes;
    private Map<Integer, ObjetoMagico> objetosMagicos;

    public TemploOlvidado() throws IOException {
        personajes = EntradaSalida.cargarCSVPersonas(NOMBRE_ARCHIVO_PERSONAJES);
        objetosMagicos = EntradaSalida.cargarCSVObjetos(NOMBRE_ARCHIVO_OBJETOS);
    }

    /**
     * Método que inicia el juego
     */
    public void jugar() throws IOException, ClassNotFoundException {
        int opcion = seleccionarOpcionMenu();
        switch (opcion) {
            case 1:
                jugarPartida();
                break;
            case 2:
                mostrarBatallasEpicas();
                break;
            case 3:
                System.out.println("Gracias por elegirnos. Hasta la próxima.");
                break;
            default:
                System.out.println("Opción no válida. El programa se cerrará.");
        }
    }

    private void mostrarBatallasEpicas() throws IOException, ClassNotFoundException {
        //TODO completar decidiendo el mejor tipo de colección para las batallas
        List<Batalla> batalla = EntradaSalida.recuperarBatallas();
        if (batalla == null || batalla.isEmpty()) {
            System.out.println("No hay batallas épicas que mostrar.");
            return;
        }

        System.out.println("\n**BATALLAS ÉPICAS**");
        int contador = 1;
        for (Batalla batalla1 : batalla) {
            StringBuilder sb = new StringBuilder();
            sb.append("\nBATALLA ").append(contador);
            sb.append(batalla1.isGanadaPorGuardianes() ? " ganada por los guardianes:\n" : " ganada por los ladrones:\n");
            System.out.println(sb);
            batalla1.luchar();
            contador++;
            System.out.println("-------------------------------------------------");
        }
    }

    /**
     * Método que juega una partida de Templo Olvidado
     */
    private void jugarPartida() {
        batallas = nuevoJuego();
        batallas.luchar();
        if (batallas.isGanadaPorGuardianes()) {
            System.out.println("Los guardianes han ganado la batalla. Esta batalla ha sido épica. Quedará almacenada " +
                    " en la historia del templo.");
        } else {
            System.out.println("Los guardianes han perdido la batalla. Para aprender de ella, dejaremos registro" +
                    " en la historia del templo.");
        }

        if (!EntradaSalida.almacenarBatalla(batallas)) {
            System.out.println("Lo sentimos, ha ocurrido un error y no se ha podido almacenar la batalla.");
        }
    }

    private int seleccionarOpcionMenu() {
        System.out.println("\nBienvenido al **TEMPLO OLVIDADO**");
        System.out.println("1. Jugar");
        System.out.println("2. Ver batallas épicas");
        System.out.println("3. Salir");
        System.out.print("\nSeleccione una opción: ");
        return sc.nextInt();
    }

    /**
     * Método que inicia y solicita lo necesario para empezar una nueva partida
     *
     * @return Batalla creada
     */
    private Batalla nuevoJuego() {
        int numeroPersonajes = seleccionNumeroPersonajes();
        List<Personaje> guardianes = crearEquiparPersonajes("Guardian", numeroPersonajes);
        List<Personaje> ladrones = crearEquiparPersonajes("Ladron", numeroPersonajes);
        //TODO completar
        return new Batalla(guardianes, ladrones);
    }

    private int seleccionNumeroPersonajes() {
        System.out.println("En primer lugar indica el número de guardianes que hay en el templo con un valor entre " +
                "1 y 5:");
        int num = 0;
        try {
            num = sc.nextInt();
            if (num <= 0 || num > 5) {
                do {
                    System.out.println("El número de guardianes debe ser un número entre 1 y 5. Vuelve a introducirlo:");
                    num = sc.nextInt();
                } while (num < 0 || num > 5);
            }
        } catch (InputMismatchException e) {
            LOGGER.error("El usuario ha introducido un valor no numérico.");
            System.out.println("El número de guardianes debía ser indicado mediante un número.");
        }
        return num;
    }

    /**
     * Método que crea a los personajes y los equipa con objetos mágicos solicitándole los datos al usuario. Cómo los
     * personajes pueden ser de dos tipos, es necesario que se le indique el tipo. También es necesario indicar el
     * número de personajes que se quieren crear.
     *
     * @param tipoPersonaje
     * @param cantidad
     * @return Coleccion de personajes creados y equipados
     */
    private List<Personaje> crearEquiparPersonajes(String tipoPersonaje, int cantidad) {
        //TODO completar decidiendo el mejor tipo de colección para los personajes
        // personajes = seleccionarPersonajes(tipoPersonaje, cantidad);
        List<Personaje> personajes = seleccionarPersonajes(tipoPersonaje, cantidad);
        if (personajes.isEmpty()) {
            return null;
        }
        if (equiparPersonajes(personajes, tipoPersonaje, cantidad)) {
            return personajes;
        }
        return null;
    }

    /**
     * Método que crea a los personajes. Como los personajes pueden ser de dos tipos, es necesario que se le indique
     * el tipo. También es necesario indicar el número de personajes que se quieren crear.
     *
     * @param tipoPersonaje
     * @param cantidad
     * @return Coleccion de personajes creados y equipados
     */
    private List<Personaje> seleccionarPersonajes(String tipoPersonaje, int cantidad) {
        //TODO completar decidiendo el mejor tipo de colección para los personajes
        List<Personaje> personajesSeleccionados = new ArrayList<>();

        //Construyo el mensaje de selección de personajes:
        StringBuilder sb = new StringBuilder();
        sb.append("Elije a ").append(construirMensajeNumero(cantidad, tipoPersonaje));
        sb.append(" de entre los siguientes personajes.");
        System.out.println(sb.toString());

        mostrarPersonajes();

        //Limpio el buffer
        sc.nextLine();

        for (int i = 1; i <= cantidad; i++) {
            System.out.println("Introduce el nombre completo del personaje " + (i) + ":");
            String nombre = sc.nextLine();
            //TODO completar en función de la colección elegida

            for (Map.Entry<String, Personaje> entry : personajes.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(nombre)) {
                    Personaje personaje = entry.getValue();
                    personajesSeleccionados.add(personaje);
                }
            }

            /*for (int j = 0; j < personajes.size(); j++) {
                if (personajes.get(j).getNombre().equals(nombre)) {
                    try {
                        Personaje personaje = personajes.get(j);
                        //personaje = new Personaje(personaje.getNombre(), personaje.getClase(), personaje.getPenalizacion(), personaje.getPuntosExperiencia(), personaje.getAtributo());
                        personajesSeleccionados.add(personaje);
                    } catch (NullPointerException e) {
                        LOGGER.error("Aparicion de nulo");
                    }
                } else {
                    System.out.println("El personaje no existe. Prueba de nuevo.");
                    i--;
                }
            }*/
        }
        return personajesSeleccionados;
    }

    /**
     * Método que equipa a los personajes con objetos mágicos. Como los personajes pueden ser de dos tipos, es
     * necesario que se le indique el tipo. También es necesario indicar el número de personajes que se quieren crear.
     *
     * @param personajes    es necesario pasarle la colección de personajes
     * @param tipoPersonaje
     * @param cantidad
     * @return true si se han equipado correctamente, false en caso contrario
     */
    private boolean equiparPersonajes(List<Personaje> personajes, String tipoPersonaje, int cantidad) {
        //TODO completar con el mejor tipo de colección para los personajes

        //Construyo el mensaje de selección de personajes:
        List<ObjetoMagico> objetosMagicosAnadidos = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("Ahora debes equipar a ").append(construirMensajeNumero(cantidad, tipoPersonaje));
        sb.append(" con ").append(NUM_OBJETOS_EQUIPADOS_PERMITIDOS).append(" objetos mágicos");
        sb.append(cantidad > 1 ? " para cada uno." : ".");
        System.out.println(sb);

        mostrarObjetosMagicos();

        int id = sc.nextInt();
        objetosMagicosAnadidos.add(objetosMagicos.get(id));

        for (Personaje personaje : personajes) {
            System.out.println("Introduce el identificador del objeto mágico 1 que quieres equipar a " + personaje);
            sc.nextLine();
            equipar(personaje, objetosMagicosAnadidos);

            //TODO Completar
        }
        return Boolean.TRUE;
    }

    /**
     * Método que equipa a un personaje con los objetos mágicos seleccionados por el usuario. Se le solicita al
     * usuario que introduzca el identificador de los objetos mágicos que quiere equipar al personaje. Se equipará al
     * personaje con tanto objetos mágicos como se le indique en la constante NUM_OBJETOS_EQUIPADOS_PERMITIDOS.
     *
     * @param personaje
     * @return Coleccion de objetos
     */
    private List<ObjetoMagico> equipar(Personaje personaje) {
        //TODO crear la colección de objetos mágicos del mejor tipo posible
        List<ObjetoMagico> objetosMagicos = null;
        for (int i = 0; i < personaje.getObjetosMagicos().size(); i++) {
            objetosMagicos.add(personaje.getObjetosMagicos().get(i));
        }
        return objetosMagicos;
    }

    private void mostrarPersonajes() {
        for (Personaje clave : personajes.values()) {
            System.out.println(clave);
        }
    }

    private void mostrarObjetosMagicos() {
        for (ObjetoMagico clave : objetosMagicos.values()) {
            System.out.println(clave);
        }
    }

    private String construirMensajeNumero(int cantidad, String tipoPersonaje) {
        StringBuilder sb = new StringBuilder();
        sb.append("tu").append(cantidad > 1 ? "s " + cantidad + " " : " ");
        if (cantidad > 1) {
            sb.append(tipoPersonaje.equals(NOMBRE_GUARDIANES) ? "GUARDIANES" : "LADRONES");
        } else {
            sb.append(tipoPersonaje.equals(NOMBRE_GUARDIANES) ? "GUARDIÁN" : "LADRÓN");
        }
        return sb.toString();
    }
}
