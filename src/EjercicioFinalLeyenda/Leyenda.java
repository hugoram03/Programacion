package EjercicioFinalLeyenda;

import EjercicioFinalLeyenda.Objetos.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

public class Leyenda implements Serializable {
    @Serial
    private static final long serialVersionUID = -87991492884005033L;
    private static final String FICHERO_ARMAS = "src/EjercicioFinalLeyenda/Ficheros/armas.csv";
    private static final String FICHERO_PERSONAJES = "src/EjercicioFinalLeyenda/Ficheros/personajes.csv";
    private static Logger LOGGER = LogManager.getRootLogger();
    private List<Personaje> personajes = new LinkedList<>();
    private Map<Integer, Arma> armas = new TreeMap<>();
    private Personaje jugador;

    public Leyenda() {
        cargarArmas();
        cargarPersonajes();
    }
    public void jugar(boolean guardar) {
        Scanner sc = new Scanner(System.in);
        boolean muerte;
        boolean ganador = Boolean.FALSE;
        boolean salir = Boolean.FALSE;
        int contador = 1;
        if (!guardar) {
            System.out.println("Para poder jugar necesitas tener un personaje propio:");
            crearJugador(sc);
            System.out.println("Introduce un caracter para continuar");
            sc.next();
            sc.nextLine();
        }
        do {
            muerte = evento(sc, contador);
            System.out.println("\nTienes " + jugador.getOro() + " de oro\n");
            sc.nextLine();

            if (contador % 5 == 0 && !muerte) {
                System.out.println("¿Deseas guardar la partida y salir? (s/n)");
                String opcion = sc.nextLine();

                if (opcion.equals("s")) {
                    System.out.println("Has seleccionado guardar partida");
                    Main.guardarEstado(this);
                    salir = Boolean.TRUE;
                } else {
                    System.out.println("No se ha guardado la partida");
                }
            }
            if (contador % 7 == 0 && !muerte) {
                System.out.println("¿Deseas crear un arma pesonalizada? (s/n)");
                String opcion = sc.nextLine();
                if (opcion.equals("s")) {
                    System.out.println("Has seleccionado crear arma personalizada");
                    crearArma(sc);
                } else {
                    System.out.println("Siguiendo con el programa...");
                }
            }
            if (jugador.getOro() >= 1000 && !muerte) {
                System.out.println("Enhorabuena, has conseguido 1000 y has ganado!");
                ganador = Boolean.TRUE;
            }
            contador++;
        } while (!muerte || ganador || !salir);
    }
    public boolean evento(Scanner sc, int contador) {
        //TODO poder hablar con el personaje que nos encontremos
        Random r = new Random();
        boolean muerte = Boolean.FALSE;
        boolean retry;
        int n = r.nextInt(0, personajes.size());
        Personaje personaje = personajes.get(n);

        System.out.println("\nTe has encontrado con " + personaje.getNombre() + " y es un " + personaje.getRol());
        System.out.println("¿Qué deseas hacer?\n" +
                "\t1: Atacar\n" +
                "\t2: Comerciar\n" +
                "\t3: Robar");
        do {
            retry = Boolean.FALSE;
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado atacar");
                    muerte = atacar(sc, personaje, contador);
                    break;
                case "2":
                    System.out.println("Has seleccionado comerciar");
                    muerte = comerciar(sc, personaje, contador);
                    break;
                case "3":
                    System.out.println("Has seleccionado robar");
                    muerte = robar(sc, personaje, contador);
                    break;
                default:
                    System.out.println("Valor incorrecto porfavor vuelve a probar:");
                    retry = Boolean.TRUE;
            }
        } while (retry);
        System.out.println("Introduce un cualquier caracter para continuar:");
        sc.next();

