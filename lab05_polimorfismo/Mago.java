public class Mago extends Personaje {
    private int mana;
    private String tipoMagia;

    public Mago(String nombre, int nivel, int hp, int mana, String tipoMagia) {
        super(nombre, nivel, hp);
        this.mana = mana;
        this.tipoMagia = tipoMagia;
    }

    @Override
    public void atacar() {
        super.atacar();
        System.out.println("¡" + getNombre() + " lanza magia de " + tipoMagia + " causando " + mana + " de daño mágico!");
    }

    @Override
    public int calcularDanio() {
        return mana * getNivel();
    }
}