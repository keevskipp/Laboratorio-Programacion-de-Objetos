public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Demostración de Polimorfismo ===\n");

        // 3a — Variable de tipo padre apunta a objeto hijo
        Personaje p1 = new Guerrero("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("-- calcularDanio() por tipo --");
        System.out.println("Thorin  (Guerrero) daño: " + p1.calcularDanio());
        System.out.println("Gandalf (Mago)     daño: " + p2.calcularDanio());
        System.out.println("Legolas (Arquero)  daño: " + p3.calcularDanio() + "\n");

        // 3b — Arreglo polimórfico
        System.out.println("-- Arreglo polimórfico --");
        Personaje[] equipo = { p1, p2, p3 };
        for (Personaje p : equipo) {
            p.atacar();
        }
        System.out.println();

        // 3c — Usar GestorBatalla con las tres sobrecargas
        System.out.println("-- GestorBatalla --");
        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutarAtaque(p1);                // Versión 1
        gestor.ejecutarAtaque(p2, p3);            // Versión 2
        gestor.ejecutarAtaque(equipo);            // Versión 3
        gestor.mostrarHistorial();

        // 3d — Identificar tipo real con instanceof
        System.out.println("\n-- instanceof --");
        for (Personaje p : equipo) {
            if (p instanceof Guerrero) {
                System.out.println(p.getNombre() + " es un Guerrero.");
            } else if (p instanceof Mago) {
                System.out.println(p.getNombre() + " es un Mago.");
            } else if (p instanceof Arquero) {
                System.out.println(p.getNombre() + " es un Arquero.");
            }
        }

        // Parte 4 — Demostración de la sobrecarga adicional
        System.out.println("\n-- Sobrecarga Adicional (mostrarEstado) --");
        p1.mostrarEstado();                       // Versión 1 (Básica)
        p1.mostrarEstado(true);                   // Versión 2 (Booleana)
        p1.mostrarEstado("Info_Sistema");       // Versión 3 (String)
    }
}