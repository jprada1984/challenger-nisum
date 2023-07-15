package cl.nisum.challenger.userms.api.error_handler;

import cl.nisum.challenger.userms.api.model.response.ErrorResponse;
import cl.nisum.challenger.userms.util.exception.IdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author pradatech
 */
@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestHandler {

    @ExceptionHandler(IdNotFoundException.class)
    public ErrorResponse handlerIdNotFound(IdNotFoundException exception){
        return ErrorResponse.builder().mensaje(exception.getMessage()).build();
    }

}
