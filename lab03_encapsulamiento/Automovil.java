package lab03_encapsulamiento;

public class Automovil extends Vehiculo {
    // 1. Atributos propios
    private int numPuertas;
    private boolean esElectrico;

    // 2. Constructor usando super()
    public Automovil(String marca, String modelo, int anio, double velocidadMax, int numPuertas, boolean esElectrico) {
        super(marca, modelo, anio, velocidadMax);
        // Validamos puertas al crear el objeto
        setNumPuertas(numPuertas); 
        this.esElectrico = esElectrico;
    }

    // 3. Getters
    public int getNumPuertas() {
        return numPuertas;
    }

    public boolean isElectrico() { // Los booleanos usan 'is' en lugar de 'get'
        return esElectrico;
    }

    // 4. Setter con validación
    public void setNumPuertas(int numPuertas) {
        if (numPuertas >= 2 && numPuertas <= 6) {
            this.numPuertas = numPuertas;
        } else {
            System.out.println("Error: número de puertas no válido. Debe ser entre 2 y 6.");
        }
    }
    
    // Setter para eléctrico (no pedía validación, pero es buena práctica tenerlo)
    public void setEsElectrico(boolean esElectrico) {
        this.esElectrico = esElectrico;
    }

    // 5. Sobreescribe toString()
    @Override
    public String toString() {
        String electricoStr = esElectrico ? "Sí" : "No";
        return super.toString() + "\nPuertas: " + numPuertas + " | Eléctrico: " + electricoStr;
    }
}