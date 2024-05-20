package EjercicioFinal;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public Cliente comprobarCliente(String nombre) {
        Cliente c = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(nombre)){
                c = clientes.get(i);
            }
        }
        return c;
    }
}
