public class PersonajeDerrotadoException extends RpgException {

    private String nombrePersonaje;

    public PersonajeDerrotadoException(String nombrePersonaje) {
        super("El personaje '" + nombrePersonaje +
              "' está derrotado y no puede realizar esta acción.");
        this.nombrePersonaje = nombrePersonaje;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }
}
