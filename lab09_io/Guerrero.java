package lab09_io;

public class Guerrero extends Personaje {

    // 1. Declarar los atributos que faltaban
    private String arma;
    private int danoArma;

    // Constructor
    public Guerrero(String nombre, int nivel, int puntosVida, String arma, int danoArma) {
        super(nombre, nivel, puntosVida);
        this.arma = arma;
        this.danoArma = danoArma;
    }

    // Getters opcionales por si los necesitas
    public String getArma() { return arma; }
    public int getDanoArma() { return danoArma; }

    // 2. Implementar atacar() SIN llamar a super.atacar()
    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con " + arma + " causando " + danoArma + " de daño.");
    }
}