package restful.booker;

import org.testng.annotations.Test;
import restful.booker.helper.DataGenerator;
import restful.booker.model.response.BookingIdResponse;
import restful.booker.model.response.BookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class GetBookingTest extends Base{

    @Test
    public void it_should_get_booking_by_id() {

        Integer bookingId = 1;
        var readableResponse = bookingService.getBooking(bookingId);

        var bookingResponse = readableResponse.getResponse().as(BookingResponse.class);

        assertThat(readableResponse.getStatusCode()).isEqualTo(200);

        assertThat(bookingResponse.getFirstname()).isEqualTo("Susan");
        assertThat(bookingResponse.getLastname()).isEqualTo("Jackson");
        assertThat(bookingResponse.getTotalprice()).isEqualTo(200);
        assertThat(bookingResponse.getDepositpaid()).isEqualTo(true);
        assertThat(bookingResponse.getBookingdates().getCheckin()).isEqualTo("2021-11-25");
        assertThat(bookingResponse.getBookingdates().getCheckout()).isEqualTo("2022-03-08");
        assertThat(bookingResponse.getAdditionalneeds()).isEqualTo("Breakfast");
    }

    @Test
    public void it_should_return_404_when_booking_id_not_found() {

        Integer bookingId = DataGenerator.randomInteger(10000,99999);
        var readableResponse = bookingService.getBooking(bookingId);

        assertThat(readableResponse.getStatusCode()).isEqualTo(404);

    }
}
