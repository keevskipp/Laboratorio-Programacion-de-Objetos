public class Guerrero extends Personaje {
    private int fuerza;

    public Guerrero(String nombre, int nivel, int hp, int fuerza, String armadura) {
        super(nombre, nivel, hp);
        this.fuerza = fuerza;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " golpea con su espada causando " + fuerza + " de daño físico!");
    }

    @Override
    public int calcularDanio() {
        return fuerza * getNivel();
    }
}