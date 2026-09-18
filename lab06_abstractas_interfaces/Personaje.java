public abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    // Getters
    public String getNombre()   { return nombre; }
    public int getNivel()       { return nivel; }
    public int getPuntosVida()  { return puntosVida; }
    public boolean isEstaVivo() { return estaVivo; }

    // Método concreto — implementación compartida por todos
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }
        System.out.println(nombre + " recibe " + danio + " de daño. Vida: " + puntosVida);
        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // Métodos abstractos — cada subclase DEBE implementarlos
    public abstract void atacar();
    public abstract int calcularDanio();

    @Override
    public String toString() {
        String vivo = estaVivo ? "Sí" : "No";
        return "Nombre: " + nombre + " | Nivel: " + nivel +
               " | Vida: " + puntosVida + " | Vivo: " + vivo;
    }
}