package restful.booker.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import restful.booker.model.Bookingdate;

@Getter
@Setter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateBookingResponse {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdate bookingdates;
    private String additionalneeds;
}
