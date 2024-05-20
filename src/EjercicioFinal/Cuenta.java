package EjercicioFinal;

import java.text.Collator;
import java.util.Objects;

public class Cuenta implements Comparable<Cuenta> {
    private String numeroCuenta;
    private double saldo;
    private String titular;
    private Collator miCollator = Collator.getInstance();

    public Cuenta(String numeroCuenta, double saldo, String titular) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.titular = titular;
    }


    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(int dinero) {
        setSaldo(getSaldo() + dinero);
    }

    public void retirar(double dinero) {
        setSaldo(getSaldo() - dinero);
    }

    public void consultarSaldo(){
        System.out.println("Saldo actual: " + getSaldo());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return Objects.equals(numeroCuenta, cuenta.numeroCuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroCuenta);
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", titular='" + titular + '\'' +
                '}';
    }

    @Override
    public int compareTo(Cuenta o) {
        return miCollator.compare(this.numeroCuenta, o.numeroCuenta);
    }
}
