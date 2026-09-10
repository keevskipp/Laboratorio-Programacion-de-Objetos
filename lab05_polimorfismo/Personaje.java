public class Personaje {
    private String nombre;
    private int nivel;
    private int hp;

    public Personaje(String nombre, int nivel, int hp) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.hp = hp;
    }

    public String getNombre() { return nombre; }
    public int getNivel() { return nivel; }
    public int getHp() { return hp; }

    public void atacar() {
        System.out.println("[" + nombre + "] ataca con un golpe básico.");
    }

    public void defender() {
        System.out.println(nombre + " se pone en posición de defensa.");
    }

    public void recibirDanio(int danio) {
        this.hp -= danio;
        if (this.hp < 0) this.hp = 0;
        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + this.hp);
        if (this.hp == 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    // NUEVO: Método base para calcular daño
    public int calcularDanio() {
        return nivel * 10; 
    }

    // PARTE 4: Sobrecarga adicional propia en la clase padre
    public void mostrarEstado() {
        System.out.println("Estado de " + nombre + " (Nivel: " + nivel + ", HP: " + hp + ")");
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println("=== ESTADO DETALLADO ===");
            System.out.println("Nombre: " + nombre + " | Nivel actual: " + nivel + " | Puntos de Vida: " + hp);
            System.out.println("========================");
        } else {
            mostrarEstado(); // Llama a la versión sin parámetros
        }
    }

    public void mostrarEstado(String formato) {
        System.out.println(formato + " > " + nombre + " [Lvl " + nivel + "] ♥ " + hp);
    }

    @Override
    public String toString() {
        return nombre + " (Nivel " + nivel + ")";
    }
}