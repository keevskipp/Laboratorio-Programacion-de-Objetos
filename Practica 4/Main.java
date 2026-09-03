public class Main {
    public static void main(String[] args) {
        Guerrero guerrero = new Guerrero("guerrero", 5, 140, 85, "Cota de Malla");
        Mago mago = new Mago("mago", 8, 180, 120, "Fuego");
        Arquero arquero = new Arquero("arquero", 6, 120, 95.0, 30);

        System.out.println("=== Batalla RPG ===\n");

        System.out.println("-- Ronda 1: Ataques --");
        guerrero.atacar();
        mago.atacar();
        arquero.atacar();

        System.out.println("-- Ronda 2: Defensas --");
        guerrero.defender();
        mago.defender();
        arquero.defender();
        System.out.println();

        System.out.println("-- Daño recibido --");
        guerrero.recibirDanio(60);
        mago.recibirDanio(200);
        System.out.println();

        System.out.println("-- Estado final --");
        System.out.println(guerrero.toString());
        System.out.println(mago.toString());
        System.out.println(arquero.toString());
    }
}