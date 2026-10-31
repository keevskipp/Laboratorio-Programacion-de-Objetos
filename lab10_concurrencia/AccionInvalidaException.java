public class AccionInvalidaException extends RpgException {

    public AccionInvalidaException(String accion, String razon) {
        super("Acción inválida '" + accion + "': " + razon);
    }
}
