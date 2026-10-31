public class MonitorTorneo extends Thread {

    private String nombreCampo;
    private int    duracionSegundos;

    public MonitorTorneo(String nombreCampo, int duracionSegundos) {
        this.nombreCampo       = nombreCampo;
        this.duracionSegundos  = duracionSegundos;
    }

    @Override
    public void run() {
        System.out.println("[Monitor] Vigilando campo: " + nombreCampo);

        for (int i = 1; i <= duracionSegundos; i++) {
            try {
                Thread.sleep(1000);   // espera 1 segundo
                System.out.println("[Monitor] " + nombreCampo +
                                   " — segundo " + i +
                                   " de " + duracionSegundos);
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Monitor interrumpido.");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("[Monitor] " + nombreCampo + " finalizado.");
    }
}