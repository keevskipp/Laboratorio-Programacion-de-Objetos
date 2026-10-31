// Excepcion NO chequeada: es un error del programador (pasar null)
public class PersonajeNuloException extends RuntimeException {

    public PersonajeNuloException(String metodo) {
        super("Se pasó un personaje nulo al método '" +
              metodo + "'. Esto es un error de programación.");
    }
}
