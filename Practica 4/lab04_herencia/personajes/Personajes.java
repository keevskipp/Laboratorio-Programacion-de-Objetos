package personajes;

import skills.Combatiente;

public class Personajes implements Combatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personajes(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void recibirDanio(int danio) {
        this.puntosVida -= danio;
        if (this.puntosVida <= 0) {
            this.puntosVida = 0;
            this.estaVivo = false;
        }
        
        System.out.println(this.nombre + " recibe " + danio + " puntos de daño. Vida restante: " + this.puntosVida);
        
        if (!this.estaVivo) {
            System.out.println(this.nombre + " ha sido derrotado.");
        }
    }

    @Override
    public void atacar() {
        System.out.println("[" + this.nombre + "] ataca con un golpe básico.");
    }

    @Override
    public void defender() {
        System.out.println("[" + this.nombre + "] se pone en guardia.");
    }

    @Override
    public String toString() {
        String estado = estaVivo ? "Sí" : "No";
        return "Nombre: " + nombre + " | Nivel: " + nivel + " | Vida: " + puntosVida + " | Vivo: " + estado;
    }
}
