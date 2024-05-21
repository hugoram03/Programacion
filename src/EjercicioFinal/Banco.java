package EjercicioFinal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class Banco {
    static Logger LOGGER = LogManager.getRootLogger();
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente comprobarCliente(String nombre) {
        Cliente c = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).equals(nombre)) {
                c = clientes.get(i);
            }
        }
        return c;
    }

    public void guardarFichero(File fichero) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fichero,true));
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                bw.write(cliente.getNombre() + ";" + cliente.getDireccion() + ";");
                for (int j = 0; j < cliente.getCuentasCliente().size(); j++) {
                    bw.write(cliente.getCuentasCliente().get(i).getNumeroCuenta() + ";" + cliente.getCuentasCliente().get(i).getSaldo() + ";" + cliente.getCuentasCliente().get(i).getTitular());
                }
                bw.newLine();
            }
            bw.close();
    }
}
