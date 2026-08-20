package animales;

public class Gato extends Animal {
    private String color;
    private boolean esInterior;

    public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
        super(nombre, edad, peso);
        this.color = color;
        this.esInterior = esInterior;
    }

    public void maullar() {
        System.out.println(getNombre() + " dice: ¡Miau!");
    }

    public void ronronear() {
        System.out.println(getNombre() + " esta ronroneando...");
    }

    @Override
    public String toString() {
        String interior = esInterior ? "Si" : "No";
        return super.toString() + " | Color: " + color + " | Interior: " + interior;
    }
}