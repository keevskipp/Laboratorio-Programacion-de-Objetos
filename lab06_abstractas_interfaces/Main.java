public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG — Expansión: Nuevas Clases ===\n");

        // Creacion de objetos
        Druida druida = new Druida("Sylva", 7, 200, 180, 120, "Oso");
        Nigromante nigromante = new Nigromante("Malachar", 6, 280, 220, 15);
        Bardo bardo = new Bardo("Finnian", 5, 150, 60, "laúd");

        // Polimorfismo
        System.out.println("-- Ataques y daño --");
        Personaje[] equipo = { druida, nigromante, bardo };
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Daño: " + p.calcularDanio());
        }

        System.out.println("\n-- Solo los Hechiceros lanzan hechizos --");
        for (Personaje p : equipo) {
            if (p instanceof Hechicero) {
                Hechicero h = (Hechicero) p; // Casteo
                h.lanzarHechizo();
            }
        }

        System.out.println("\n-- Solo los Sanadores curan --");
        // Reducimos la vida del nigromante para demostrar curación
        nigromante.recibirDanio(230); 
        
        for (Personaje p : equipo) {
            if (p instanceof Sanador) {
                Sanador s = (Sanador) p;
                s.curarAliado(nigromante);
            }
        }

        System.out.println("\n-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p.toString());
        }
    }
}