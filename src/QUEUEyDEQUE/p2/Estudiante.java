package QUEUEyDEQUE.p2;

import java.text.Collator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private double notaMedia;
    private String fechaTransformada;
    private Collator miCollator = Collator.getInstance();

    public Estudiante(String nombre, String apellidos, LocalDate fechaNacimiento, double notaMedia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.notaMedia = notaMedia;
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaTransformada = fechaNacimiento.format(formatoFecha);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public String getFechaTransformada() {
        return fechaTransformada;
    }

    public void setFechaTransformada(String fechaTransformada) {
        this.fechaTransformada = fechaTransformada;
    }

    public String getEdad() {
        LocalDate fechaActual = LocalDate.now();
        int edad = fechaActual.getYear() - fechaNacimiento.getYear();
        String edadTXT = edad + "";
        return edadTXT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Double.compare(notaMedia, that.notaMedia) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(apellidos, that.apellidos) && Objects.equals(fechaNacimiento, that.fechaNacimiento) && Objects.equals(fechaTransformada, that.fechaTransformada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellidos, fechaNacimiento, notaMedia, fechaTransformada);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaTransformada +
                ", notaMedia= " + notaMedia +
                '}';
    }

    @Override
    public int compareTo(Estudiante other) {
        int resultado = miCollator.compare(this.getNotaMedia(), other.getNotaMedia());
        if (resultado == 0) {
            resultado = miCollator.compare(this.getNombre(), other.getNombre());
        }
        if (resultado == 0){
            resultado = miCollator.compare(this.getApellidos(), other.getApellidos());
        }
        return resultado;
    }
}