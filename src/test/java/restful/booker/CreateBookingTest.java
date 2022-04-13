package restful.booker;

import org.testng.annotations.Test;
import restful.booker.builder.CreateBookingSampleData;
import restful.booker.model.response.CreateBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateBookingTest extends Base{

    @Test
    public void it_should_create_booking() {

        //Given: prepare requirements
        var createBookingRequest = CreateBookingSampleData.createBookingRequestBuilder().build();

        //When: send create booking request
        var readableResponse = bookingService.createBooking(gson.toJson(createBookingRequest));
        var bookingResponse = readableResponse.getResponse().as(CreateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo(createBookingRequest.getFirstname());
        assertThat(bookingResponse.getBooking().getLastname()).isEqualTo(createBookingRequest.getLastname());
        assertThat(bookingResponse.getBooking().getTotalprice()).isEqualTo(createBookingRequest.getTotalprice());
        assertThat(bookingResponse.getBooking().getDepositpaid()).isEqualTo(createBookingRequest.getDepositpaid());
        assertThat(bookingResponse.getBooking().getBookingdates().getCheckin()).isEqualTo(createBookingRequest.getBookingdates().getCheckin());
        assertThat(bookingResponse.getBooking().getBookingdates().getCheckout()).isEqualTo(createBookingRequest.getBookingdates().getCheckout());
        assertThat(bookingResponse.getBooking().getAdditionalneeds()).isEqualTo(createBookingRequest.getAdditionalneeds());


    }
}
