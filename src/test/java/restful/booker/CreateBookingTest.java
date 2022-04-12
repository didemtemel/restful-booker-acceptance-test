package restful.booker;

import org.testng.annotations.Test;
import restful.booker.builder.CreateBookingSampleData;
import restful.booker.model.response.CreateBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBookingTest extends Base{

    @Test
    public void it_should_create_booking() {

        var bookingSampleData = CreateBookingSampleData.createBookingRequestBuilder().build();

        var readableResponse = bookingService.createBooking(gson.toJson(bookingSampleData));

        var bookingResponse = readableResponse.getResponse().as(CreateBookingResponse.class);

        assertThat(readableResponse.getStatusCode()).isEqualTo(200);

        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(bookingSampleData.getFirstname());


    }
}
