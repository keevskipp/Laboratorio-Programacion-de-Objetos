package lab10_concurrencia;

public class CombateConcurrente implements Runnable {

    private String           nombre;
    private Personaje        atacante;
    private Personaje        defensor;
    private TablaResultados  resultados;

    public CombateConcurrente(String nombre, Personaje atacante, Personaje defensor, TablaResultados resultados) {
        this.nombre     = nombre;
        this.atacante   = atacante;
        this.defensor   = defensor;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        System.out.println("[" + nombre + "] INICIO — " +
                           atacante.getNombre() + " vs " +
                           defensor.getNombre());

        int ronda = 1;

        while (atacante.isEstaVivo() && defensor.isEstaVivo()) {

            System.out.println("[" + nombre + "] Ronda " + ronda);

            try {
                // Simula que el combate tarda un tiempo
                Thread.sleep(500);

                atacante.atacar();
                // Nota: Asegúrate de que los métodos calcularDanio() y recibirDanio() 
                // existan en tus clases de laboratorios anteriores. Si usaste otros nombres, ajústalos.
                int danio = 150; // Valor simulado, reemplaza con: atacante.calcularDanio(); si lo tienes implementado
                defensor.recibirDanio(danio);

            } catch (Exception e) { // Cambiado a Exception genérica si RpgException no está definida aquí
                System.out.println("[" + nombre + "] ⚠ Error en combate: " + e.getMessage());
                break;

            } 

            ronda++;
        }

        // Determinar ganador y registrar en la tabla compartida
        String ganador = atacante.isEstaVivo() ? atacante.getNombre() : defensor.getNombre();

        String registro = nombre + " → Ganador: " + ganador + " (rondas: " + ronda + ")";

        resultados.registrar(registro);

        System.out.println("[" + nombre + "] FIN — " + ganador + " gana.");
    }
}