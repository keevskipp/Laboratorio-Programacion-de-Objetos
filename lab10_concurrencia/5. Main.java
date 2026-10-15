package lab10_concurrencia;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Gran Torneo del Gremio ===\n");

        // BLOQUE 1 — Torneo con 3 combates simultáneos
        TablaResultados tabla = new TablaResultados();
        
        Personaje s1 = new Druida("Sylva", 10, 300, 100);
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10);
        Personaje t1 = new Guerrero("Thorin", 9, 400, "Hacha", 80);
        Personaje b1 = new Druida("Brego", 7, 250, 80);
        Personaje k1 = new Nigromante("Kael", 5, 180, 90);

        CombateConcurrente c1 = new CombateConcurrente("Campo-1", s1, m1, tabla);
        CombateConcurrente c2 = new CombateConcurrente("Campo-2", l1, t1, tabla);
        CombateConcurrente c3 = new CombateConcurrente("Campo-3", b1, k1, tabla);

        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        h1.start();
        h2.start();
        h3.start();

        // BLOQUE 2 — Monitor del torneo (hilo independiente)
        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        // BLOQUE 3 — Esperar a que todos terminen con join()
        try {
            h1.join();   // espera a que Campo-1 termine
            h2.join();   // espera a que Campo-2 termine
            h3.join();   // espera a que Campo-3 termine
            monitor.join(); // espera a que el monitor termine
        } catch (InterruptedException e) {
            System.out.println("Espera interrumpida.");
        }

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        // BLOQUE 4 — Demostración de race condition
        System.out.println("\n=== Demostración de Race Condition ===");
        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

        // Sin synchronized
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementar();
            });
            hilos[i].start();
        }
        
        try {
            for (Thread t : hilos) t.join();
        } catch (InterruptedException e) { }
        
        System.out.println("Sin sync  — esperado: 5000 | real: " + contador.getContador());

        // Con synchronized
        contador.resetear();
        for (int i = 0; i < 5; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) contador.incrementarSeguro();
            });
            hilos[i].start();
        }

        try {
            for (Thread t : hilos) t.join();
        } catch (InterruptedException e) { }
        
        System.out.println("Con sync  — esperado: 5000 | real: " + contador.getContador());
    }
}