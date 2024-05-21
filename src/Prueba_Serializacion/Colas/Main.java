package Prueba_Serializacion.Colas;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        //offer() para meter objetos a la cola
        //peek() Se usa con != de null para saber si la cola esta vacia
        //poll() para mostrar los objetos de dentro de la cola y despues lo elimina
        Queue<Integer> cola = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            cola.offer(i);
        }
        while (cola.peek() != null){
            System.out.println(cola.poll());
        }
    }
}
