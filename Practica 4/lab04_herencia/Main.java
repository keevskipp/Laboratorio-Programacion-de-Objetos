import personajes.Arquero;
import personajes.Guerrero;
import personajes.Mago;

public class Main {
    public static void main(String[] args) {
        Guerrero thorin = new Guerrero("Thorin", 5, 140, 85, "Cota de Malla");
        Mago gandalf = new Mago("Gandalf", 8, 180, 120, "Fuego");
        Arquero legolas = new Arquero("Legolas", 6, 120, 95.0, 30);

        System.out.println("=== Batalla RPG ===\n");

        System.out.println("-- Ronda 1: Ataques --");
        thorin.atacar();
        gandalf.atacar();
        legolas.atacar();

        System.out.println("-- Ronda 2: Defensas --");
        thorin.defender();
        gandalf.defender();
        legolas.defender();
        System.out.println();

        System.out.println("-- Daño recibido --");
        thorin.recibirDanio(60);
        gandalf.recibirDanio(200); 
        System.out.println();

        System.out.println("-- Estado final --");
        System.out.println(thorin.toString());
        System.out.println(gandalf.toString());
        System.out.println(legolas.toString());
    }
}