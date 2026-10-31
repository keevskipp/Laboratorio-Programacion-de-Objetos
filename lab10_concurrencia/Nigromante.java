public class Nigromante extends Personaje {

    private int mana;
    private int poderHechizo;

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int poderHechizo) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderHechizo = poderHechizo;
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con magia oscura causando " + calcularDanio() + " de daño.");
    }

    @Override
    public int calcularDanio() {
        return mana + poderHechizo + nivel * 15;
    }
}