package cl.nisum.challenger.userms.api.error_handler;

import cl.nisum.challenger.userms.api.model.response.ErrorResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author pradatech
 */
@RestControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IntenalErrorHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    protected ErrorResponse handleDataIntegrityViolation(DataIntegrityViolationException ex,
                                                         WebRequest request) {

        return ErrorResponse.builder().mensaje("El correo ya está registrado.").build();
    }
}
