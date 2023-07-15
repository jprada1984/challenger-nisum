package cl.nisum.challenger.userms.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author pradatech
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhoneRequest{
    private String number;
    private String cityCode;
    private String countryCode;
}
