package restful.booker;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.testng.annotations.BeforeClass;
import restful.booker.service.BookingService;

import static io.restassured.RestAssured.given;
import static restful.booker.helper.Config.BOOKING_SERVICE_URL;

public class Base {
    public static final Gson gson = new Gson();

    protected BookingService bookingService = new BookingService();
    protected Faker faker = new Faker();

    @BeforeClass
    public static void setUpClass() {
        shouldBeHealthy();
    }

    private static void shouldBeHealthy() {
        given()
                .get(BOOKING_SERVICE_URL + "/ping").then()
                .assertThat()
                .statusCode(201);
    }

}
