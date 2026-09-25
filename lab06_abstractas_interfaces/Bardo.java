public class Bardo extends Personaje implements Sanador {
    private int poderCuracion;
    private String instrumento; 

    public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion, String instrumento) {
        super(nombre, nivel, puntosVida);
        this.poderCuracion = poderCuracion;
        this.instrumento = instrumento;
    }

    @Override
    public void atacar() {
        System.out.print("[" + nombre + "] aturde con su " + instrumento + ". ");
    }

    @Override
    public int calcularDanio() {
        return nivel * 8 + 15; // Daño base del bardo
    }

    @Override
    public void curarAliado(Personaje aliado) {
        if (aliado.isEstaVivo()) {
            aliado.puntosVida += poderCuracion;
            System.out.println(nombre + " entona una melodía y cura a " + aliado.getNombre() + " +" + poderCuracion + ". Vida: " + aliado.getPuntosVida());
        }
    }

    @Override
    public int getPoderCuracion() {
        return poderCuracion;
    }
}