        return muerte;
    }
    private boolean atacar(Scanner sc, Personaje personaje, int contador){
        String opcion;
        AtaqueComparator a = new AtaqueComparator();
        boolean muerte = Boolean.FALSE;
        System.out.println("Tienes un ataque de " + jugador.getArma().getAtaque());
        System.out.println("Tu contrincante tiene un ataque de " + personaje.getArma().getAtaque());
        if ( a.compare(jugador.getArma(), personaje.getArma()) >= 0) {
            System.out.println("¡Has ganado el combate! Has ganado " + personaje.getOro() + " de oro");
            jugador.setOro(jugador.getOro() + personaje.getOro());
        } else {
            System.out.println("Oh no, has muerto intentando sobrevivir");
            muerte = Boolean.TRUE;
        }
        if ((contador % 3 == 0) && !muerte) {
            System.out.print("El arma de tu contrincante era:\n" +
                    "\t");
            personaje.getArma().mostrarInfo();
            System.out.println("¿Quieres quedarte con ella? (s/n) ");
            opcion = sc.nextLine();
            if (opcion.equals("s")) {
                System.out.println("Te has quedado con el arma de tu contrincante");
                jugador.setArma(personaje.getArma());
            } else {
                System.out.println("No has cogido su arma");
            }
        }
        return muerte;
    }
    private boolean comerciar(Scanner sc, Personaje personaje, int contador) {
        boolean muerte = Boolean.FALSE;
        if (personaje.getRol() != Rol.REY && personaje.getRol() != Rol.NECROFAGO) {
            System.out.println(personaje.getNombre() + " tiene la siguiente arma:");
            personaje.getArma().mostrarInfo();
            System.out.println("¿La compras? (s/n)");
            String opcion = sc.nextLine();
            switch (opcion) {
                case "s":
                    if (jugador.getOro() - personaje.getArma().getValor() >= 0) {
                        System.out.println("Te has quedado con el arma de " + personaje.getNombre());
                        jugador.setArma(personaje.getArma());
                        jugador.setOro(jugador.getOro() - personaje.getArma().getValor());
                    } else {
                        System.out.println("No tienes suficiente oro");
                    }
                    break;
                default:
                    System.out.println("No has comprado su arma");
            }
        } else {
            System.out.println(personaje.getNombre() + " te ha atacado!");
            muerte = atacar(sc, personaje, contador);
        }
        return muerte;
    }
    private boolean robar(Scanner sc, Personaje personaje, int contador) {
        Random r = new Random();
        int n = r.nextInt(0,11);
        int oro = (personaje.getOro() - n);
        boolean muerte = Boolean.FALSE;
        if (personaje.getRol() != Rol.AVENTURERO && personaje.getRol() != Rol.NECROFAGO && personaje.getRol() != Rol.TECNICO) {
            System.out.println("Has amenazado a " + personaje.getNombre() + " y te ha dado " + oro + " de oro");
            jugador.setOro(jugador.getOro() + oro);
        } else {
            System.out.println(personaje.getNombre() + " te ha atacado!");
            muerte = atacar(sc, personaje, contador);
        }
        return muerte;
    }

    public void crearJugador(Scanner sc) {
        boolean retry;
        Rol rol = Rol.NECROFAGO;
        String nombre;
        System.out.println("\nCreación de personaje:");
        System.out.println("Introduce un nombre para tu personaje:");
        nombre = sc.nextLine();
        System.out.println("Los personajes tienen un rol. Elige uno\n");
        mostrarRoles();
        System.out.print("Introduce la opcion: ");
        do {
            retry = false;
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado NECROFAGO. Recuerda que es un personaje a MELÉ");
                    break;
                case "2":
                    System.out.println("Has seleccionado AVENTURERO. Recuerda que es un personaje a MELÉ");
                    rol = Rol.AVENTURERO;
                    break;
                case "3":
                    System.out.println("Has seleccionado MAGO. Recuerda que es un personaje a HECHIZOS");
                    rol = Rol.MAGO;
                    break;
                case "4":
                    System.out.println("Has seleccionado TECNICO ARMAMENTÍSTICO. Recuerda que es un personaje a FUSIL");
                    rol = Rol.TECNICO;
                    break;
                case "5":
                    System.out.println("Has seleccionado TECNICO ARMAMENTÍSTICO. Recuerda que es un personaje con ARCO");
                    rol = Rol.REY;
                    break;
                default:
                    System.out.println("Valor incorrecto vuelvelo a intentar:");
                    retry = true;
            }
            Arma arma = obtenerArma();
            System.out.println("Se te ha asignado la siguiente Arma " + arma.getNom());
            arma.setAtaque(determinarHandicap(rol, arma));
            System.out.println("Tu arma tiene un daño de " + arma.getAtaque());
            System.out.println("Por ultimo, empiezas con 0 de oro");
            jugador = new Personaje(nombre,arma, rol, 0);
        } while (retry);
    }
    public void mostrarRoles() {
        System.out.println(
                "\t1: NECROFAGO: " + Rol.NECROFAGO.getDescip() + "\n" +
                        "\t2: AVENTURERO: " + Rol.AVENTURERO.getDescip() + "\n" +
                        "\t3: MAGO: " + Rol.MAGO.getDescip() + "\n" +
                        "\t4: TECNICO ARMAMENTÍSTICO: " + Rol.TECNICO.getDescip() + "\n" +
                        "\t5: REY: " + Rol.REY.getDescip());
    }
    public void cargarArmas() {
        try(BufferedReader br = new BufferedReader(new FileReader(FICHERO_ARMAS))){
            String linea;
            String[] datos;
            int contador = 0;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(";");
                if (!datos[0].equals("NOMBRE")) {
                    armas.put(contador, new Arma(datos[0], Integer.parseInt(datos[1]), Tipo.valueOf(datos[2]), Integer.parseInt(datos[3]), datos[4]));
                    contador++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las armas");
            LOGGER.error(e.getMessage() + " " + e.getStackTrace());
        }
    }
    public void cargarPersonajes() {
        try(BufferedReader br = new BufferedReader(new FileReader(FICHERO_PERSONAJES))){
            String linea;
            String[] datos;
            String[] datosArma;
            Arma arma;
            while ((linea = br.readLine()) != null) {
                datos = linea.split(":");
                if (!datos[0].equals("NOMBRE")) {
                    datosArma = datos[1].split(";");
                    arma = new Arma(datosArma[0], Integer.parseInt(datosArma[1]), Tipo.valueOf(datosArma[2]), Integer.parseInt(datosArma[3]), datosArma[4]);
                    personajes.add(new Personaje(datos[0], arma, Rol.valueOf(datos[2]), Integer.parseInt(datos[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los personajes");
            LOGGER.error(e.getMessage() + " " + e.getStackTrace());
        }
    }
    // Al mostrarse todas las armas se usa el compareTo();
    public void mostrarArmas(String tipo) {
        Set<Arma> treeSet = new TreeSet<>();

        for (Map.Entry arma : armas.entrySet()) treeSet.add((Arma) arma.getValue());

        for(Arma arma : treeSet) {
            if (!tipo.equals(Tipo.ARCO.toString()) && !tipo.equals(Tipo.MELE.toString()) && !tipo.equals(Tipo.HECHIZO.toString()) && !tipo.equals(Tipo.FUSIL.toString())) {
                arma.mostrarInfo();
            } else if (arma.getTipo().toString().equals(tipo)) {
                arma.mostrarInfo();
            }
        }
    }
    public void mostrarIntrucciones() {
        System.out.println("\n¡Bienvenido a la Leyenda!\n" +
                "\tEste juego consiste en sobrevivir contra diferentes personajes que te irás encontrando en el camino\n" +
                "\tCuando te encuentres con un personaje, tendrás diferentes acciones que podras realizar para cada uno\n" +
                "\tEs muy importante que prestes atención a tu Rol y a tu Tipo de arma, ya que si consigues un arma que tu personaje no sabe controlar, perderá efectividad al batallar\n" +
                "\tAl principio se te asignará un Arma aleatoria, pero con forme te vayas encontrando con Personajes, podrás quedarte algunas veces con sus armas" +
                "\tEl objetivo es llegar a 1000 monedas, aunque, ¡Tus monedas sirven para algo más! Puedes crear armas personalizadas, cuanto mas daño tengan, mas dinero te costará\n" +
                "¡Suerte y esperamos que te diviertas!\n");
    }
    public Arma obtenerArma() {
        Random r = new Random();
        int n = r.nextInt(0, armas.size());
        return armas.get(n);
    }
    public int determinarHandicap(Rol rol, Arma arma) {
        Tipo tipo = arma.getTipo();
        int nuevoAtaque = arma.getAtaque();
        if (tipo == Tipo.MELE && (rol != Rol.AVENTURERO && rol != Rol.NECROFAGO)){
            nuevoAtaque = arma.getAtaque() - 5;
        }
        if (tipo == Tipo.HECHIZO && rol != Rol.MAGO) {
            nuevoAtaque = arma.getAtaque() - 5;
        }
        if (tipo == Tipo.FUSIL && rol != Rol.TECNICO){
            nuevoAtaque = arma.getAtaque() - 5;
        }
        if (tipo == Tipo.ARCO && rol != Rol.REY) {
            nuevoAtaque = arma.getAtaque() - 5;
        }

        return nuevoAtaque;
    }

    public void crearArma(Scanner sc) {
        boolean retry;
        final int PRECIO_10 = 50;
        final int PRECIO_12 = 100;
        final int PRECIO_14 = 150;
        final int PRECIO_16 = 200;
        final int PRECIO_18 = 300;
        final int PRECIO_20 = 400;
        System.out.println("Para crear un arma necesitas oro, cuanto mas ataque, mas oro necesitaras para crearla. Estos son los precios:\n" +
                "\t1: 10 de daño - " + PRECIO_10 + " de oro\n" +
                "\t2: 12 de daño - " + PRECIO_12 + " de oro\n" +
                "\t3: 14 de daño - " + PRECIO_14 + " de oro\n" +
                "\t4: 16 de daño - " + PRECIO_16 + " de oro\n" +
                "\t5: 18 de daño - " + PRECIO_18 + " de oro\n" +
                "\t6: 20 de daño - " + PRECIO_20 + " de oro");
        System.out.println("Introduce el daño correspondiente");
        do {
            retry = Boolean.FALSE;
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Has seleccionado 10 de daño");
                    break;
                case "2":
                    System.out.println("Has seleccionado 12 de daño");
                    break;
                case "3":
                    System.out.println("Has seleccionado 14 de daño");
                    break;
                case "4":
                    System.out.println("Has seleccionado 16 de daño");
                    break;
                case "5":
                    System.out.println("Has seleccionado 18 de daño");
                    break;
                case "6":
                    System.out.println("Has seleccionado 20 de daño");
                    break;
                default:
                    System.out.println("Valor incorrecto. Vuelvelo a intentar:");
                    retry = Boolean.TRUE;
            }
        } while (retry);
        //TODO terminar crear arma
    }

    //TODO crearArma a cambio de dinero cuanto mas daño mas dinero
    //TODO crear frases y clase Frase
    //TODO cargarFrases

}