package restful.booker;

import com.google.gson.Gson;
import restful.booker.service.BookingService;

public class Base {
    public static final Gson gson = new Gson();

    protected BookingService bookingService = new BookingService();
}
