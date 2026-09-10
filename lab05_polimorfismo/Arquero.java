public class Arquero extends Personaje {
    private int flechasDisponibles;
    private int precision;

    public Arquero(String nombre, int nivel, int hp, String arma, int flechasDisponibles, int precision) {
        super(nombre, nivel, hp);
        this.flechasDisponibles = flechasDisponibles;
        this.precision = precision;
    }

    @Override
    public void atacar() {
        super.atacar();
        if (flechasDisponibles > 0) {
            flechasDisponibles--;
            System.out.println(getNombre() + " dispara una flecha. Flechas restantes: " + flechasDisponibles);
        } else {
            System.out.println(getNombre() + " no tiene flechas e intenta golpear con su arco.");
        }
    }

    @Override
    public int calcularDanio() {
        return precision * flechasDisponibles;
    }
}