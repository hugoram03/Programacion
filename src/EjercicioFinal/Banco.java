package EjercicioFinal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Banco implements Serializable {
    private List<Cliente> clientes = new ArrayList<>();
    private static final long serialVersionUID = 6433858223774886977L;

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente comprobarCliente(String nombre) {
        Cliente c = null;
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getNombre().equals(nombre)) {
                c = clientes.get(i);
            }
        }
        return c;
    }

    public void guardarFichero(File fichero) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero));
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            bw.write(cliente.getNombre() + ";" + cliente.getDireccion() + ";");
            for (int j = 0; j < cliente.getCuentasCliente().size(); j++) {
                bw.write(cliente.getCuentasCliente().get(j).getNumeroCuenta() + ";" + cliente.getCuentasCliente().get(j).getSaldo() + ";" + cliente.getCuentasCliente().get(j).getTitular() + ";");
            }
            bw.newLine();
        }
        bw.close();
    }

    public void cargarFichero(File fichero) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichero));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] campos = linea.split(";");
            Cliente cliente = new Cliente(campos[0], campos[1]);
            clientes.add(cliente);
            for (int i = 2; i < campos.length; i += 3) {
                cliente.agregarCuenta(new Cuenta(campos[i], Double.parseDouble(campos[i + 1]), campos[i + 2]));
            }
        }
        br.close();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return Objects.equals(clientes, banco.clientes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientes);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "clientes=" + clientes +
                '}';
    }
}