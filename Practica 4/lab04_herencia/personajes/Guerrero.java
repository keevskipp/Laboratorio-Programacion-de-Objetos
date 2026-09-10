package personajes;
public class Guerrero extends Personajes {
    private int fuerza;
    private String armadura;

    public Guerrero(String nombre, int nivel, int puntosVida, int fuerza, String armadura) {
        super(nombre, nivel, puntosVida);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public String getArmadura() {
        return armadura;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + fuerza + " de daño!\n");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " bloquea con su armadura de " + armadura + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Guerrero";
    }
}