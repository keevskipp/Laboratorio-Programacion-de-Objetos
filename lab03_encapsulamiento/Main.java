package lab03_encapsulamiento;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Transporte Multimodal ===\n");

        // 1. Crear objetos
        Automovil auto = new Automovil("Toyota", "Corolla", 2022, 180.0, 4, false);
        Avion avion = new Avion("Boeing", "737", 2019, 850.0, 12000.0, "Aeroméxico");
        Barco barco = new Barco("Ferretti", "550", 2020, 45.0, 30.5, "Fibra de vidrio");

        // 2. Imprimir información inicial
        System.out.println("-- Automovil --");
        auto.describir();
        System.out.println("\n-- Avion --");
        avion.describir();
        System.out.println("\n-- Barco --");
        barco.describir();
        
        System.out.println("\n--- PRUEBA DE VALIDACIONES ---");
        
        // 3. Probar validaciones con errores a propósito
        auto.setAnio(1800);        // Error: Año muy antiguo
        auto.setNumPuertas(10);    // Error: Puertas inválidas
        avion.setAltitudMaxima(-500); // Error: Altitud negativa
        
        System.out.println("\n--- DESPUÉS DE CORREGIR DATOS ---");
        
        // 4. Corregir valores con datos válidos
        auto.setAnio(2023);
        auto.setNumPuertas(2);
        
        // Volver a imprimir para ver los cambios
        System.out.println("-- Automovil Actualizado --");
        auto.describir();
    }
}