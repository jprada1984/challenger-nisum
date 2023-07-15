package cl.nisum.challenger.userms.api.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author pradatech
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class ErrorResponse {
    private String mensaje;
}
