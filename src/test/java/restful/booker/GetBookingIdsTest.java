package restful.booker;

import org.testng.annotations.Test;
import restful.booker.model.response.BookingIdResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingIdsTest extends Base{

    @Test
    public void it_should_get_booking_ids() {

        var readableResponse = bookingService.getBookingIds();

        var bookingIdsResponses = readableResponse.getResponse().as(BookingIdResponse[].class);

        assertThat(readableResponse.getStatusCode()).isEqualTo(200);

    }
}
