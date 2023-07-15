package cl.nisum.challenger.userms.util.exception;

/**
 * @author pradatech
 */
public class IdNotFoundException extends  RuntimeException{
    private static final String ERROR_MESSAGE= "Identificador del usuario no existe";

    public IdNotFoundException(){
        super(ERROR_MESSAGE);
    }
}
