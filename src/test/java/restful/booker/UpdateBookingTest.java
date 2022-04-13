package restful.booker;

import org.testng.annotations.Test;
import restful.booker.builder.CreateTokenSampleData;
import restful.booker.builder.UpdateBookingSampleData;
import restful.booker.helper.DataGenerator;
import restful.booker.model.response.TokenResponse;
import restful.booker.model.response.UpdateBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateBookingTest extends Base{

    @Test
    public void it_should_update_booking() {

        //Given: prepare requirements
        Integer bookingId = 21;
        var updateBookingRequest = UpdateBookingSampleData.updateBookingRequestBuilder().build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.updateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getFirstname()).isEqualTo(updateBookingRequest.getFirstname());
        assertThat(bookingResponse.getLastname()).isEqualTo(updateBookingRequest.getLastname());
        assertThat(bookingResponse.getTotalprice()).isEqualTo(updateBookingRequest.getTotalprice());
        assertThat(bookingResponse.getDepositpaid()).isEqualTo(updateBookingRequest.getDepositpaid());
        assertThat(bookingResponse.getBookingdates().getCheckin()).isEqualTo(updateBookingRequest.getBookingdates().getCheckin());
        assertThat(bookingResponse.getBookingdates().getCheckout()).isEqualTo(updateBookingRequest.getBookingdates().getCheckout());
        assertThat(bookingResponse.getAdditionalneeds()).isEqualTo(updateBookingRequest.getAdditionalneeds());

    }

    @Test
    public void it_should_return_403_when_token_is_invalid_while_updating_booking() {

        //Given: prepare requirements
        Integer bookingId = 21;
        var updateBookingRequest = UpdateBookingSampleData.updateBookingRequestBuilder().build();
        String token = DataGenerator.randomString(10);

        //When: send update booking request
        var readableResponse = bookingService.updateBooking(token, gson.toJson(updateBookingRequest), bookingId);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(403);
        assertThat(readableResponse.getResponse().getStatusLine()).isEqualTo("HTTP/1.1 403 Forbidden");

    }
}
