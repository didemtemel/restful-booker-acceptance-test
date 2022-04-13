package restful.booker.builder;

import restful.booker.model.Bookingdate;
import restful.booker.model.request.UpdateBookingRequest;

public class UpdateBookingSampleData {

    public static UpdateBookingRequest.UpdateBookingRequestBuilder updateBookingRequestBuilder(){

        return UpdateBookingRequest.builder()
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
