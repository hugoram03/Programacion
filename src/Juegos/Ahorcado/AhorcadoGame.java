package Juegos.Ahorcado;

import java.util.ArrayList;
import java.util.Random;

public class AhorcadoGame {
        private Incognita[] incognitas;
        private Incognita incognitaAAdivinar;
        private ArrayList<Character> palabraOculta = new ArrayList<>();
        private ArrayList<Character> palabra = new ArrayList<>();

        public AhorcadoGame() {
            incognitas = guardarPalabras();
        }

        public int datos() {
            return incognitas.length;
        }

        public Incognita[] guardarPalabras() {

            Random random = new Random();

            Incognita[] guardarIncognitas = new Incognita[6];

            for (int i = 0; i < 5; i++) {
                guardarIncognitas[i] = new Incognita("peliculas", Pelicula.peliculas[random.nextInt(5)]);
                guardarIncognitas[i+=1] = new Incognita("libros", Libro.libros[random.nextInt(5)]);
                guardarIncognitas[i+=1] = new Incognita("Grupos Musicales", GrupoMusical.gruposMusicales[random.nextInt(5)]);
            }


            incognitaAAdivinar = guardarIncognitas[random.nextInt(5)];
            return guardarIncognitas;
        }

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

        public String cambios() {
            return texto(palabraOculta);
        }

        public String letrasIntroducidas(ArrayList<Character> letras) {
            StringBuilder resultado = new StringBuilder(palabraOculta.size());
            for (char c : letras) {
                resultado.append(c + ",");
            }
            return resultado.toString();
        }

        public Boolean ganador() {
            Boolean opcion = false;
            if (incognitaAAdivinar.equals(cambios())) {
                opcion = true;
               return opcion;
            }
            return opcion;
        }

    @Override
    public String toString() {
        return "\nBienvenido al Ahorcado,  12 intentos en total | La palabra a adivinar es: " + ocultarPalabra();
    }
}