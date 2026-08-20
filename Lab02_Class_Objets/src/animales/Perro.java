package animales;

public class Perro extends Animal {
    private String raza;
    private boolean estaVacunado;

    public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) {
        super(nombre, edad, peso);
        this.raza = raza;
        this.estaVacunado = estaVacunado;
    }

    public void ladrar() {
        System.out.println(getNombre() + " dice: ¡Guau guau!");
    }

    public void buscarPelota() {
        System.out.println(getNombre() + " esta buscando la pelota...");
    }

    @Override
    public String toString() {
        String estadoVacuna = estaVacunado ? "Si" : "No";
        return super.toString() + " | Raza: " + raza + " | Vacunado: " + estadoVacuna;
    }
}