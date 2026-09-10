package personajes;

public class Arquero extends Personajes {
    private double precision;
    private int flechasDisponibles;

    public Arquero(String nombre, int nivel, int puntosVida, double precision, int flechasDisponibles) {
        super(nombre, nivel, puntosVida);
        this.precision = precision;
        this.flechasDisponibles = flechasDisponibles;
    }

    public double getPrecision() {
        return precision;
    }

    public int getFlechasDisponibles() {
        return flechasDisponibles;
    }

    @Override
    public void atacar() {
        if (flechasDisponibles <= 0) {
            System.out.println("[" + getNombre() + "] no tiene flechas disponibles.");
            return;
        }
        System.out.println("[" + getNombre() + "] dispara una flecha con precisión del " + precision + "%.\n");
        this.flechasDisponibles--;
    }

    @Override
    public void defender() {
        System.out.println(getNombre() + " se desplaza ágilmente esquivando el ataque.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Clase: Arquero";
    }
}
