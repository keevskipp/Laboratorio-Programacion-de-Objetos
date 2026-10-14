package lab03_encapsulamiento;

public class Barco extends Vehiculo {
    private double tonelajeMaximo;
    private String tipoCasco;

    public Barco(String marca, String modelo, int anio, double velocidadMax, double tonelajeMaximo, String tipoCasco) {
        super(marca, modelo, anio, velocidadMax);
        setTonelajeMaximo(tonelajeMaximo);
        this.tipoCasco = tipoCasco;
    }

    public double getTonelajeMaximo() {
        return tonelajeMaximo;
    }

    public void setTonelajeMaximo(double tonelajeMaximo) {
        if (tonelajeMaximo > 0) {
            this.tonelajeMaximo = tonelajeMaximo;
        } else {
            System.out.println("Error: El tonelaje máximo debe ser positivo.");
        }
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    public void setTipoCasco(String tipoCasco) {
        this.tipoCasco = tipoCasco;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTonelaje Máx: " + tonelajeMaximo + " t | Tipo de Casco: " + tipoCasco;
    }
}