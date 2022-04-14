package restful.booker;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import restful.booker.service.BookingService;

public class Base {
    public static final Gson gson = new Gson();

    protected BookingService bookingService = new BookingService();
    protected Faker faker = new Faker();


}
