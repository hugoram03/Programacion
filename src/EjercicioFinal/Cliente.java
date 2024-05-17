package EjercicioFinal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Cliente {
    private String nombre;
    private String direccion;
    private Collection<Cuenta> cuentasCliente = new ArrayList<>();
    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Collection<Cuenta> getCuentasCliente() {
        return cuentasCliente;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentasCliente.add(cuenta);
    }

    public void eliminarCuenta(String numCuenta) {
        for (Cuenta cuentaBuscada : cuentasCliente) {
            if (cuentaBuscada.getNumeroCuenta().equals(numCuenta)){
                cuentasCliente.remove(cuentaBuscada);
                System.out.println("Cuenta eliminada correctamente");
            } else {
                System.out.println("La cuenta no se ha encontrado o no se puede borrar");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(nombre, cliente.nombre) && Objects.equals(direccion, cliente.direccion) && Objects.equals(cuentasCliente, cliente.cuentasCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, direccion, cuentasCliente);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cuentasCliente=" + cuentasCliente +
                '}';
    }
}
