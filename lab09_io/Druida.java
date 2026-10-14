package lab09_io;
import lab06_abstractas_interfaces.Hechicero;
import lab06_abstractas_interfaces.Sanador;

public class Druida extends Personaje implements Hechicero, Sanador {
    private int mana;
    private int poderCuracion;
    private String formaNatural;

    public Druida(String nombre, int nivel, int puntosVida, int mana, int poderCuracion, String formaNatural) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        this.poderCuracion = poderCuracion;
        this.formaNatural = formaNatural;
    }


    public Druida(String nombre, int nivel, int puntosVida, int mana) {
    super(nombre, nivel, puntosVida); 
    this.mana = mana; // Asegúrate de usar el nombre de atributo correcto de tu clase
    }

    @Override
    public void atacar() {
        System.out.print("[" + nombre + "] ataca en su forma de " + formaNatural + " e invoca raíces del bosque. ");
    }

    @Override
    public int calcularDanio() {
        return nivel * 15 + 20; // Cálculo personalizado
    }

    @Override
    public void lanzarHechizo() {
        System.out.println(nombre + " lanza: ¡Tormenta de espinas! (maná: " + mana + ")");
    }

    @Override
    public int getMana() {
        return mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (aliado.isEstaVivo()) {
            aliado.puntosVida += poderCuracion; // Acceso directo porque es protected
            System.out.println(nombre + " toca la tierra y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
        } else {
            System.out.println(nombre + " no puede curar a " + aliado.getNombre() + " porque ha sido derrotado.");
        }
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}