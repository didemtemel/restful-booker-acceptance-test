package restful.booker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import restful.booker.builder.CreateTokenSampleData;
import restful.booker.builder.UpdateBookingSampleData;
import restful.booker.helper.DataGenerator;
import restful.booker.model.Bookingdate;
import restful.booker.model.request.UpdateBookingRequest;
import restful.booker.model.response.TokenResponse;
import restful.booker.model.response.UpdateBookingResponse;

import static org.assertj.core.api.Assertions.assertThat;

public class PartialUpdateBookingTest extends Base{

    @Test
    public void it_should_update_first_name() {

        //Given: prepare requirements
        Integer bookingId = 21;
        String firstName = faker.name().firstName();

        var updateBookingRequest = UpdateBookingRequest.builder().firstname(firstName).build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getFirstname()).isEqualTo(updateBookingRequest.getFirstname());
    }

    @Test
    public void it_should_update_last_name() {

        //Given: prepare requirements
        Integer bookingId = 21;
        String lastName = faker.name().lastName();

        var updateBookingRequest = UpdateBookingRequest.builder().lastname(lastName).build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getLastname()).isEqualTo(updateBookingRequest.getLastname());
    }

    @Test
    public void it_should_update_total_price() {

        //Given: prepare requirements
        Integer bookingId = 21;
        Integer totalPrice = faker.number().numberBetween(10,100);

        var updateBookingRequest = UpdateBookingRequest.builder().totalprice(totalPrice).build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getTotalprice()).isEqualTo(updateBookingRequest.getTotalprice());
    }

    @Test
    public void it_should_update_deposit_paid() {

        //Given: prepare requirements
        Integer bookingId = 21;
        Boolean depositPaid = true;

        var updateBookingRequest = UpdateBookingRequest.builder().depositpaid(depositPaid).build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getDepositpaid()).isEqualTo(updateBookingRequest.getDepositpaid());
    }

    @Test
    public void it_should_update_additional_needs() {

        //Given: prepare requirements
        Integer bookingId = 21;
        String additionalNeeds = faker.harryPotter().quote();

        var updateBookingRequest = UpdateBookingRequest.builder().additionalneeds(additionalNeeds).build();
        var createTokenRequest= CreateTokenSampleData.createTokenRequestBuilder().build();

        var  readableTokenResponse = bookingService.createToken(gson.toJson(createTokenRequest));
        String token = readableTokenResponse.getResponse().as(TokenResponse.class).getToken();

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);
        var bookingResponse = readableResponse.getResponse().as(UpdateBookingResponse.class);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(200);
        assertThat(bookingResponse.getAdditionalneeds()).isEqualTo(updateBookingRequest.getAdditionalneeds());
    }

    @Test
    public void it_should_return_403_when_token_is_invalid_while_updating_booking() {

        //Given: prepare requirements
        Integer bookingId = 21;
        var updateBookingRequest = UpdateBookingSampleData.updateBookingRequestBuilder().build();
        String token = DataGenerator.randomString(10);

        //When: send update booking request
        var readableResponse = bookingService.partialUpdateBooking(token, gson.toJson(updateBookingRequest), bookingId);

        //Then: make assertions
        assertThat(readableResponse.getStatusCode()).isEqualTo(403);
        assertThat(readableResponse.getResponse().getStatusLine()).isEqualTo("HTTP/1.1 403 Forbidden");

    }
}
