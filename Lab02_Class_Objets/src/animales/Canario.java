package animales;

public class Canario extends Animal {
    private String colorPlumaje;
    private boolean cantaEnJaula;

    public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) {
        super(nombre, edad, peso);
        this.colorPlumaje = colorPlumaje;
        this.cantaEnJaula = cantaEnJaula;
    }

    public void cantar() {
        System.out.println(getNombre() + " esta cantando: ♪ pi pi pi ♪");
    }

    public void volar() {
        System.out.println(getNombre() + " esta volando por la habitación.");
    }

    @Override
    public String toString() {
        String canta = cantaEnJaula ? "Sa" : "No";
        return super.toString() + " | Plumaje: " + colorPlumaje + " | Canta en jaula: " + canta;
    }
}