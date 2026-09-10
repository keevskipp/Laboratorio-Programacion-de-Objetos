import java.util.ArrayList;

public class GestorBatalla {
    private ArrayList<String> historial;

    public GestorBatalla() {
        this.historial = new ArrayList<>();
    }

    // Sobrecarga 1: Un solo atacante
    public void ejecutarAtaque(Personaje atacante) {
        int danio = atacante.calcularDanio();
        atacante.atacar();
        String evento = atacante.getNombre() + " atacó solo (daño: " + danio + ")";
        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca solo → daño: " + danio);
        historial.add(evento);
    }

    // Sobrecarga 2: Atacante vs Defensor
    public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
        int danio = atacante.calcularDanio();
        System.out.println("[BATALLA] " + atacante.getNombre() + " ataca a " + defensor.getNombre() + " → daño: " + danio);
        atacante.atacar();
        defensor.defender();
        defensor.recibirDanio(danio);
        
        String estadoDefensor = (defensor.getHp() == 0) ? " - " + defensor.getNombre() + " derrotado" : "";
        String evento = atacante.getNombre() + " atacó a " + defensor.getNombre() + " (daño: " + danio + ")" + estadoDefensor;
        historial.add(evento);
    }

    // Sobrecarga 3: Equipo ataca
    public void ejecutarAtaque(Personaje[] equipo) {
        System.out.println("[BATALLA] Equipo completo ataca → " + equipo.length + " personajes");
        StringBuilder nombres = new StringBuilder();
        
        for (int i = 0; i < equipo.length; i++) {
            equipo[i].atacar();
            nombres.append(equipo[i].getNombre());
            if (i < equipo.length - 1) nombres.append(", ");
        }
        
        historial.add("Ataque en equipo: " + nombres.toString());
    }

    public void mostrarHistorial() {
        System.out.println("\n-- Historial --");
        for (int i = 0; i < historial.size(); i++) {
            System.out.println((i + 1) + ". " + historial.get(i));
        }
    }

    public void limpiarHistorial() {
        historial.clear();
    }
}