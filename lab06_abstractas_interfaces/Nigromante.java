public class Nigromante extends Personaje implements Hechicero {
    private int mana;
    private int almasAbsorbidas; 

    public Nigromante(String nombre, int nivel, int puntosVida, int mana, int almasAbsorbidas) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.almasAbsorbidas = almasAbsorbidas;
    }

    @Override
    public void atacar() {
        System.out.print("[" + nombre + "] drena la esencia vital con sus " + almasAbsorbidas + " almas. ");
    }

    @Override
    public int calcularDanio() {
        return nivel * 10 + (almasAbsorbidas * 5); // El daño escala con las almas
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Maldición de decadencia! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }
}