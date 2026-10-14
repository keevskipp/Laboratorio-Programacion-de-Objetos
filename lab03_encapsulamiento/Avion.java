package lab03_encapsulamiento;

public class Avion extends Vehiculo {
    // 1. Atributos propios
    private double altitudMaxima;
    private String aerolinea;

    // 3. Constructor
    public Avion(String marca, String modelo, int anio, double velocidadMax, double altitudMaxima, String aerolinea) {
        super(marca, modelo, anio, velocidadMax);
        setAltitudMaxima(altitudMaxima);
        this.aerolinea = aerolinea;
    }

    // 4. Getters y Setters
    public double getAltitudMaxima() {
        return altitudMaxima;
    }

    public void setAltitudMaxima(double altitudMaxima) {
        if (altitudMaxima > 0 && altitudMaxima <= 15000) { // Validamos que tenga sentido
            this.altitudMaxima = altitudMaxima;
        } else {
            System.out.println("Error: La altitud máxima no es válida (debe ser mayor a 0).");
        }
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    // 5. toString
    @Override
    public String toString() {
        return super.toString() + "\nAltitud Máx: " + altitudMaxima + " m | Aerolínea: " + aerolinea;
    }
}