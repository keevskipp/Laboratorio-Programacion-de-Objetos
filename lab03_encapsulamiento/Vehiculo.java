package lab03_encapsulamiento;

public class Vehiculo {
    // 1. Atributos con modificadores de acceso
    private String marca;
    private String modelo;
    private int anio;
    protected double velocidadMax; // protected: las subclases pueden acceder a él

    // 2. Constructor
    public Vehiculo(String marca, String modelo, int anio, double velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        

        setAnio(anio);
        setVelocidadMax(velocidadMax);
    }

    // 3. Getters para todos los atributos
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public double getVelocidadMax() {
        return velocidadMax;
    }

    // 4. Setters con validación (solo para anio y velocidadMax)
    public void setAnio(int anio) {
        if (anio >= 1885 && anio <= 2100) {
            this.anio = anio;
        } else {
            System.out.println("Error: año no válido. Debe estar entre 1885 y 2100.");
        }
    }

    public void setVelocidadMax(double velocidadMax) {
        if (velocidadMax > 0) {
            this.velocidadMax = velocidadMax;
        } else {
            System.out.println("Error: la velocidad máxima debe ser mayor a 0.");
        }
    }

    // 5. Método describir()
    public void describir() {
        System.out.println(this.toString());
    }

    // 6. Sobreescritura de toString()
    @Override
    public String toString() {
        return "Marca: " + marca + " | Modelo: " + modelo + " | Año: " + anio + " | Vel. Máx: " + velocidadMax + " km/h";
    }
}