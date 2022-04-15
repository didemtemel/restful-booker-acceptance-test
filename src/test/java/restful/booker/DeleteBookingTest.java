package restful.booker;

import org.testng.annotations.Test;
import restful.booker.builder.CreateTokenSampleData;
import restful.booker.builder.UpdateBookingSampleData;
import restful.booker.helper.DataGenerator;
import restful.booker.model.response.BookingResponse;
import restful.booker.model.response.TokenResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteBookingTest extends Base{

    @Test
    public void it_should_delete_booking_by_id() {

        //Given: prepare requirements
        Integer bookingId = 26;

        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send delete booking by id request
        var readableResponse = bookingService.deleteBooking(token, bookingId);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(201);

    }

    @Test
    public void it_should_return_403_when_token_is_invalid_while_deleting_booking() {

        //Given: prepare requirements
        Integer bookingId = 21;

        var updateBookingRequest = UpdateBookingSampleData.updateBookingRequestBuilder().build();
        String token = DataGenerator.randomString(10);

        //When: send update booking request
        var readableResponse = bookingService.deleteBooking(token, bookingId);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(403);
        assertThat(readableResponse.getResponse().getStatusLine()).isEqualTo("HTTP/1.1 403 Forbidden");

    }
}
