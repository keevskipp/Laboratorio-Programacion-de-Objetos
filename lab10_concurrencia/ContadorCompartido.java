public class ContadorCompartido {

    private int contador = 0;

    // SIN synchronized — puede dar resultados incorrectos
    public void incrementar() {
        contador++;
    }

    // CON synchronized — seguro entre hilos
    public synchronized void incrementarSeguro() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void resetear() {
        contador = 0;
    }
}