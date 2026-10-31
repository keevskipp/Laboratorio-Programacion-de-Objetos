public class Druida extends Personaje {

    // 1. DECLARA LAS VARIABLES QUE FALTABAN
    private int mana;
    private int poderCuracion; // Agregada
    private String formaNatural; // Agregada

    // 2. CONSTRUCTOR (Ajustado a los 4 parámetros que envías desde el Main)
    public Druida(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
        // Valores por defecto para que no marque error
        this.poderCuracion = 50; 
        this.formaNatural = "Oso"; 
    }

    // 3. MÉTODOS DE LA CLASE
    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con furia natural.");
    }

    @Override
    public int calcularDanio() {
        return mana + poderCuracion + nivel * 10;
    }

    /*
    @Override
    public void lanzarHechizo() {
        System.out.println(getNombre() + " lanza un hechizo druídico.");
    }

    @Override
    public int getMana() {
        return this.mana;
    }

    @Override
    public void curarAliado(Personaje aliado) {
        System.out.println(getNombre() + " cura a " + aliado.getNombre());
    }

    @Override
    public int getPoderCuracion() {
        return this.poderCuracion;
    }
    */
}