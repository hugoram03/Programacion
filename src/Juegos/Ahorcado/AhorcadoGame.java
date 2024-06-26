package Juegos.Ahorcado;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class AhorcadoGame {
    private Incognita[] incognitas;
    private Incognita incognitaAAdivinar;
    private ArrayList<Character> palabraOculta = new ArrayList<>();
    private ArrayList<Character> palabra = new ArrayList<>();

    public AhorcadoGame() {
        incognitas = guardarPalabras();
    }


    public Incognita[] guardarPalabras() {

        Random random = new Random();

        Incognita[] guardarIncognitas = new Incognita[7];

        for (int i = 0; i < 6; i++) {
            guardarIncognitas[i] = new Incognita("peliculas", Pelicula.peliculas[random.nextInt(5)]);
            guardarIncognitas[i += 1] = new Incognita("libros", Libro.libros[random.nextInt(5)]);
            guardarIncognitas[i += 1] = new Incognita("Grupos Musicales", GrupoMusical.gruposMusicales[random.nextInt(5)]);
        }


        incognitaAAdivinar = guardarIncognitas[random.nextInt(5)];
        return guardarIncognitas;
    }

    /*public Incognita[] cargarIncognita() throws IOException {
        ArrayList<Incognita> incognitas = new ArrayList<>();
        incognitas.addAll(cargarIncognitasFichero(incognitas,"\\src\\Juegos\\Ahorcado\\libros.txt", incognitaAAdivinar.setTipo("Libros")));
        incognitas.addAll(cargarIncognitasFichero(incognitas,"\\src\\Juegos\\Ahorcado\\peliculas.txt", incognitaAAdivinar.setTipo("Peliculas")));
        incognitas.addAll(cargarIncognitasFichero(incognitas,"\\src\\Juegos\\Ahorcado\\gruposMusicales.txt", incognitaAAdivinar.setTipo("GruposMusicales")));
        return incognitas.toArray(new Incognita[0]);
    }

    public ArrayList<Incognita> cargarIncognitasFichero(ArrayList incognitas, String fichero, String tipo) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = bufferedReader.readLine()) != null) {
            incognitas.add(new Incognita(tipo, linea.trim()));
        }
        bufferedReader.close();
        return incognitas;
    }*/

    public String mostrarIncognita() {
        return incognitaAAdivinar.getTexto();
    }

    public String mostrarTipo() {
        return incognitaAAdivinar.getTipo();
    }


    public String ocultarPalabra() {
        String texto = incognitaAAdivinar.getTexto();

        for (int i = 0; i < texto.length(); i++) {
            char character = texto.charAt(i);

            palabra.add(character);
            palabraOculta.add('-');
        }
        return texto(palabraOculta);
    }

    public String texto(ArrayList<Character> arrayPalabras) {
        StringBuilder resultado = new StringBuilder(arrayPalabras.size());
        for (Character c : arrayPalabras) {
            resultado.append(c);
        }
        return resultado.toString();
    }

    public Boolean verificarLetra(char letra) {
        boolean letraEncontrada = Boolean.FALSE;
        for (int i = 0; i < palabra.size(); i++) {
            if (palabra.get(i) == letra) {
                palabraOculta.set(i, letra);
                letraEncontrada = Boolean.TRUE;
            }
        }
        return letraEncontrada;
    }

    public String PalabraOcultaTXT() {
        return texto(palabraOculta);
    }

    public Boolean ganador() {
        Boolean ganador = false;
        if (mostrarIncognita().equalsIgnoreCase(PalabraOcultaTXT())){
            ganador = true;
            return ganador;
        }
        return ganador;
    }

    @Override
    public String toString() {
        return "\nBienvenido al Ahorcado,  12 intentos en total | La palabra a adivinar es: " + ocultarPalabra();
    }
}