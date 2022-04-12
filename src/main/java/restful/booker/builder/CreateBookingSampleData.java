package restful.booker.builder;

import restful.booker.model.Bookingdate;
import restful.booker.model.request.CreateBookingRequest;

public class CreateBookingSampleData {

    public static CreateBookingRequest.CreateBookingRequestBuilder createBookingRequestBuilder(){

        return CreateBookingRequest.builder()
        .firstname("Jim")
        .lastname("Brown")
        .totalprice(111)
        .depositpaid(true)
        .bookingdates(Bookingdate.builder()
                .checkin("2018-01-01")
                .checkout("2019-01-01")
                .build())
        .additionalneeds("Breakfast");
    }
}
