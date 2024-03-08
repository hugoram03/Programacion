package Ejercicios_Try_Catch.UsaCasa.oovv;


import java.util.IllegalFormatCodePointException;

public class Casa {

    private String calle;
    private String numero;
    private String poblacion;
    private double superficie;
    private boolean garaje;
    private int edadCasa;
    private int contCasas;
    public static final double SUPERFICIE_MINIMA = 43.5;

    public Casa() {
        contCasas++;
    }

    public Casa(String calle, String numero, String poblacion, double superficie, boolean garaje, int edadCasa) throws IllegalArgumentException{
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.superficie = superficie;
        this.garaje = garaje;
        this.edadCasa = edadCasa;
        incrementaContadorCasa();
        if (superficie < SUPERFICIE_MINIMA){
            throw new IllegalArgumentException("La superficie no puede ser menor a 43.5");
        }
        if (edadCasa < 0){
            throw new IllegalArgumentException("La edad de la casa no puede ser inferior o igual a 0");
        }
    }

    public Casa(String calle, String numero, String poblacion) {
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        incrementaContadorCasa();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public boolean isGaraje() {
        return garaje;
    }

    public void setGaraje(boolean garaje) {
        this.garaje = garaje;
    }

    public int getEdadCasa() {
        return edadCasa;
    }

    public void setEdadCasa(int edadCasa) {
        this.edadCasa = edadCasa;
    }

    public int getContCasas() {
        return contCasas;
    }

    public void setContCasas(int contCasas) {
        this.contCasas = contCasas;
    }

    public double getSUPERFICIE_MINIMA() {
        return SUPERFICIE_MINIMA;
    }

    public static String getDireccionCompleta(String calle, String numero, String poblacion) {
        return "C/" + calle + " nº" + numero + (Qutil.esVocal(poblacion.charAt(0)) ? " d'" + poblacion : " de " + poblacion);
    }


    public String getInfo() {
        return getDireccionCompleta(calle, numero, poblacion) + " superficie: " + superficie + "m2, " + ((garaje) ? "tiene garaje, edad = " + edadCasa : "no tiene garaje, edad = " + edadCasa);
    }

    public int getContadorCasas(int contCasas) {
        return contCasas;
    }

    private void incrementaContadorCasa() {
        contCasas++;
        System.out.println("Casas totales creadas: " + contCasas);
    }

    @Override
    public String toString() {
        return "C/" + calle + ", nº" + numero + ", " + (Qutil.esVocal(poblacion.charAt(0)) ? " d'" + poblacion : " de " + poblacion) + ", superficie=" + superficie + "m2, " + ((garaje) ? "tiene garaje, edad = " + edadCasa : "no tiene garaje, edad = " + edadCasa);
    }
}
