package restful.booker.model.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import restful.booker.model.Bookingdate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateBookingRequest {
    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private Bookingdate bookingdates;
    private String additionalneeds;
}
