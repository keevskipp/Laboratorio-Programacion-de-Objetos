package personajes;
public class Mago extends Personajes {
    private int mana;
    private String escuelaMagia;

    public Mago(String nombre, int nivel, int puntosVida, int mana, String escuelaMagia) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.escuelaMagia = escuelaMagia;
    }

    public int getMana() {
        return mana;
    }

    public String getEscuelaMagia() {
        return escuelaMagia;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza una bola de fuego consumiendo " + mana + " de maná!\n");
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " invoca un escudo arcano de magia de " + escuelaMagia + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Mago";
    }
}
